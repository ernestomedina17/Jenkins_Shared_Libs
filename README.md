# Jenkins_Shared_Libs
Jenkins shared libs written in Groovy

Setting up your Development environment

- Find out the Groovy version in Jenkins, From:
    Jenkins > Nodes > master: println GroovySystem.version
    2.4.12

- Install Groovy From:
    https://archive.apache.org/dist/groovy/2.4.12/distribution/apache-groovy-binary-2.4.12.zip
    
- Install the Jenkins Control Plugin from the marketplace:
    File > Settings > Plugins
       
- Configure your shared libs Globally or at Folder level, instructions from:
    https://www.jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries

- Download the GDSL as syntax.gdsl and add it to your project From:
    http://localhost:8080/job/<Any_Job_Name>/pipeline-syntax/gdsl
   
- Right click on your Project's root folder > Mark Directory as > Sources Root
  