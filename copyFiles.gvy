pipeline {
    agent any
    parameters {
      string (defaultValue: 'C:\\_Offical\\JenkinsTest\\Source', description: 'Source folder', name: 'Source')
      string (defaultValue: 'C:\\_Offical\\JenkinsTest\\Destination', description: 'Destination folder', name: 'Destination')
      string (defaultValue: 'C:\\_Offical\\PowerShellScripts\\Hello.ps1', description: 'PowerShell Source folder', name: 'PowerShellSource')
    }

    stages {
        stage('Copy files') {
            steps {
               script{
                    echo "robocopy "+params.Source +" "+params.Destination +"/s"
                    bat("robocopy "+params.Source +" "+params.Destination +" /s")
                  echo 'File copied successfully'
                
               }
            }
        }
        stage('Run PowerShell scrip'){
            steps{
                script{
                   bat ('powershell.exe -ExecutionPolicy Bypass -File '+ params.PowerShellSource)
                   echo 'Executed successfully'
                }
            }
        }
        
    }
}