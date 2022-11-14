FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} StudentServer.jar
ENTRYPOINT ["java","-jar","/StudentServer.jar"]