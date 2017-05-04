#!/bin/bash
# Start SSH Daemon
/usr/sbin/sshd

# Make sure we're not confused by old, incompletely-shutdown httpd
# context after restarting the container.  httpd won't start correctly
# if it thinks it is already running.
rm -rf /run/httpd/*

#exec /usr/sbin/apachectl
service httpd start

# Create Tomcat Admin user
if [ ! -f /.tomcat_admin_created ]; then
    /create_tomcat_admin_user.sh
fi

# Start Tomcat in foreground
exec ${CATALINA_HOME}/bin/catalina.sh run