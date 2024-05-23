# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application jar file into the container
COPY target/SpringFinal-1.0-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]