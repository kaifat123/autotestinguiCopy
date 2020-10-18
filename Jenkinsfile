pipeline {
    agent any

    stages {
        stage('Download project') {
            steps {
                git 'https://github.com/kaifat123/autotestinguiCopy.git'
                    }
                }
        stage("Run tests"){
            steps{
                bat "mvn clean test -Dbrowser=chrome -Dstand=tomsk -DTAGS=@smokeTomsk"
                    }
                }
        stage("Generate report"){
            steps{
            allure jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
