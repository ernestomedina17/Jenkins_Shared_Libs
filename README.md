# Jenkins_Shared_Libs
Jenkins shared libs written in Groovy

Setting up your Development environment

- Find out the Groovy version in Jenkins, From the Script Console:
    Jenkins > Nodes > master: println GroovySystem.version
    2.4.12

- Install Groovy From:
    https://archive.apache.org/dist/groovy/2.4.12/distribution/apache-groovy-binary-2.4.12.zip

- Generate an API token for your user go to: 
    User > Configure > API Token > Add new token 

# Script Console Hacks

Get Jenkin's instance methods: 
Jenkins.getInstance().metaClass.methods*.name.sort().unique()


# Get Plugin's info

Jenkins.instance.pluginManager.getPlugin('publish-over-ssh').getDependencies()
Jenkins.instance.pluginManager.getPlugin('publish-over-ssh').getInfo().wiki


# Adding a dynamic Host config 

import jenkins.plugins.publish_over_ssh.*
import jenkins.plugins.publish_over_ssh.descriptor.*

def hostconf = new BapSshHostConfiguration()
hostconf.setName('server01')
hostconf.setHostname('192.168.0.22')
hostconf.setPort(22)
hostconf.setTimeout(60000)

Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().addHostConfiguration(hostconf)
println Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().getHostConfigurations()

println 'Do pipeline stuff'

Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().removeHostConfiguration(hostconf.name)
println Jenkins.instance.getDescriptorByType(BapSshPublisherDescriptor.class).getPublisherPluginDescriptor().getHostConfigurations()

