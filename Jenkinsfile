node{
  stage('SCM checkout'){   
  git 'https://github.com/Dibyajitdj/CorseraWebAutomation'
  }
  stage('Compile-Package'){
    def mvnhome = tool name: '', type: 'maven'
    sh "${mvnhome}/bin/mvn package"
  }
}
