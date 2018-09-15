#!groovy

pipeline {
    agent any

    stages {
        stage('Checkout - Git') {
            checkout scm
        }
        stage('NPM') {
            steps {
                sh 'npm install '
            }
        }
    }
}
