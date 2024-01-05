# Set the base image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app


# Compile and run the java program
RUN javac HelloWorld.java

CMD ["java","HelloWorld"]
