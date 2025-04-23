#!/user/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuild(String imageName) {
        script.echo 'Building Docker image...'
        script.sh "docker build -t $imageName:'${script.env.IMAGE_NAME}' ."
    }

    def dockerLogin() {
        script.echo 'Logging into Docker...'
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
        }             
    }

    def dockerPush(String imageName) {
        script.echo 'Pushing Docker image...'
        script.sh "docker push $imageName:'${script.env.IMAGE_NAME}'"
    }
}
