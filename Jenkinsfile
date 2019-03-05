pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './store-webapp-sample/gradlew clean build -p store-webapp-sample'
                sh './store-webapp-sample/gradlew jar -p store-webapp-sample'
                archiveArtifacts artifacts: 'store-webapp-sample/build/libs/**/*.jar', fingerprint: true
                archiveArtifacts artifacts: 'store-webapp-sample/build/libs/**/*.war', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                echo 'Testing..'

                sh './store-webapp-sample/gradlew check -p store-webapp-sample'
                sh './store-webapp-sample/gradlew jacocoTestReport -p store-webapp-sample'
                junit 'store-webapp-sample/build/test-results/**/*.xml'

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
                    reportDir: 'store-webapp-sample/build/reports/jacocoHtml',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                  ]                              
            }
        }

        stage('Code Quality') {
            steps {
                echo 'Analize with Sonarqube..'
                sh './store-webapp-sample/gradlew sonarqube -p store-webapp-sample'
            }
        }
    }
}
