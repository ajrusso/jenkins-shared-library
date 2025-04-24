#!/user/bin/env groovy

package com.example

class Node implements Serializable {

    def script

    Node(script) {
        this.script = script
    }

    def nodeGetVer() {
        script.echo 'Getting Node application version...'
        def version = script.sh "docker build -t $imageName:'${script.env.VERSION}' ."
        script.echo "Version: $version"
        return version
    }
}
