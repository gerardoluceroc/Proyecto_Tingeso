FROM openjdk:17
#ARG JAR_FILE=target/*.jar
COPY target/demo-0.0.1-SNAPSHOT.jar appTingeso.jar
#COPY --from=build target/demo-0.0.1-SNAPSHOT.jar appTingeso.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/appTingeso.jar"]