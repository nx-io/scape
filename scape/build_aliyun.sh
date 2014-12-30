#!/bin/sh

mvn clean && mvn install  -Dmaven.test.skip=true
echo "build success"
scp -r api/target/scape-api/* root@aliyun:~/soft/apache-tomcat-7.0.53/webapps/ROOT/
echo "deploy success"
