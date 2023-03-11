FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN apk --no-cache add curl
COPY target/hamsterwheel-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]