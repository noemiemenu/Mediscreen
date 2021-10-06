FROM openjdk:11-jdk-slim

ARG JAR_FILE=./build/libs/microservice-notes-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} microservice-notes.jar

ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java", "-jar", "/microservice-notes.jar"]