# Use uma imagem base para a compilação
FROM ubuntu:latest AS build

# Instale as dependências e copie o código-fonte
RUN apt-get update && apt-get install -y openjdk-17-jdk maven
WORKDIR /app
COPY . .

# Compile o projeto sem executar os testes
RUN mvn clean install -DskipTests

# Use outra imagem base para a execução do aplicativo
FROM openjdk:17-jdk-slim

# Copie o artefato construído do estágio anterior
COPY --from=build /app/target/petland-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Defina a variável de ambiente para ativar o perfil docker
ENV SPRING_PROFILES_ACTIVE=docker

# Exponha a porta em que o aplicativo será executado
EXPOSE 8181

# Comando de entrada para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "/app/app.jar"]