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

        stage('test') {
            steps {
                script{
                    gv.testApp()
                }
            }
        }
        
        stage('build') {
             when {
                expression {
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        
        stage('deploy') {
            when {
                expression {
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
