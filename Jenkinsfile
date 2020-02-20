#!groovy

pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }
  /*triggers {
    pollSCM('@hourly')
  }*/
  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    //Mantener artefactos y salida de consola para el # específico de ejecuciones recientes del Pipeline.
    buildDiscarder(logRotator(numToKeepStr: '3'))
    //No permitir ejecuciones concurrentes de Pipeline
    disableConcurrentBuilds()
  }
  //Una sección que define las herramientas para “autoinstalar” y poner en la PATH
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
  }
  //Aquí comienzan los “items” del Pipeline
  stages {
    stage('Checkout') {
      steps {
        echo "------------>Checkout<------------"
        checkout([
          $class: 'GitSCM',
          branches: [[name: '*/master']],
          doGenerateSubmoduleConfigurations: false,
          extensions: [],
          gitTool: 'Git_Centos',
          submoduleCfg: [],
          userRemoteConfigs: [[
            credentialsId: 'GitHub_santygr13',
            url:'https://github.com/santygr13/cinemax-ceiba'
          ]]
        ])
      }
    }
    stage('Build') {
      steps {
        echo "------------>Build<------------"
	
	dir("cinemax-service"){
          //Construir sin tarea test que se ejecutó previamente
		   sh 'gradle clean'
           sh 'gradle build -x test'
	}

      }
    }
    stage('Tests') {
      steps {
        echo "------------>Unit Tests<------------"
	dir("cinemax-service"){
        sh 'gradle --b build.gradle test'
		sh 'gradle --b build.gradle jacocoTestReport'
		
	}
      }
	  post {
               always {
                   publishHTML target: [
                   allowMissing: true,
                   alwaysLinkToLastBuild: false,
                   keepAll: false,
                   reportDir: 'cinemax-service/build/reports/tests/test',
                   reportFiles: 'index.html',
                   reportName: 'Tests Report'
                   ]
               }
               success {
                   junit 'cinemax-service/build/test-results/test/*.xml'
                   jacoco classPattern: 'cinemax-service/build/classes/java', execPattern: 'cinemax-service/build/jacoco/test.exec', sourcePattern: 'src/main/java'
               }
           }
    }
    stage('Static Code Analysis') {
      steps {
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
          sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
		  
          // sh 'gradle sonarqube'
        }
      }
    }
  }
  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      //junit 'cinemax-service/**/build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'santiago.garcia@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
            body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}