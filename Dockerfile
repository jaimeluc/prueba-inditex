# Use java base image
FROM openjdk:17-jdk-slim

# Sets the working directory inside the container
WORKDIR /app

# Copy the generated JAR file into the container
COPY target/inditex-0.0.1-SNAPSHOT.jar /app/inditex-0.0.1-SNAPSHOT.jar

# Exposes the port on which the application runs
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "inditex-0.0.1-SNAPSHOT.jar"]
