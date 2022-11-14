FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} school.jar
ENTRYPOINT ["java","-jar","/school.jar"]