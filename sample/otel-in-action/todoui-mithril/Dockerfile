# Verwende den offiziellen Nginx-Basis-Image
FROM nginx:alpine

#RUN source ~/.bashrc && envsubst < ./index.html > /usr/share/nginx/html/index.html

# Kopiere die HTML-Datei und andere erforderliche Ressourcen in das Nginx-Standardverzeichnis für statische Dateien
#COPY new_index.html /usr/share/nginx/html/index.html
COPY index.html index.html

# Setze den Port, den der Container freigeben soll
EXPOSE 80

# Starte den Nginx-Webserver beim Ausführen des Containers
#CMD ["nginx", "-g", "daemon off;"]
CMD /bin/sh -c "envsubst < ./index.html > /usr/share/nginx/html/index.html && nginx -g 'daemon off;'"