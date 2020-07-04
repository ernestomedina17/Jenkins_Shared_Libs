package com.company.department.publish

import jenkins.plugins.publish_over_ssh.BapSshHostConfiguration

class SSHServer implements Serializable {
    def steps
    def hostconf = new BapSshHostConfiguration()

    SSHServer(steps, String name = 'server01', String ip = '192.168.0.22') {
        this.steps = steps
        this.hostconf.setName(${name})
        this.hostconf.setHostname(${ip})
        this.hostconf.setPort(22)
        this.hostconf.setTimeout(60000)
    }

    def lsHome() {
        steps.sh "ls -l"
    }

    

}