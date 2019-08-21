pipeline {
  agent any
  stages {
    stage('Compile Code') {
      steps {
        build 'CompileCodeJob'
      }
    }
    stage('Copy Resources') {
      parallel {
        stage('Copy Resources') {
          steps {
            build 'CopyResourcesJob'
          }
        }
        stage('External Lib') {
          steps {
            build 'ExternalLibsJob'
          }
        }
      }
    }
    stage('Database') {
      parallel {
        stage('Database') {
          steps {
            echo 'Running Database Scripts'
          }
        }
        stage('Run Scripts Files') {
          steps {
            build 'DatabaseScriptsJob'
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        build 'DeployEARJob'
      }
    }
  }
}