FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Customer-Service.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar","/Customer-Service.jar"]
