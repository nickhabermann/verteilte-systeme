
kubectl create configmap postgres-config --from-literal=postgres.db.name=mydb
kubectl create secret generic db-security --from-literal=db.user.name=nick --from-literal=db.user.password=password

kubectl apply -f ./postgresdb-deployment.yaml
kubectl apply -f ./postgresdb-service.yaml
kubectl apply -f ./todobackend-deployment.yaml
kubectl apply -f ./todobackend-service.yaml
kubectl apply -f ./newfrontend-deployment.yaml
kubectl apply -f ./newfrontend-service.yaml
