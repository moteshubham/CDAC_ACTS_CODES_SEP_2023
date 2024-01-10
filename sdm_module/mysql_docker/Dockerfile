FROM mysql:5.7

# Copy the initialization script into the Docker image
COPY init.sql /docker-entrypoint-initdb.d/

# Expose port 3306 for MySQL connections
EXPOSE 3306
