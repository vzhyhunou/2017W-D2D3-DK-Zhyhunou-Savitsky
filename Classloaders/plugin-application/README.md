This app is intended to show how classes from jars can be dynamically loaded in runtime and executed through an API.

To run this app first run:
  $ mvn clean install
Then find compiled jar file of sysinfo module which is a plugin and implements plugin-api. Take that jar to the location you want
your plugins to reside in.
After that you can run plugin-app using jar file located in plugin-app/target passing to it as an argument location of your plugins.

  $ java -jar plugin-app-1.0-SNAPSHOT-jar-with-dependencies.jar <path to plugins directory> 
