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
            echo 'Hello in Deploy Stage'
          }
        }
        stage('Getway_Cluster') {
          steps {        

          }
        }
      }
    }
  }
}