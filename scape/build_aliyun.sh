#!/bin/sh

mvn clean && mvn install  -Dmaven.test.skip=true
echo "build success"
scp -r api/target/scape-api.war root@aliyun:~/apps/scape_api/
scp -r api/target/scape-api.war root@wjz:~/apps/scape_api/
echo "deploy success"
