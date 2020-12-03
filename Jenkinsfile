pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -DskipTests clean package"

                // Run Maven on a Windows agent.
                // bat "mvn -DskipTests clean package"
            }

            post {
                // If Maven was able to run the build, archive the jar file.
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage('Test') {
            steps {
                sh "mvn test"
                
                // bat "mvn test"
            }
            
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('Deliver') {
            steps {
                sh "echo Delivery script: mxk"
            }
        }
    }
}
