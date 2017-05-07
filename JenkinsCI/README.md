In order to run this example you'll need to checkout this project
https://github.com/AntonSavitsky/spring-petclinic.git

You'll need to have docker installed on your system.
And then go to jenkins/ and run:

`$ docker build -t jenkins-petclinic-1.0 .`

Then you can run created image with:

`$ docker run -p 8080:8080 jenkins-petclinic-1.0`

This will startup docker with Jenkins CI installed in it on port 8080.

Go there and what you'll still need to do is to configure JDK and Maven in System Configuration in Jenkins UI.
 
After that you can run 'pipeline' job which will checkout petclinic project from repository and run job using Jenkinsfile.
  
//TODO

1. Move Maven and JDK installation to scripts.
2. Make job that will automatically create jobs for branches on push to git.
