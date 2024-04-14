FROM openjdk:17-oracle
LABEL authors="Daniel"
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]