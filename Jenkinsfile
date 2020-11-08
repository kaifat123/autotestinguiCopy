pipeline {
    agent any

    stages {
        stage('Download project') {
            steps {
                git 'https://github.com/kaifat123/autotestinguiCopy.git'
                // slackSend channel: 'qa-java-2020-06', message: 'Git pull completed'

            }
        }
        stage("Run tests") {
            steps {
                bat "mvn clean test -Dbrowser=chrome -Dstand=tomsk -DTAGS=@test"
            }
        }
        stage("Generate report") {
            steps {
                echo 'report is generated here'
                //allure jdk: '', results: [[path: 'target/allure-results']]
            }
        }
        stage("sendMail") {
            steps {
                script {
                    env.result = readFile("//target/surefire-reports/dev.rusatom.qa.CucumberRunnerTest.txt")
                echo "${env.result}"}
                emailext body: '''$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:

Check console output at $BUILD_URL to view the results.''',
                        subject: 'Pipeline, result ${BUILD_NUMBER} job`s ', to: 'dark_said@mail.ru'
            }
        }
    }
}
