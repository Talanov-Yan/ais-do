FROM harbor.gu.local/dockerhub/library/maven:3.5.4-jdk-8 as build

COPY src src
COPY pom.xml .
COPY settings.xml .
RUN MAVEN_OPTS="-Xmx2048m" mvn clean compile package spring-boot:repackage -Dmaven.test.skip=true --settings=settings.xml -Pskdpu

FROM harbor.gu.local/dockerhub/library/openjdk:8-jdk as production

WORKDIR /application

COPY src src
COPY --from=build /target/* /application/
COPY src/main/resources/* /application/

RUN chmod -R 777 /application

EXPOSE 8091

ENTRYPOINT ["java","-Xms512m","-Xmx512m","-classpath","\"Cucumber_test-1.0-SNAPSHOT.jar:./:./*:./\"","application.Application"]
