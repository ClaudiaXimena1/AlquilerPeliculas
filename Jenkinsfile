pipeline {
  agent {
    label 'Slave_Induccion'
  }

  options {
    	buildDiscarder(logRotator(numToKeepStr: '5'))
		disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
		checkout([
		$class: 'GitSCM', 
		branches: [[name: '*/master']], 
		doGenerateSubmoduleConfigurations: false, 
		extensions: [], 
		gitTool: 'Default', 
		submoduleCfg: [], 
		userRemoteConfigs: [[
		credentialsId: 'GitHub_ClaudiaXimena1', 
		url:'https://github.com/ClaudiaXimena1/AlquilerPeliculas'
		]]
		])
      }
    }
	
	stage('Build') {
      steps {
        echo "------------>Build<------------"
		sh 'gradle --b ./alquilerpeliculas/build.gradle clean'
		sh 'gradle --b ./build.gradle build -x test'
      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
		sh 'gradle --b ./build.gradle test'
		sh 'gradle --b ./build.gradle jacocoTestReport'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
		sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

      
  }

  post {
    success {
      echo 'This will run only if successful'
	  junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
	  mail (to: 'claudia.bustamante@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
  }
}