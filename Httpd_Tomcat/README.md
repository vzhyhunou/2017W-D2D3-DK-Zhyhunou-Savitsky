docker-httpd-tomcat
========================
CentOS 6 dockerfile for httpd+tomcat

Copy the sources down and do the build:
```
# docker build --rm -t docam/docker-httpd-tomcat .
```
To run (if port 80 is open on your host):
```
# docker run -e -it -p 80:80 -p 4422:22 -p 8080:8080 docam/docker-httpd-tomcat
```

Points of improvement:
1. Try using Apache Http as balancer, before claster of Tomcat nodes.
