def workspace
node{
	
    stage('checkout code') {
		//checkout git repository
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '7602f122-deeb-4dd5-a93c-6800443cf3c5', url: 'https://github.com/MohamedElhoseny/E-commerce-Application.git']]])

		//assign current directory to the global variable
		workspace = pwd()
    }
	
    stage('Compile Code') {  
	   build job: 'CompileCodeJob', parameters: [string(name: 'workspace', value: workspace)]     
    }
	
    stage('Copy Resources') {
        build job: 'CopyResourcesJob', parameters: [string(name: 'workspace', value: workspace)]
    }
	
    stage('Add External Lib') {
        build job: 'ExternalLibsJob', parameters: [string(name: 'workspace', value: workspace)]
    }
   
    stage('Run Database Scripts') {
        build job: 'DatabaseScriptsJob', parameters: [string(name: 'workspace', value: workspace)]      
    }
      
    stage('Deploy') {
        build job: 'DeployEARJob', parameters: [string(name: 'workspace', value: workspace)]     
    }
  
}
