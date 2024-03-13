# Stage 1: Build
FROM gradle:jdk17-alpine AS build
WORKDIR /app
COPY . /app
RUN gradle build -x test --no-daemon

# Stage 2: Run
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/build/libs/relex-internship-task-0.0.1-SNAPSHOT.jar /app/relex-internship-task.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "relex-internship-task.jar"]