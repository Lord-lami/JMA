def buildApp() {
    echo('Building the application...')
}

def testApp() {
    echo "On the pipeline of " + env.BRANCH_NAME
    if (params.executeTest) {
        echo "Testing the application..."
    }
}

def deployApp() {
    selectedEnv = input(
        message: "What environment do you want to deploy to?",
        parameters: [
            choice(name: 'Env1', choices: ['dev', 'test', 'prod'], description: 'First Environment to deploy to'),
            choice(name: 'Env2', choices: ['dev', 'test', 'prod'], description: 'Second Environment to deploy to')
        ]
    )
    echo "Deploying the application..."
    echo "Deploying version ${params.Version}"
    echo "Deploying to " + selectedEnv['Env1']
    echo "Deploying to " + selectedEnv['Env2']
}

return this
