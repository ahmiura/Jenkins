#!groovy
pipeline {
    agent any
    environment {
        PATH = "/usr/local/bin:$PATH"
    }
    stages {
        stage('Checkout - Git') {
            steps {
                checkout scm
            }
    
            /*steps {
                deleteDir()

                git branch: 'release-candidate-1.0.0',
                    credentialsId: 'Id_credential_jenkins',
                    url: 'https://github.com/ahmiura/angular_alurapic.git'

                sh "ls -lat"
            }*/
        }
        
        stage('npm install') {
            steps {
                sh 'npm install'
            }
        }

        stage('Test') {
            steps {
                sh 'ng test --progress=false --watch false'
            }
                
        }
        
    }
}
