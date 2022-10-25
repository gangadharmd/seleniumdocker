FROM    openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#workspace
WORKDIR /usr/share/seleniumdocker

#add .jar under target
#into this image
ADD target/selenium-docker.jar  selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs libs

#add any csv json xls
#add suite files

ADD testng.xml  testng.xml
ADD testng_search.xml   testng_search.xml

#ADD health check script
ADD healthcheck.sh   healthcheck.sh
RUN dos2unix healthcheck.sh

#compile jar file with BROWSER , HUB_HOST, testng
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
ENTRYPOINT sh healthcheck.sh