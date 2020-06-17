pipeline{
    agent any
    
    tools {
        maven "my_maven_3.3.9"
    }
    
    stages {
        stage ("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
