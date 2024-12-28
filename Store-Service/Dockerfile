# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot Jar into the container
COPY target/Store-Service-0.0.1-SNAPSHOT.jar store-service.jar

# Expose port 8081 for Store Service
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "store-service.jar"]
