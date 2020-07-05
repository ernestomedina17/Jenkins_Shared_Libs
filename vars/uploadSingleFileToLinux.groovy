import jenkins.plugins.publish_over_ssh.*
import jenkins.plugins.publish_over_ssh.descriptor.*

def call() {

    config_name = 'server01'
    ip = '192.168.0.22'

    def hostconf = new BapSshHostConfiguration()
    hostconf.setName(config_name)
    hostconf.setHostname(ip)
    hostconf.setPort(22)
    hostconf.setTimeout(60000)

    Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().addHostConfiguration(hostconf)

    try { 
        sshPublisher(
        publishers: 
            [sshPublisherDesc(
                configName: config_name, 
                sshCredentials: [
                    encryptedPassphrase: '{AQAAABAAAAAQkMeyfvLn1dSSUCd5D3xnXqdu6hxK77+YLyz5vqXV8c8=}',
                    key: '', keyPath: '', username: 'ernesto'], 
                transfers: [
                    sshTransfer(
                        cleanRemote: false, excludes: '', execCommand: 'ls -l ', 
                        execTimeout: 120000, flatten: false, makeEmptyDirs: false, 
                        noDefaultExcludes: false, patternSeparator: '[, ]+', 
                        remoteDirectory: '', remoteDirectorySDF: false, 
                        removePrefix: 'directoryA/directoryB/', 
                        sourceFiles: 'directoryA/directoryB/config.props')], 
                usePromotionTimestamp: false, 
                useWorkspaceInPromotion: false, 
                verbose: false)]) 
    } catch(Exception ex) { 
        println ex
    } finally {
        Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().removeHostConfiguration(config_name)
    }
}
