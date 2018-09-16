#!groovy

pipeline {
    agent any

    stages {
        stage('Checkout - Git') {
            //checkout scm
            steps {
                git branch: 'release-candidate-1.0.0',
                    credentialsId: 'Id_credential_jenkins',
                    url: 'https://github.com/ahmiura/angular_alurapic.git'

                sh "ls -lat"
            }
        }
        
        stage('NPM') {
            steps {
                sh 'export PATH=$PATH:/usr/local/bin'
                sh 'id'
                sh 'pwd'
                sh 'npm -v'
                sh 'npm install '
            }
        }
    }
}
