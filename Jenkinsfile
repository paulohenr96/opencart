pipeline {

  agent any
  tools{
    maven 'MyMaven'
  }
  environment {
    NEW_VERSION='1.3.0'
  }
  stages {
    stage("build"){
      steps{
        echo 'building the application...'
        bat "mvn clean install"
      
      }
    }

    
    stage("test"){
      when{
        expression {
          BRANCH_NAME=='main' || BRANCH_NAME=='build'
        }
      }
      steps{
        bat 'mvn test'
      
      }
    }

    
    stage("deploy"){
      steps{
        echo 'deploying the application...'
      
      }
    }
  
  }


}
