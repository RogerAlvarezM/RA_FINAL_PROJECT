pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './store-webapp-sample/gradlew clean build -p store-webapp-sample'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './store-webapp-sample/gradlew check -p store-webapp-sample'

                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'store-webapp-sample/build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'JUnit Report'
                  ]

                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'store-webapp-sample/build/jacocoHtml',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                  ]                              
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh './store-webapp-sample/gradlew jar -p store-webapp-sample'
            }
        }
    }

    post {
        always {            
            archiveArtifacts artifacts: 'gradle-jenkins-at08/build/libs/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'gradle-jenkins-at08/build/libs/**/*.war', fingerprint: true
            junit 'store-webapp-sample/build/test-results/**/*.xml'
        }
    }
}