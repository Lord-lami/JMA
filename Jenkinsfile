#!/usr/bin/env groovy
def gv
 def Env

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
            steps {
               
                script {
                    Env = input (
                        message: "What environment do you want to deploy to?",
                        ok: "Deployed!",
                        parameters [
                            choice(name: 'Env', choices: ['dev', 'test', 'prod'], description: 'Environment to deploy to')
                        ]
                    )
                    gv.deployApp()
                    echo "Deploying to ${Env}"
                }
            }
        }
    }
}
