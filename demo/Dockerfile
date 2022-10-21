FROM openjdk:17
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar 
#COPY --from=build target/demo-0.0.1-SNAPSHOT.jar appTingeso.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appTingeso.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/appTingeso.jar"]