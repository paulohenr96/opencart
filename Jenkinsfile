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
    
    stage("test"){
      when{
        expression {
			echo "${env.BRANCH_NAME}"
    		env.BRANCH_NAME=='main' || env.BRANCH_NAME=='build'
        }
      }
      steps{
        echo "Testing OPENCART version ${APP_VERSION}"
        bat 'mvn test'
      
      }
    }

    
    
  }


}
