#!groovy

pipeline {
    agent any

    stages {
        stage('Checkout - Git') {
<<<<<<< HEAD
            checkout scm
=======
            //checkout scm
            steps {
                git branch: 'release-candidate-1.0.0',
                    credentialsId: 'Id_credential_jenkins',
                    url: 'https://github.com/ahmiura/angular_alurapic.git'

                sh "ls -lat"
            }
>>>>>>> f80ec81320ae2218bc4cfbcbe744bbb702643eef
        }
        
        stage('NPM') {
            steps {
                sh 'npm install '
            }
        }
    }
}
