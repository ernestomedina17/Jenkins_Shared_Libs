def call() {    
    sshPublisher(publishers: [sshPublisherDesc(configName: 'localhost', sshCredentials: [encryptedPassphrase: '{AQAAABAAAAAQF9+CxWBdzVxVWFOW/0JePp36kdT68Svgc0LTSkX4uAM=}', 
    key: '', keyPath: '', username: 'ernesto'], transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'ls -l ', execTimeout: 120000, flatten: false, 
    makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'directoryA/directoryB/', 
    sourceFiles: 'directoryA/directoryB/config.props')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
}
