#!/user/bin/env groovy

import com.example.Node

def call() {
    return new Node(this).nodeGetVer()
}