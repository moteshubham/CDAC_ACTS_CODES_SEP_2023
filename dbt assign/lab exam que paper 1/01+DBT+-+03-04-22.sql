
To import a database via the terminal
mysql -u database_user_name -p database_name < sql_file_name.sql
for monogodb
Navigate to the directory where your CSV file is
mongoimport — db OpenFlights — collection Airport — type csv — headerline — ignoreBlanks — file [local path]
1
mongoimport --type csv -d test -c products --headerline --drop products.csv

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

nahi jamateee
SELECT
    w.department,
    SUM(b.bonus_amount) AS total_bonus_amount
FROM
    worker w
JOIN
    bonus b ON w.department_id = e.department_id
GROUP BY
    d.department_id, d.department_name;


--  iii.WRITE AN SQL QUERY TO DISPALY THE FULLNAME , SALARY , TOTAL YEARS OF EXPERIANCE OF EACH WORKER
    mysql> select concat(first_name, " ", last_name) as fullname, salary, date_format(from_days(datediff(now(), joining_date)), '%Y')+ 0 as experience from worker;
    +-----------------+--------+------------+
    | fullname        | salary | experience |
    +-----------------+--------+------------+
    | Monika Arora    | 100000 |          9 |
    | Niharika Verma  |  80000 |          9 |
    | Vishal Singhal  | 300000 |          9 |
    | Amitabh Singh   | 500000 |          9 |
    | Vivek Bhati     | 500000 |          9 |
    | Vipul Diwan     | 200000 |          9 |
    | Satish Kumar    |  75000 |          9 |
    | Geetika Chauhan |  90000 |          9 |
    +-----------------+--------+------------+

--  iv.WRITE AN SQL QUERY TO DISPALY THE DETAILS OF THE WORKER WHO IS MANAGER 
    mysql> select * from  worker w join title t on w.worker_id= t.worker_ref_id  where t.worker_title="Manager";
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
    | WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT | WORKER_REF_ID | WORKER_TITLE | AFFECTED_FROM       |
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
    |         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |             1 | Manager      | 2016-02-20 00:00:00 |
    |         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |             5 | Manager      | 2016-06-11 00:00:00 |
    +-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+


    --i. CREATE A FUNCTION IN MYSQL THAT WILL ACCEPT THE ONE INPUT PARAMETER AS WORKER ID AND BASED ON THE ID RETURN THE TOTAL SALARY IN EACH DEPARTMENTS
    delimiter &&
    create function total_salary(id int)
    returns int(11) deterministic
    begin
      declare salaryin int;
      select  salary into salaryin from worker where worker_id = id;
      return (salaryin);
    end
    &&
    delimiter ;

    --4 CREATE A CURSOR IN MYSQL, BY USING THE CURSOR RETURN THE COMMA SEPRATED LIST OF WORKER NAMES 5 MARKS eg. Monika , Vishal, Satish , Vipul ......
delimiter &&
create procedure worker_list()
begin
 declare done int default 0;
 declare n varchar(20);
 declare commalist varchar(80);
 declare mycursor CURSOR for select first_name from worker;
 declare continue handler for not found set done = 1;
 open mycursor;
 SET @commalist = '';
 lable: LOOP
  FETCH mycursor INTO n;
  if done then
   LEAVE lable;
  end if;
  if @commalist='' then
    set @commalist = concat(@commalist, n);
  else
    set  @commalist  = concat(@commalist, ",", n);
  end if;
 end LOOP lable;
 select @commalist;
 close mycursor;
end&&
delimiter ;


    --5 CREATE A AFTER INSERT TRIGGER IN MYSQL ..CREATE AN EMP_DETAILS TABLES AS FOLLOWS ID , FIRST_NAME , LAST_NAME , DEPARTMENT_ID ,SALARY WHEN AN INSERT HAPPEN INTO THE EMP_DETAILS TABLE INSERT THE FIRST_NAME , LAST_NAME AND SALARY INTO THE EMP_LOG_DETAILS TABLE
    
    create table if not exists worker_log(fname varchar(20), salary int, logtime datetime);
delimiter &&
create trigger mytrigger
after insert on worker for each row
begin
insert into worker_log values(new.first_name, new.salary, now());
end &&
delimiter ;

INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES(0010, 'Aloha', 'Mora', 99999, '15-02-20 09.00.00', 'Admin');









-- //procedure
--     delimiter &&
--     create procedure get_all_workers()
--     begin
--         select * from worker;
--     end &&
--     delimiter ;




mongodb
1.SHOW THE DOCUMENTS THAT HAS LIKES GREATER THAN 10 
db.mycol.find({"likes": {$gt:10}}).pretty();
{
        "_id" : ObjectId("65925a1dd734a3748968cbb0"),
        "title" : "MongoDB Overview",
        "description" : "MongoDB is no SQL database",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 100
}
{
        "_id" : ObjectId("65925a1dd734a3748968cbb1"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-09T21:05:00Z"),
                        "like" : 0
                }
        ]
}


2.SHOW THE DOCUMENTS THAT HAS USER NAME AS ‘user1’ 


