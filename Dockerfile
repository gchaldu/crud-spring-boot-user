FROM amazoncorretto:17-alpine-jdk
COPY target/crud-api-rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java ", "-jar", "/app.jar"]