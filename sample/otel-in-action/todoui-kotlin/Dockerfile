# Verwende ein offizielles JDK 11 Image als Basis
FROM openjdk:11-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere das JAR-File in das Image
COPY src src

# Exponiere den Port, den die Anwendung verwendet

# Definiere den Befehl, um die Anwendung zu starten
ENTRYPOINT ["java", "-jar", "app.jar"]
