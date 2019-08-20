pipeline {
  agent any
  
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Hello in Build Stage'
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
            echo 'Sending files by FTP'
			ftpPublisher alwaysPublishFromMaster: false, continueOnError: false, failOnError: false, publishers: [[configName: 'myFileZillaServer', transfers: [[asciiMode: false, cleanRemote: false, excludes: '', flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'scripts/*.*']], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false]]
          }
        }
      }
    }
  }
}