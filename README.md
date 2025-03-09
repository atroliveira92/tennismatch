# Tennis match project
Just a simple project to learn more about some tech-stacks
* Backend development using Spring Boot with Java
* Using Docker to deploy easily application with containers
* Using Kubernets for cloud deployment
* Mobile app development using Flutter for both iOS and Android (comming soon)

# Backend
The list of endpoints available can be found at this [Confluence page](https://atroliveira92.atlassian.net/wiki/spaces/~5b1ecec5905d254d2cefea2f/pages/edit-v2/98518)

### Local configuration
First you need to configure the **DB_USERNAME** and **DB_PASSWORD** environment variables in your machine. To place
the correct values please reach me out.

I'm using Docker to easily deploy locally the whole server configuration. So first make sure you have docker up and running
in your local machine.
If you want to just local run, you'd need first to run and connect with mysql container by using the following command:
```
docker run --name tennis-match-mysql \
  -e MYSQL_ROOT_PASSWORD=$DB_PASSWORD \
  -e MYSQL_DATABASE=tennis-match-db \
  -e MYSQL_USER=$DB_USERNAME \
  -e MYSQL_PASSWORD=$DB_PASSWORD \
  -p 3306:3306 \
  -d mysql:latest

```
After that just hit run on intellij to run the server.

However, if you want to deploy locally a new version after changes, you may first build the image running the following command:
```
docker build -t tennis-match-server:latest . 
```
After build the image, you just need to run the docker-compose file:
```
docker-compose up
```
or
```
docker-compose build app
docker-compose up -d app
```

### Cloud configuration
* Make sure to have gcloud installed and authenticated in your machine. Configure the project id and connect with the cluster
```
gcloud container clusters get-credentials tennis-match-cluster --region us-central1 --project <PROJECT_ID>
```
* Generate the database username and password in base64 and place it inside ```secrets.yaml```
* Build the docker image and upload it to the docker hub. **Important:** If you're building from a machine with a arm64 architecture as M1 devices,
  please run the following command to make sure the image is available for multiplatforms, as kubernets works on linux/amd64:
  * Activate ```buildx```
  ```
  docker buildx create --use
  docker buildx inspect --bootstrap
  ```
  * Build and push the multiplatform image:
  ```
  docker buildx build --platform linux/amd64,linux/arm64 -t atroliveira92/tennis-match-server:latest . --push
  ```
* Implement Kubernets
  * Set secrets
  ```
  kubectl apply -f secret.yaml
  ```
  * Implement mysql database
  ```
  kubectl apply -f mysql-deployment.yaml
  ```
  * Implement tennis-match server
  ```
  kubectl apply -f tennis-match-deployment.yaml
  ```
  * Check if pods are running correctly. It may take sometime
  ```
  kubectl get pods
  ```
  * If everything is running fine, you can run ```kubectl get svc``` and search for **EXTERNAL-IP** for tennis-match-server
  * Just test it for e.g: ```http://34.59.170.75:8080/players```