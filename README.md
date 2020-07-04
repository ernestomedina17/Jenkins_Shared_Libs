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

# IntelliJ IDEA        
- Install the Jenkins Control Plugin from the marketplace:
    File > Settings > Plugins
    https://plugins.jetbrains.com/plugin/6110-jenkins-control-plugin
    Docs: https://github.com/mcmics/jenkins-control-plugin
    
- Configure your plugin, go to:
    File > Settings > Tools > Jenkins Plugin
    Note: The server URL must include the Folder, E.g.
        http://localhost:8080/job/ProjectLib/
    Note: Use your API token as the password 
       
- Configure your shared libs Globally or at Folder level, instructions from:
    https://www.jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries

- Download the GDSL as syntax.gdsl and add it to your project From:
    http://localhost:8080/job/<Any_Job_Name>/pipeline-syntax/gdsl
   
- Right click on your Project's root folder > Mark Directory as > Sources Root
  
- In the App's repo where your Jenkinsfile exist you can use a pipeline.gdsl like this one: 
    https://gist.githubusercontent.com/ggarcia24/fc5acec3288812b34c64a4f2b8f9bca9/raw/c495e6fa4c773d7b9eb92902a226cf77941fd299/pipeline.gdsl
    Note: Your Jenkinsfile needs to have the .groovy extension.    

# Visual Studio Code


# Script Console Hacks

Get Jenkin's instance methods: 
Jenkins.getInstance().metaClass.methods*.name.sort().unique()

# Adding a dynamic config 

https://github.com/jenkinsci/publish-over-ssh-plugin/blob/master/src/main/java/jenkins/plugins/publish_over_ssh/BapSshHostConfiguration.java
https://github.com/jenkinsci/publish-over-ssh-plugin/blob/master/src/main/java/jenkins/plugins/publish_over_ssh/BapSshPublisherPlugin.java


import org.kohsuke.stapler.StaplerRequest;
import net.sf.json.JSONObject;
import jenkins.plugins.publish_over_ssh.*
import jenkins.plugins.publish_over_ssh.descriptor.*

def bsppd = new BapSshPublisherPluginDescriptor()

println bsppd.getPublisherDescriptor()
println bsppd.getHostConfigurationDescriptor()
println bsppd.getPluginDefaultsDescriptor()
println bsppd.getCommonFieldNames()
println bsppd.getCommonManageMessages()

def hostconf = new BapSshHostConfiguration()

hostconf.setName('server02')
hostconf.setHostname('192.168.0.1')
hostconf.setPort(22)
hostconf.setTimeout(60000)
println ''

bsppd.addHostConfiguration(hostconf)
println bsppd.getConfiguration('server02')

def sr = new StaplerRequest()
def json = new JSONObject()

//bsppd.configure(final StaplerRequest request, final JSONObject formData)

Jenkins.instance.save()


----
Jenkins.instance.getDescriptor().getCategory().getShortDescription() 

Jenkins.instance.pluginManager.getPlugin('publish-over-ssh')
Jenkins.instance.pluginManager.getPlugin('publish-over-ssh').getDependencies()
Result: [jsch (0.1.54.2), publish-over (0.21), structs (1.14), bouncycastle-api (2.16.0) optional, command-launcher (1.0) optional, jdk-tool (1.0) optional, trilead-api (1.0.4) optional]
Jenkins.instance.pluginManager.getPlugin('publish-over-ssh').getInfo().wiki



https://javadoc.jenkins.io/plugin/publish-over-ssh/jenkins/plugins/publish_over_ssh/BapSshHostConfiguration.html
https://javadoc.jenkins.io/plugin/publish-over/
https://wiki.jenkins.io/display/JENKINS/Publish+Over#PublishOver-Eg1Transferdirectory

