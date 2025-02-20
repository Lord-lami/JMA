#!/usr/bin/env groovy
def gv
def selectedEnv1
// def selectedEnv2

pipeline {
    agent any
    parameters{
        booleanParam(name: 'executeTest', defaultValue: true, description: 'Execute Test?')
        choice(name: 'Version', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Version to deploy')
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load('script.groovy')
                }
            }
        }
        stage('build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('test') {
            steps {
                script{
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            // input {
            //     message "What environment do you want to deploy to?"
            //     id 'environment'
            //     ok "Deploy!"
            //     parameters {
            //         choice(name: 'Env', choices: ['dev', 'test', 'prod'], description: 'Environment to deploy to')
            //     }
            steps {
                script {
                    selectedEnv = input(
                        message: "What environment do you want to deploy to?",
                        parameters: [
                            choice(name: 'Env1', choices: ['dev', 'test', 'prod'], description: 'First Environment to deploy to')
                            choice(name: 'Env2', choices: ['dev', 'test', 'prod'], description: 'Second Environment to deploy to')
                        ]
                    )
                    gv.deployApp()
                    echo "Deploying to " + selectedEnv['Env1']
                    echo "Deploying to " + selectedEnv['Env2']
                }
            }
        }
    }
}
