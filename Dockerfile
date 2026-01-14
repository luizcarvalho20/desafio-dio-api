# Estágio de Build
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Execução (Rodando a API de Pagamentos)
FROM openjdk:17-jdk-slim
COPY --from=build /payments-api/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]