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




First, ensure that Docker is installed on your machine. If it is not, download it from the official Docker website.

Create a new directory on your local machine where you want to store the MySQL configuration files. For example, you can create a directory named mysql-docker.

Inside the mysql-docker directory, create a new file named Dockerfile and add the following content to it:

dockerfile
Download
Copy code
FROM mysql:5.7

# Copy the initialization script into the Docker image
COPY init.sql /docker-entrypoint-initdb.d/

# Expose port 3306 for MySQL connections
EXPOSE 3306
Next, create a new file named init.sql in the mysql-docker directory and add the following content to it:
sql
Download
Copy code
CREATE DATABASE college;
USE college;

CREATE TABLE students (
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

INSERT INTO students (name) VALUES ('John Doe');
Now, build the Docker image by running the following command in the mysql-docker directory:
bash
Download
Copy code
docker build -t mysql-docker .
Once the Docker image is built, run a Docker container using the image by executing the following command:
bash
Download
Copy code
docker run --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql-docker
Replace my-secret-pw with your desired password for the MySQL root user.

After the Docker container is running, you can connect to the MySQL server from your local machine using a MySQL client. Use the following connection details:

Host: localhost
Port: 3306
User: root
Password: The password you specified in step 6.
You should now be able to access the MySQL server and see the college database, the students table, and the dummy entry in the table.

To stop the Docker container when you're done using it, run the following command:

bash
Download
Copy code
docker stop mysql-docker-container
To start the Docker container again in the future, run the following command:

bash
Download
Copy code
docker start mysql-docker-container
Please note that the my-secret-pw is a placeholder. It is important to use a strong password for security reasons.







Dockerfile
FROM mysql:5.7

# Copy the initialization script into the Docker image
COPY init.sql /docker-entrypoint-initdb.d/

# Expose port 3306 for MySQL connections
EXPOSE 3306

init.sql

CREATE DATABASE collegedocker;
USE collegedocker;

CREATE TABLE students (
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

INSERT INTO students (name) VALUES ('Shubham Mote');
INSERT INTO students (name) VALUES ('Mayank Agrawal');




mysql -h 127.0.0.1 -P 3310 -u root -p
