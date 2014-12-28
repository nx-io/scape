#!/bin/sh

scp -r api/target/scape-api/* root@aliyun:~/soft/apache-tomcat-7.0.53/webapps/ROOT/
echo "OK"
