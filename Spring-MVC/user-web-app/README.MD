This is a sample Spring MVC based application for user management.
With it you can fetch, create, update and delete users.
Data is held in memory, thus all changes made by you will be deleted after app restart.

In order to build it and run follow this:
```
$ mvn clean install && mvn jetty:run
```
This will build and start an embedded jetty on port 9085.

//TODO
1. UI needs to be improved (user creation form).
2. Features like admin login should be added.