#!/bin/bash
mvn clean install -Dmaven.test.skip=true
echo "build success."
option="${1}"
echo "deploy ${option}"
case ${option} in
   -api)
		rsync -a8P --delete api/target/scape-api/* root@wjz:/root/dev/scape-api/webapps/ROOT/
		echo "sync api success."
      ;;
   -mgr)
		rsync -a8P --delete manager/target/scape-manager/* root@wjz:/root/dev/scape-mgr/webapps/ROOT/
		echo "sync mgr success."
      ;;
   -all) 
		rsync -a8P --delete api/target/scape-api/* root@wjz:/root/dev/scape-api/webapps/ROOT/
                echo "sync api success."
		rsync -a8P --delete manager/target/scape-manager/* root@wjz:/root/dev/scape-mgr/webapps/ROOT/
                echo "sync mgr success."
      ;;
esac


