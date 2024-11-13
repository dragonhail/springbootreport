pipeline{
   agent any
    environment {
           DOCKERHUB_CREDENTIALS = credentials('jenkinspipeline2')  // Docker 레지스트리의 인증 정보 ID
       }
   stages{
       stage("Permission"){
           steps{
               sh "chmod +x ./gradlew"
           }
       }
       stage("Compile"){
           steps{
               sh "./gradlew compileJava"
           }
       }
       stage("Unit Test"){
           steps{
               sh "./gradlew test"
            }
       }
       stage("Code Coverage"){
            steps{
                sh "./gradlew jacocoTestCoverageVerification"
            }
       }
        stage("Gradle Build"){
              steps{
                  sh "./gradlew clean build"
              }
        }
        stage("docker image build"){
               steps{
                  sh 'docker build -t dragonhailstone/springbootpipeline:latest .'
              }
        }
        stage('docker hub login'){
               steps{
                  sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
               }
        }
         stage('docker hub push'){
            steps{
                sh 'docker push dragonhailstone/springbootpipeline:latest'
            }
         }
    }
}