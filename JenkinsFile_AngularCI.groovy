#!groovy

pipeline {
    agent any

    stages {
        stag('Checkout - Git') {
            checkout scm
        }
        stage('NPM') {
            steps {
                sh 'npm install '
            }
        }
    }
}