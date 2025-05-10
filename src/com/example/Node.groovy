#!/user/bin/env groovy

package com.example

class Node implements Serializable {

    def script

    Node(script) {
        this.script = script
    }

    def nodeGetVer() {
        script.echo 'Getting Node application version...'
        def version = script.sh(script: "node -p \"require('./package.json').version\"", returnStdout: true).trim()
        script.echo "Version: $version"
        return version
    }
}
