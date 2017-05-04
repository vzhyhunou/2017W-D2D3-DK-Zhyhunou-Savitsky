FROM centos:centos6

ENV JAVA_HOME /usr/java/latest
ENV JAVA_VERSION 8u112
ENV BUILD_VERSION b15

ENV TOMCAT_MAJOR_VERSION 8
ENV TOMCAT_MINOR_VERSION 8.0.11
ENV CATALINA_HOME /tomcat

# =============INSTALL SUPPLEMENT PACKAGES===============
RUN yum -y update; yum clean all
RUN yum -y install httpd httpd-devel apr apr-devel apr-util apr-util-devel gcc gcc-c++ make autoconf libtool nc netstat wget; yum clean all
RUN echo "Apache HTTPD" >> /var/www/html/index.html
RUN echo "Include /mod_jk.conf" >> /etc/httpd/conf/httpd.conf
#======================INSTALL JAVA=========================
RUN wget --no-cookies --no-check-certificate --header \
    "Cookie: oraclelicense=accept-securebackup-cookie" \
    "http://download.oracle.com/otn-pub/java/jdk/$JAVA_VERSION-$BUILD_VERSION/jdk-$JAVA_VERSION-linux-x64.rpm" \
    -O /tmp/jdk-8-linux-x64.rpm
RUN yum -y install /tmp/jdk-8-linux-x64.rpm
#======================INSTALL TOMCAT=======================
RUN wget -q https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz && \
    wget -qO- https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz.md5 | md5sum -c - && \
    tar zxf apache-tomcat-*.tar.gz && \
    rm apache-tomcat-*.tar.gz && \
    mv apache-tomcat* tomcat

RUN mkdir -p /opt/mod_jk/ && \
    cd /opt/mod_jk
RUN wget http://www.eu.apache.org/dist/tomcat/tomcat-connectors/jk/tomcat-connectors-1.2.42-src.tar.gz
RUN tar -xvzf tomcat-connectors-1.2.42-src.tar.gz && \
    cd tomcat-connectors-1.2.42-src/native && \
    ./configure --with-apxs=/usr/sbin/apxs && \
    make && \
    libtool --finish /usr/lib64/httpd/modules && \
    make install
#==================INSTALL SSH==================
RUN yum -y install openssh-server
RUN chkconfig sshd on
RUN service sshd start
RUN echo 'root:password' | chpasswd
RUN sed -i 's/PermitRootLogin without-password/PermitRootLogin yes/' /etc/ssh/sshd_config
#===============================================

EXPOSE 80
EXPOSE 22
EXPOSE 8080

ADD run.sh /
ADD mod_jk.conf /
ADD workers.properties /
ADD create_tomcat_admin_user.sh /

RUN chmod +x /*.sh

CMD ["/run.sh"]