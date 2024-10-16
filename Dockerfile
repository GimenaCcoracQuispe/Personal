# Usa la imagen oficial de OpenJDK 17 como base
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

COPY target/*.jar app.jar

ENV DATABASE_URL ${DATABASE_URL}
ENV DATABASE_USERNAME ${DATABASE_USERNAME}
ENV DATABASE_PASSWORD ${DATABASE_PASSWORD}

# Expone el puerto 8085 para acceso externo
EXPOSE 8085

# Define el punto de entrada para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]
