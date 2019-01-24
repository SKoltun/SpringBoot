FROM jboss/wildfly
COPY wildfly /opt/jboss/wildfly/bin
COPY wildfly /opt/jboss/wildfly/standalone/configuration/
COPY SpringBoot.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]