CREATE DATABASE ORG;
SHOW DATABASES;
USE ORG;
CREATE TABLE Worker (
 WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 FIRST_NAME CHAR(25),
 LAST_NAME CHAR(25),
 SALARY INT(15),
 JOINING_DATE DATETIME,
 DEPARTMENT CHAR(25)
);
INSERT INTO Worker
 (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
 (001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
 (002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
 (003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
 (004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
 (005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
 (006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
 (007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
 (008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');
CREATE TABLE Bonus (
 WORKER_REF_ID INT,
 BONUS_AMOUNT INT(10),
 BONUS_DATE DATETIME,
 FOREIGN KEY (WORKER_REF_ID)
 REFERENCES Worker(WORKER_ID)
 ON DELETE CASCADE
); 
INSERT INTO Bonus
 (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
 (001, 5000, '16-02-20'),
 (002, 3000, '16-06-11'),
 (003, 4000, '16-02-20'),
 (001, 4500, '16-02-20'),
 (002, 3500, '16-06-11');
CREATE TABLE Title (
 WORKER_REF_ID INT,
 WORKER_TITLE CHAR(25),
 AFFECTED_FROM DATETIME,
 FOREIGN KEY (WORKER_REF_ID)
 REFERENCES Worker(WORKER_ID)
 ON DELETE CASCADE
);
INSERT INTO Title
 (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
 (001, 'Manager', '2016-02-20 00:00:00'),
 (002, 'Executive', '2016-06-11 00:00:00'),
 (008, 'Executive', '2016-06-11 00:00:00'),
 (005, 'Manager', '2016-06-11 00:00:00'),
 (004, 'Asst. Manager', '2016-06-11 00:00:00'),
 (007, 'Executive', '2016-06-11 00:00:00'),
 (006, 'Lead', '2016-06-11 00:00:00'),
 (003, 'Lead', '2016-06-11 00:00:00'); 

mysql> select * from worker;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+

mysql> select * from bonus ;
+---------------+--------------+---------------------+
| WORKER_REF_ID | BONUS_AMOUNT | BONUS_DATE          |
+---------------+--------------+---------------------+
|             1 |         5000 | 2016-02-20 00:00:00 |
|             2 |         3000 | 2016-06-11 00:00:00 |
|             3 |         4000 | 2016-02-20 00:00:00 |
|             1 |         4500 | 2016-02-20 00:00:00 |
|             2 |         3500 | 2016-06-11 00:00:00 |
+---------------+--------------+---------------------+

mysql> select * from title;
+---------------+---------------+---------------------+
| WORKER_REF_ID | WORKER_TITLE  | AFFECTED_FROM       |
+---------------+---------------+---------------------+
|             1 | Manager       | 2016-02-20 00:00:00 |
|             2 | Executive     | 2016-06-11 00:00:00 |
|             8 | Executive     | 2016-06-11 00:00:00 |
|             5 | Manager       | 2016-06-11 00:00:00 |
|             4 | Asst. Manager | 2016-06-11 00:00:00 |
|             7 | Executive     | 2016-06-11 00:00:00 |
|             6 | Lead          | 2016-06-11 00:00:00 |
|             3 | Lead          | 2016-06-11 00:00:00 |
+---------------+---------------+---------------------+





-- 1. SOLVE THE BELOW QUESTIONS EACH QUESTION OF 2 MARKS

--  i. WRITE AN SQL QUERY TO FETCH FULLNAME , SALARY , JOINING_DATE AND DEPARTMENT FROM WORKER TABLE.
    mysql> select concat(first_name, " ", last_name) as fullname, salary, joining_date, department from worker;
    +-----------------+--------+---------------------+------------+
    | fullname        | salary | joining_date        | department |
    +-----------------+--------+---------------------+------------+
    | Monika Arora    | 100000 | 2014-02-20 09:00:00 | HR         |
    | Niharika Verma  |  80000 | 2014-06-11 09:00:00 | Admin      |
    | Vishal Singhal  | 300000 | 2014-02-20 09:00:00 | HR         |
    | Amitabh Singh   | 500000 | 2014-02-20 09:00:00 | Admin      |
    | Vivek Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
    | Vipul Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
    | Satish Kumar    |  75000 | 2014-01-20 09:00:00 | Account    |
    | Geetika Chauhan |  90000 | 2014-04-11 09:00:00 | Admin      |
    +-----------------+--------+---------------------+------------+

--  ii.WRITE AN SQL QUERY TO FETCH ID , FULLNAME , SALARY AND DEPARTMENT WHOSE DEPARTMENT IS HR OR ADMIN
    mysql>  select worker_id as id, concat(first_name, " ", last_name) as fullname, salary,department from worker where department = "HR" or department="Admin";
    +----+-----------------+--------+------------+
    | id | fullname        | salary | department |
    +----+-----------------+--------+------------+
    |  1 | Monika Arora    | 100000 | HR         |
    |  2 | Niharika Verma  |  80000 | Admin      |
    |  3 | Vishal Singhal  | 300000 | HR         |
    |  4 | Amitabh Singh   | 500000 | Admin      |
    |  5 | Vivek Bhati     | 500000 | Admin      |
    |  8 | Geetika Chauhan |  90000 | Admin      |
    +----+-----------------+--------+------------+


--  iii.WRITE AN SQL QUERY TO FETCH ID , FULLNAME , SALARY WHOSE FIRST_NAME ENDS WITH 'a'
    mysql> select worker_id as id, concat(first_name, " ", last_name) as fullname, salary from worker where first_name  like  "a%";
    +----+---------------+--------+
    | id | fullname      | salary |
    +----+---------------+--------+
    |  4 | Amitabh Singh | 500000 |
    +----+---------------+--------+

--  iv. WRITE AN SQL QUERY TO FEACH ALL RECORDS OF WORKER TABLE WHO HAVE JOIN IN FEB 2020
    mysql> select * from worker where joining_date between "2014-02-01" and "2014-02-28";
    +-----------+------------+-----------+--------+---------------------+------------+
    | WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
    +-----------+------------+-----------+--------+---------------------+------------+
    |         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
    |         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
    |         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
    +-----------+------------+-----------+--------+---------------------+------------+

    or
    mysql> select * from worker where Month(joining_date)=2 and Year(Joining_date)=2014;
    +-----------+------------+-----------+--------+---------------------+------------+
    | WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
    +-----------+------------+-----------+--------+---------------------+------------+
    |         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
    |         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
    |         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
    +-----------+------------+-----------+--------+---------------------+------------+

--  V. WRITE AN SQL QUERY TO FETCH ALL RECORDS OF WORKER TABLE WHO HAVE SALARY >=50000 AND <=100000.
    mysql> select * from worker where salary between 50000 and 100000;
    +-----------+------------+-----------+--------+---------------------+------------+
    | WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
    +-----------+------------+-----------+--------+---------------------+------------+
    |         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
    |         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
    |         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
    |         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
    +-----------+------------+-----------+--------+---------------------+------------+


-- 2. SOLVE THE BELOW QUESTIONS EACH QUESTION OF 3 MARKS

--  i. WRITE AN SQL QUERY TO DISPLAY NUMBER OF WORKER IN EACH DEPARTMENT ALONG WITH UNIQUE DEPARTMENT NAME
    mysql>  select count(*), department from worker group by department;
    +----------+------------+
    | count(*) | department |
    +----------+------------+
    |        2 | HR         |
    |        4 | Admin      |
    |        2 | Account    |
    +----------+------------+

--  ii.WRITE AN SQL QUERY TO DISPLAY DEPARTMENT NAME AND TOTAL BONUS AMOUNT TO BE PAID IN EACH DEPARTMENT

--  iii.WRITE AN SQL QUERY TO DISPALY THE FULLNAME , SALARY , TOTAL YEARS OF EXPERIANCE OF EACH WORKER
select concat(first_name, " ", last_name) as fullname, salary, 

--  iv.WRITE AN SQL QUERY TO DISPALY THE DETAILS OF THE WORKER WHO IS MANAGER 
    mysql> select * from  worker w join title t on w.worker_id= t.worker_ref_id  where t.worker_title="Manager";
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
    | WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT | WORKER_REF_ID | WORKER_TITLE | AFFECTED_FROM       |
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
    |         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |             1 | Manager      | 2016-02-20 00:00:00 |
    |         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |             5 | Manager      | 2016-06-11 00:00:00 |
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+