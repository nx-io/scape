#!/bin/sh

mvn clean && mvn install  -Dtest.skip=true
echo "copy war..."
#cp api/target/scape-api.war $JBOSS_HOME/standalone/deployments/
#cp web/target/scape-web.war $JBOSS_HOME/standalone/deployments/
#cp manager/target/scape-manager.war $JBOSS_HOME/standalone/deployments/

rm -rf D://software/apache-tomcat-6.0.41/webapps/ROOT/*
cp -r api/target/scape-api/* D://software/apache-tomcat-6.0.41/webapps/ROOT

#sh $TOMCAT_HOME/bin/shutdown.sh
#cp -r api/target/scape-api/* $TOMCAT_HOME/webapps/ROOT/
#cp -r web/target/scape-web/* $TOMCAT_HOME/webapps/ROOT/
#cp -r manager/target/scape-manager/* $TOMCAT_HOME/webapps/ROOT/
echo "deploy success!"

#nohup sh standalone.sh > nohup.out 2>&1 &
#sh $JBOSS_HOME/bin/standalone.sh

#sh $TOMCAT_HOME/bin/startup.sh

tail -f D://Users/yp/scape/log/* 
