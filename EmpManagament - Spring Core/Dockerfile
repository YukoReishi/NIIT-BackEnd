FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmpManagement.jar
ENTRYPOINT ["java","-jar","/EmpManagement.jar"]
