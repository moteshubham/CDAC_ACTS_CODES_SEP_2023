CREATE DATABASE collegedocker;
USE collegedocker;

CREATE TABLE students (
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

INSERT INTO students (name) VALUES ('Shubham Mote');
INSERT INTO students (name) VALUES ('Mayank Agrawal');
