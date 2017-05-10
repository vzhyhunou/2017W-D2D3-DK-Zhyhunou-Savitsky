UPDATE: the application can now be accessed on http://81.4.123.21:9080

docker-httpd-tomcat
========================
CentOS 6 dockerfile for httpd+tomcat

Copy the sources down and do the build:
```
# docker build --rm -t docam/docker-httpd-tomcat .
```
To run (if port 80 is open on your host):
```
# docker run -e -it -p 9080:80 -p 4422:22 -p 7080:8080 docam/docker-httpd-tomcat
```
So as you see the Apache Http server can be accessed on port 9080.

As per mod_jk.conf file all requests that will go to host:9080/examples/* will be passed
to Tomcat by Httpd server. Thus all other requests like host:9080/index.html will be processed from
the root of Httpd server itself.

Points of improvement:
1. Try using Apache Http as balancer in front of Tomcat claster.