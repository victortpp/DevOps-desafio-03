FROM openjdk:11-slim AS build 
WORKDIR /app
COPY src /app/src
COPY pom.xml /app

FROM openjdk:11-jre-slim
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/minhaRdeSocial-0.0.1.jar"]

