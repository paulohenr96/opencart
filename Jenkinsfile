pipeline {

  agent any
  tools{
    maven 'MyMaven'
  }
  environment {
    APP_VERSION='4.1.0.0'
  }
  stages {
    stage('Checkout'){
		steps{
			checkout([$class:'GitSCM',branches:[[name:'*/main']],userRemoteConfigs:[[url:'https://github.com/paulohenr96/opencart']]])
		}
	}
    stage ("build"){
		steps{
			
			echo "building application"
		}
		
	}
    stage("test"){
    
      steps{
        echo "Testing OPENCART version ${APP_VERSION}"
        bat 'mvn test'
      
      }
    }
    
	stage ("deploy"){
		steps{
			echo "deploying application"
		}
		
	}

    
    
  }


}
