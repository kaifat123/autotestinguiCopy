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
            echo 'report is generated here'
            //allure jdk: '', results: [[path: 'target/allure-results']]
            }
        }
        stage("sendMail"){
            steps{emailext body: '''"${JOB_NAME} - ${BUILD_NUMBER}"
                              "status job - ${currentBuild.currentResult}"
                              "${BRANCH_NAME}"''', subject: 'Pipeline job`s', to: 'darksaid44@gmail.com'}
        }
    }
}
