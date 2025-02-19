#!/usr/bin/env groovy

pipeline {
    agent any
    parameters{
        booleanParam(name: 'executeTest', defaultValue: true, description: 'Execute Test?')
        choice(name: 'Version', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Version to deploy')
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            steps {
                if (params.executeTest) {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    echo "Deploying version ${params.Version}"
                }
            }
        }
    }
}
