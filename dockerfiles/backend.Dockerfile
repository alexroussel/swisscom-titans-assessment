FROM maven:3.8.3-openjdk-16-slim as build

WORKDIR /app

COPY ../backend .

RUN mvn clean package -DskipTests

FROM openjdk:16.0.2-slim

WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "./app.jar"]