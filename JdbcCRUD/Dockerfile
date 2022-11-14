FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} crud.jar
ENTRYPOINT ["java","-jar","/crud.jar"]