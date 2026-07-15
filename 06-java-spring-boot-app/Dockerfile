# =============================================================
# Java Spring Boot Application — Multi-Stage Build
# Base: maven:3.9-eclipse-temurin-21 (Spring Boot 3.4.x, Java 21)
# Stage 1 (builder): compiles and packages the JAR with Maven
# Stage 2 (runtime): runs the JAR on a minimal JRE image
# =============================================================

# ── Stage 1: Build ──
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Step 1: Copy the POM and pre-fetch dependencies (cached layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Step 2: Copy source and build the application JAR (tests skipped for speed)
COPY src ./src
RUN mvn package -DskipTests -B

# ── Stage 2: Runtime ──
# eclipse-temurin:21-jre-alpine — JRE-only image, much smaller than full JDK
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Step 3: Copy only the packaged JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Step 4: Expose the port Spring Boot listens on
EXPOSE 8080

# Step 5: Launch the application
ENTRYPOINT ["java", "-jar", "app.jar"]
