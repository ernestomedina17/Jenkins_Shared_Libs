

def call() {
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
