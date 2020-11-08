pipeline {
    agent any

    stages {
        stage('Download project') {
            steps {
                //slackSend channel: "qa-java-2020-06", color: "good", message: "STARTED: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\' (${env.BUILD_URL})", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
                git 'https://github.com/kaifat123/autotestinguiCopy.git'
               // slackSend channel: "qa-java-2020-06", color: "good", message: "Git pull completed", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"


            }
        }
        stage("Run tests") {
            steps {
               // slackSend channel: "qa-java-2020-06", color: "good", message: "Run tests to job ${JOB_NAME} Build # ${BUILD_NUMBER}", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
                bat "mvn clean test -Dbrowser=chrome -Dstand=tomsk -DTAGS=@smokeTomsk"
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
                emailext body: '''$PROJECT_NAME - Build # $BUILD_NUMBER - BRANCH  \'${BRANCH_NAME}, ${env.BRANCH_NAME}, ${GIT_BRANCH}, ${env.GIT_BRANCH}\' - $BUILD_STATUS:
''' +
                        readFile("\\target\\surefire-reports\\dev.rusatom.qa.CucumberRunnerTest.txt") +

                        '''
Check console output at $BUILD_URL to view the results.''',
                        subject: 'Pipeline, result ${BUILD_NUMBER} job`s ', to: 'dark_said@mail.ru'
               // slackSend channel: "qa-java-2020-06", color: "good", message: "Job ${JOB_NAME}-${BUILD_NUMBER} is completed", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
            }
        }
    }
}
