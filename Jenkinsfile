pipeline {
    agent any
    environment {
        BRANCH_NAME = "${env.GIT_BRANCH}"
        TAG = "${BUILD_TAG}"
    }
    stages {
        stage('Download project') {
            steps {
                slackSend channel: "qa-java-2020-06", color: "good", message: "STARTED: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\' (${env.BUILD_URL})", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
                git 'https://github.com/kaifat123/autotestinguiCopy.git'
                slackSend channel: "qa-java-2020-06", color: "good", message: "Git pull completed", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"


            }
        }
        stage("Run tests") {
            steps {
                slackSend channel: "qa-java-2020-06", color: "good", message: "Run tests to job ${JOB_NAME} Build # ${BUILD_NUMBER}", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
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
                emailext body: '''${PROJECT_NAME} - Build #${BUILD_NUMBER} - BRANCH: ''' + "${BRANCH_NAME}" + ''' - Status: ${BUILD_STATUS}\n''' +
                        readFile("\\target\\surefire-reports\\dev.rusatom.qa.CucumberRunnerTest.txt") +
                        '''\nCheck console output at ${BUILD_URL} to view the results.''',
                        subject: "Pipeline, result ${BUILD_NUMBER} job`s ", to: "dark_said@mail.ru"
                slackSend channel: "qa-java-2020-06", color: "good", message: "Job ${TAG} in branch: ${BRANCH_NAME} is completed \n" +
                        readFile("\\target\\surefire-reports\\dev.rusatom.qa.CucumberRunnerTest.txt"), tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
            }
        }
        stage("BackUp job") {
            steps {
                bat "C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\jenkins-backup-script-master\\jenkins-backup.sh C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\jenkins_backup archive.tar.gz"
                slackSend channel: "qa-java-2020-06", color: "good", message: "Backup is done!!!!   Now you can sleep in peace :-) ", tokenCredentialId: "d03333ba-0bf5-4619-864d-99ccfb8a1375"
            }
        }
    }
}
