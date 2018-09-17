#!groovy
pipeline {
    agent any
    environment {
        PATH = "/usr/local/bin:$PATH"
    }
    stages {
        stage('Checkout - Git') {
            //checkout scm
            steps {
                deleteDir()

                git branch: 'release-candidate-1.0.0',
                    credentialsId: 'Id_credential_jenkins',
                    url: 'https://github.com/ahmiura/angular_alurapic.git'

                sh "ls -lat"
            }
        }
        
        stage('NPM') {
            steps {
                sh 'npm install'
                //nodejs(nodeJSInstallationName: 'Node 8.x', configId: '73c7e55b-1ed5-4573-88a1-da3f66448d73') {
                //    sh 'npm install'
                //}
                
            }
        }

        stage('Test') {
            steps {
                sh 'ng test --progress=false --watch false'

            }
                
        }
        
    }
}
