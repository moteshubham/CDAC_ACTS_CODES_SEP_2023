systemctl start docker //to start the docker process

## docker image
```docker

docker images # to show the present images
docker image list
docker image ls

docker pull hello-world
docker run hello-world # to  run the local image if not present locally fetches from docker hub
docker image inspect #Display detailed information on one or more images
```

## container
```bash
docker container list # to show the running container list

docker container list -a # to show the all container list (stopped + running   )

docker container rm 50147635b8e0 # to remove the container with the specified id

docker run -d -p 9999:8080 tomcat:8.0 # to run the tomcat container. internall port 8080 and external port 9999

docker exec -it dac-tomcat-1 /bin/bash
```
### Dockerfile
```bash
# Set the base image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile and run the java program
RUN javac HelloWorld.java

CMD ["java","HelloWorld"]

```