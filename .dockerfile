FROM openjdk:17-jdk-alpine
MAINTAINER Jeferson Soares <soarescbt@hotmail.com>
ARG JAR_FILE=target/*.jar
ENV SPRING_PROFILES_ACTIVE "default"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]