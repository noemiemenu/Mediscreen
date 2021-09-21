FROM openjdk:11-jdk-slim

ARG JAR_FILE=./build/libs/microservice-users-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} microservice-users.jar

ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java", "-jar", "/microservice-users.jar"]