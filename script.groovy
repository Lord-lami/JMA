def buildApp() {
    echo('Building the application...')
}

def testApp() {
    if (params.executeTest) {
        echo "Testing the application..."
    }
}

def deployApp() {
    echo "Deploying the application..."
    echo "Deploying version ${params.Version}"
}

return this
