# Jenkins_Shared_Libs
Jenkins shared libs written in Groovy

Setting up your Development environment

- Find out the Groovy version in Jenkins, From:
    Jenkins > Nodes > master: println GroovySystem.version
    2.4.12

- Install Groovy From:
    https://archive.apache.org/dist/groovy/2.4.12/distribution/apache-groovy-binary-2.4.12.zip

- Generate an API token for your user go to: 
    User > Configure > API Token > Add new token 
        
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
  
- In the App's repo where your Jenkinsfile exist you can use a pipeline.gsdl like this one: 
    https://gist.githubusercontent.com/ggarcia24/fc5acec3288812b34c64a4f2b8f9bca9/raw/c495e6fa4c773d7b9eb92902a226cf77941fd299/pipeline.gdsl
    Note: Your Jenkinsfile needs to have the .groovy extension.    
