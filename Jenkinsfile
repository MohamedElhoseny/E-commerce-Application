pipeline {
  agent any
  tools {
        maven 'apache-maven-3.0.1' 
    }
  
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Hello in Build Stage'
			sh 'mvn --version'
          }
        }
        stage('Module 1') {
          steps {
            echo 'Building module 1'
          }
        }
        stage('Module 2') {
          steps {
            echo 'Building module 2'
          }
        }
      }
    }
    stage('Test') {
      steps {
        echo 'Hello in Test Stage'
      }
    }
    stage('Deploy') {
      parallel {
        stage('Deploy') {
          steps {
            echo 'Hello in Deploy Stage'
            powershell(script: 'AdminApp.update(appName,\'app\',\'[-operation update -cluster \'+clusterName+\' -contextroot \'+context_root+\' -contents \'+app_filepath+\' -usedefaultbindings -nopreCompileJSPs -distributeApp -nouseMetaDataFromBinary -createMBeansForResources ]\')', returnStatus: true, returnStdout: true)
          }
        }
      }
    }
  }
}