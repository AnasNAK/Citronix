
FROM openjdk:17-jdk-slim

WORKDIR /app

ENTRYPOINT ["java", "-jar", "Citronix-0.0.1-SNAPSHOT.jar"]
