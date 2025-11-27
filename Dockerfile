# Usamos JDK 17 ligero
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el jar que genera Maven
ARG JAR_FILE=target/PetCRUD-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Puerto interno de la app (debe coincidir con server.port)
EXPOSE 8088

# Comando de arranque
ENTRYPOINT ["java","-jar","/app/app.jar"]
