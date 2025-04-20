#!/user/bin/env groovy

package com.example

class NPM implements Serializable {

    def script

    NPM(script) {
        this.script = script
    }

    def npmIncMajVer() {
        script.echo 'Incrementing major build version...'
        script.sh 'npm version major --no-git-tag-version'
    }

    def npmIncMinVer() {
        script.echo 'Incrementing minor build version...'
        script.sh 'npm version minor --no-git-tag-version'            
    }

    def npmIncPatchVer() {
        script.echo 'Incrementing patch build version...'
        script.sh 'npm version patch --no-git-tag-version'
    }

    def npmTestApp() {
        script.echo 'Testing application...'
        script.sh "npm install"
        script.sh "npm test"
    }
}
