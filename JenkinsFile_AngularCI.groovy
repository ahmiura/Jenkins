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
                //sh 'export PATH=$PATH:/usr/local/bin'
                nodejs(nodeJSInstallationName: 'Node 8.x', configId: '73c7e55b-1ed5-4573-88a1-da3f66448d73') {
                    sh 'npm install'
                }
                
            }
        }
    }
}
