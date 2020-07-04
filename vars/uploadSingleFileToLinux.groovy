import jenkins.plugins.publish_over_ssh.BapSshHostConfiguration

def call() {
    def hostconf = new BapSshHostConfiguration()

    hostconf.setName('server01')
    hostconf.setHostname('192.168.0.22')
    hostconf.setPort(22)
    hostconf.setTimeout(60000)

    sshPublisher(
        publishers: 
            [sshPublisherDesc(
                configName: hostconf.getName(), 
                sshCredentials: [
                    encryptedPassphrase: '{AQAAABAAAAAQkMeyfvLn1dSSUCd5D3xnXqdu6hxK77+YLyz5vqXV8c8=}',
                    key: '', 
                    keyPath: '', 
                    username: 'ernesto'], 
                transfers: [
                    sshTransfer(
                        cleanRemote: false, 
                        excludes: '', 
                        execCommand: 'ls -l ', 
                        execTimeout: 120000, 
                        flatten: false, 
                        makeEmptyDirs: false, 
                        noDefaultExcludes: false, 
                        patternSeparator: '[, ]+', 
                        remoteDirectory: '', 
                        remoteDirectorySDF: false, 
                        removePrefix: 'directoryA/directoryB/', 
                        sourceFiles: 'directoryA/directoryB/config.props')], 
                usePromotionTimestamp: false, 
                useWorkspaceInPromotion: false, 
                verbose: false)])
}
