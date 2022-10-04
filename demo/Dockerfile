FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appTingeso.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/appTingeso.jar"]