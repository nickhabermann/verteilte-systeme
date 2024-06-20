# Verwende den offiziellen Nginx-Basis-Image
FROM nginx:alpine

# Kopiere die HTML-Datei und andere erforderliche Ressourcen in das Nginx-Standardverzeichnis für statische Dateien
COPY index.html /usr/share/nginx/html
# Wenn du weitere Ressourcen hast (wie z. B. CSS- oder JavaScript-Dateien), kopiere sie auch in das Verzeichnis /usr/share/nginx/html

# Setze den Port, den der Container freigeben soll
EXPOSE 80

# Starte den Nginx-Webserver beim Ausführen des Containers
CMD ["nginx", "-g", "daemon off;"]
