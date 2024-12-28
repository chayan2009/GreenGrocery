# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot Jar into the container
COPY target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar

# Expose port 8761 for Eureka Server
EXPOSE 8761

# Run the jar file
ENTRYPOINT ["java", "-jar", "service-registry.jar"]
