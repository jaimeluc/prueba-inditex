# Stage 1: Build
# Use a Maven base image with JDK 17 to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the image
WORKDIR /app

# Copy the pom.xml file and the src directory to the working directory
COPY pom.xml .
COPY src ./src

# Run `mvn clean package` to build the application
RUN mvn clean package

# Stage 2: Run
# Use an OpenJDK 17 base image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the image
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar inditex-1.0.2-SNAPSHOT.jar

# Expose the port where the Spring Boot application will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/inditex-1.0.2-SNAPSHOT.jar"]
