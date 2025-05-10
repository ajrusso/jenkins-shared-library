#!/user/bin/env groovy

import com.example.NPM

def call() {
    return new NPM(this).npmTestApp()
}