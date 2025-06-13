# Use an official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 as build

# Copy the project files
COPY . /app

# Set working directory
WORKDIR /app

# Build the app (creates target/*.jar)
RUN mvn clean package -DskipTests

# Use a minimal JRE image for runtime
FROM eclipse-temurin:17-jre

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose port (Spring Boot default)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","/app/app.jar"]