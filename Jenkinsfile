pipeline {
    agent any

    stages {
        stage('Download project') {
            steps {
                git 'https://github.com/kaifat123/autotestinguiCopy.git'
                slackSend channel: 'qa-java-2020-06', message: 'Git pull completed'

                    }
                }
        stage("Run tests"){
            steps{
                bat "mvn clean test -Dbrowser=chrome -Dstand=tomsk -DTAGS=@smokeTomsk"
                    }
                }
        stage("Generate report"){
            steps{
          //  allure jdk: '', results: [[path: 'target/allure-results']]
            }
        }
        stage("sendMail")
            steps{
            mail bcc: '', body: '"${env.JOB_NAME} - ${env.BUILD_NUMBER}"
            "status job - ${currentBuild.currentResult}"
            "${env.BRANCH_NAME}" '
            , cc: '', from: '', replyTo: '', subject: 'Pipeline job`s', to: 'darksaid44@gmail.com'
            }
    }
}
