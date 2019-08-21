pipeline {
  def workspace
  
  agent any
  stages {
	stage('checkout code') {
	    //checkout git repository
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '7602f122-deeb-4dd5-a93c-6800443cf3c5', url: 'https://github.com/MohamedElhoseny/E-commerce-Application.git']]])
		
		//assign current directory to the global variable
		workspace = pwd()
    }
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