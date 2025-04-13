# === Stage 1: Build the JAR ===
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# === Stage 2: Run the app ===
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/codechecker-0.0.1-SNAPSHOT.jar codechecker.jar
EXPOSE 8080
CMD ["java", "-jar", "codechecker.jar"]
