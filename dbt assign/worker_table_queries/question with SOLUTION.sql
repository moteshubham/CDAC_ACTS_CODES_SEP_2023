mysql> desc Worker;
+--------------+----------+------+-----+---------+----------------+
| Field        | Type     | Null | Key | Default | Extra          |
+--------------+----------+------+-----+---------+----------------+
| WORKER_ID      | int    	    | NO   | PRI | NULL    | auto_increment |
| FIRST_NAME    | char(25)  | YES  |     | NULL    |                |
| LAST_NAME    | char(25)  | YES  |     | NULL    |                |
| SALARY           | int    	   | YES  |     | NULL    |                |
| JOINING_DATE | datetime | YES  |     | NULL    |                |
| DEPARTMENT  | char(25)  | YES  |     | NULL    |                |
+--------------+----------+------+-----+---------+----------------+
6 rows in set (0.00 sec)

mysql> select * from Worker;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika       | Arora       | 100000 | 2014-02-20 09:00:00 	| HR         |
|         2 | Niharika     | Verma     |  80000 | 2014-06-11 09:00:00 		| Admin      |
|         3 | Vishal       | Singhal     | 300000 | 2014-02-20 09:00:00 	| HR         |
|         4 | Amitabh    | Singh       | 500000 | 2014-02-20 09:00:00 	| Admin      |
|         5 | Vivek        | Bhati         | 500000 | 2014-06-11 09:00:00 		| Admin      |
|         6 | Vipul        | Diwan        | 200000 | 2014-06-11 09:00:00 		| Account    |
|         7 | Satish     | Kumar        | 75000  | 2014-01-20 09:00:00 		| Account    |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 		| Admin      |
+-----------+------------+-----------+--------+---------------------+------------+
8 rows in set (0.00 sec)




mysql> desc Bonus;
+---------------+----------+------+-----+---------+-------+
| Field         | Type     | Null | Key | Default | Extra |
+---------------+----------+------+-----+---------+-------+
| WORKER_REF_ID | int      | YES  | MUL | NULL    |       |
| BONUS_AMOUNT  | int      | YES  |     | NULL    |       |
| BONUS_DATE    | datetime | YES  |     | NULL    |       |
+---------------+----------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> select * from Bonus;
+---------------+--------------+---------------------+
| WORKER_REF_ID | BONUS_AMOUNT | BONUS_DATE          |
+---------------+--------------+---------------------+
|             1 |         5000 | 2016-02-20 00:00:00 |
|             2 |         3000 | 2016-06-11 00:00:00 |
|             3 |         4000 | 2016-02-20 00:00:00 |
|             1 |         4500 | 2016-02-20 00:00:00 |
|             2 |         3500 | 2016-06-11 00:00:00 |
+---------------+--------------+---------------------+
5 rows in set (0.00 sec)




mysql> desc Title;
+---------------+----------+------+-----+---------+-------+
| Field         | Type     | Null | Key | Default | Extra |
+---------------+----------+------+-----+---------+-------+
| WORKER_REF_ID | int      | YES  | MUL | NULL    |       |
| WORKER_TITLE  | char(25) | YES  |     | NULL    |       |
| AFFECTED_FROM | datetime | YES  |     | NULL    |       |
+---------------+----------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> select * from Title;
+---------------+---------------+---------------------+
| WORKER_REF_ID | WORKER_TITLE  | AFFECTED_FROM       |
+---------------+---------------+---------------------+
|             1 | Manager      	   | 2016-02-20 00:00:00 |
|             2 | Executive    	   | 2016-06-11 00:00:00 |
|             8 | Executive    	   | 2016-06-11 00:00:00 |
|             5 | Manager    	   | 2016-06-11 00:00:00 |
|             4 | Asst. Manager | 2016-06-11 00:00:00 |
|             7 | Executive          | 2016-06-11 00:00:00 |
|             6 | Lead        	   | 2016-06-11 00:00:00 |
|             3 | Lead        	   | 2016-06-11 00:00:00 |
+---------------+---------------+---------------------+
8 rows in set (0.00 sec)





-- Q-1. Write an SQL query to fetch “FIRST_NAME” from Worker table using the alias name as <WORKER_NAME>.
mysql> select first_name as WORKER_NAME from Worker;
+-------------+
| WORKER_NAME |
+-------------+
| Monika      |
| Niharika    |
| Vishal       |
| Amitabh   |
| Vivek        |
| Vipul         |
| Satish      |
| Geetika    |
+-------------+


-- Q-2. Write an SQL query to fetch “FIRST_NAME” from Worker table in upper case.
mysql> select upper(first_name) as WORKER_NAME from Worker;
+-------------+
| WORKER_NAME |
+-------------+
| MONIKA      |
| NIHARIKA   |
| VISHAL      |
| AMITABH   |
| VIVEK         |
| VIPUL         |
| SATISH      |
| GEETIKA     |
+-------------+


-- Q-3. Write an SQL query to fetch unique values of DEPARTMENT from Worker table.
-- using group by
mysql> select department  from Worker group by department;
+------------+
| department |
+------------+
| HR         |
| Admin      |
| Account    |
+------------+


-- Q-4. Write an SQL query to print the first three characters of  FIRST_NAME from Worker table.
mysql> select substring(first_name, 1, 3) from Worker;
+-----------------------------+
| substring(first_name, 1, 3) |
+-----------------------------+
| Mon                         |
| Nih                         |
| Vis                         |
| Ami                         |
| Viv                         |
| Vip                         |
| Sat                         |
| Gee                         |
+-----------------------------+


-- Q-5. Write an SQL query to find the position of the alphabet (‘b’) in the first name column ‘Amitabh’ from Worker table.
mysql> select position('b' in 'Amitabh') from Worker;
+----------------------------+
| position('b' in 'Amitabh') |
+----------------------------+
|                          6 |
|                          6 |
|                          6 |
|                          6 |
|                          6 |
|                          6 |
|                          6 |
|                          6 |
+----------------------------+


-- Q-6. Write an SQL query to print the FIRST_NAME from Worker table after removing white spaces from the right side.

mysql> select rtrim(first_name) from Worker;
+-------------------+
| rtrim(first_name) |
+-------------------+
| Monika            |
| Niharika          |
| Vishal            |
| Amitabh           |
| Vivek             |
| Vipul             |
| Satish            |
| Geetika           |
+-------------------+
8 rows in set (0.00 sec)


-- Q-7. Write an SQL query to print the DEPARTMENT from Worker table after removing white spaces from the left side.
mysql> select ltrim(department) from Worker;
+-------------------+
| ltrim(department) |
+-------------------+
| HR                |
| Admin             |
| HR                |
| Admin             |
| Admin             |
| Account           |
| Account           |
| Admin             |
+-------------------+



-- Q-8. Write an SQL query that fetches the unique values of DEPARTMENT from Worker table and prints its length.
mysql> select distinct length( department)  from Worker;
+---------------------+
| length( department) |
+---------------------+
|                   2 |
|                   5 |
|                   7 |
+---------------------+


-- Q-9. Write an SQL query to print the FIRST_NAME from Worker table after replacing ‘a’ with ‘A’.
mysql> SELECT REPLACE(first_name,'a', 'A' ) AS Website_Name from Worker;
+--------------+
| Website_Name |
+--------------+
| MonikA       |
| NihArikA     |
| VishAl       |
| AmitAbh      |
| Vivek        |
| Vipul        |
| SAtish       |
| GeetikA      |
+--------------+


-- Q-10. Write an SQL query to print the FIRST_NAME and LAST_NAME from Worker table into a single column COMPLETE_NAME.
-- A space char should separate them.
mysql> select concat(first_name, ' ', last_name) as COMPLETE_NAME from Worker;
+-----------------+
| COMPLETE_NAME   |
+-----------------+
| Monika Arora    |
| Niharika Verma  |
| Vishal Singhal  |
| Amitabh Singh   |
| Vivek Bhati     |
| Vipul Diwan     |
| Satish Kumar    |
| Geetika Chauhan |
+-----------------+




-- Q-11. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending.
mysql> select * from Worker order by First_name;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-12. Write an SQL query to print all Worker details from the Worker table order by 
-- FIRST_NAME Ascending and DEPARTMENT Descending.
mysql> select * from Worker order by First_name asc, department desc;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+

-- using Or
-- using In

-- Q-13. Write an SQL query to print details for Workers with the first name as “Vipul” and “Satish” from Worker table.
mysql> select * from Worker where first_name = "Vipul" or first_name  =  "Satish";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+
2 rows in set (0.00 sec)



-- Q-14. Write an SQL query to print details of workers excluding first names, “Vipul” and “Satish” from Worker table.

mysql> select * from Worker where first_name = "Vipul" or first_name  =  "Satish";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+

mysql> select * from Worker where first_name in ("Vipul", "Satish");
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+



-- Q-15. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin*”.
mysql> select * from Worker where department = "Admin";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+
mysql> select * from Worker where department in ("Admin");
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-16. Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.
mysql> select * from Worker where first_name like "%a%";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+

-- Q-17. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘a’.
mysql> select * from Worker where first_name like "%a";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-18. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘h’ and contains six alphabets.
mysql> select * from Worker where first_name like "_____h";
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-19. Write an SQL query to print details of the Workers whose SALARY lies between 100000 and 500000.
mysql> select * from Worker where salary between 100000 and 500000
    -> ;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-20. Write an SQL query to print details of the Workers who have joined in Feb’2014.
mysql> select * from Worker where month(joining_date) = 02;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+



-- Q-21. Write an SQL query to fetch the count of employees working in the department ‘Admin’.
mysql> select count(*) from Worker where department = "Admin";
+----------+
| count(*) |
+----------+
|        4 |
+----------+



-- Q-22. Write an SQL query to fetch worker full names with salaries >= 50000 and <= 100000.
mysql> select concat(first_name, " ", last_name)as Full_Name, salary from Worker wher
e salary >= 50000 and salary <=100000;
+-----------------+--------+
| Full_Name       | salary |
+-----------------+--------+
| Monika Arora    | 100000 |
| Niharika Verma  |  80000 |
| Satish Kumar    |  75000 |
| Geetika Chauhan |  90000 |
+-----------------+--------+


-- Q-23. Write an SQL query to fetch the no. of workers for each department in the descending order.
mysql> select count(*), department from Worker group by department order by count(*)
desc;
+----------+------------+
| count(*) | department |
+----------+------------+
|        4 | Admin      |
|        2 | HR         |
|        2 | Account    |
+----------+------------+



-- Q-24. Write an SQL query to print details of the Workers who are also Managers.
mysql> select * from Worker inner join Title on Worker.Worker_id = Title.Worker_ref_id and Title.worker_title = "Manager";
+-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT | WORKER_REF_ID | WORKER_TITLE | AFFECTED_FROM       |
+-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |             1 | Manager      | 2016-02-20 00:00:00 |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |             5 | Manager      | 2016-06-11 00:00:00 |
+-----------+------------+-----------+--------+---------------------+------------+---------------+--------------+---------------------+



-- Q-25. Write an SQL query to fetch number (more than 1) of same titles in the ORG of different types.
mysql> select count(*) as w, worker_title from Title group by worker_title having w> 1;
+---+--------------+
| w | worker_title |
+---+--------------+
| 2 | Manager      |
| 3 | Executive    |
| 2 | Lead         |
+---+--------------+


-- Q-26. Write an SQL query to show only odd rows from a table.
-- select * from worker where MOD (WORKER_ID, 2) != 0; 
mysql> select * from Worker where MOD (WORKER_ID, 2) != 0;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-27. Write an SQL query to show only even rows from a table. 
mysql> select * from Worker where MOD(worker_id, 2) =0;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+


-- Q-28. Write an SQL query to clone a new table from another table.
mysql> create table temp select * from Worker;
Query OK, 8 rows affected (0.04 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> select * from temp;
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


-- Q-29. Write an SQL query to fetch intersecting records of two tables.
mysql> select * from Worker INNER JOIN Title ON Worker.worker_id = Title.worker_ref_id;
+-----------+------------+-----------+--------+---------------------+------------+---------------+---------------+---------------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT | WORKER_REF_ID | WORKER_TITLE  | AFFECTED_FROM       |
+-----------+------------+-----------+--------+---------------------+------------+---------------+---------------+---------------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |             1 | Manager       | 2016-02-20 00:00:00 |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |             2 | Executive     | 2016-06-11 00:00:00 |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |             3 | Lead          | 2016-06-11 00:00:00 |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |             4 | Asst. Manager | 2016-06-11 00:00:00 |
|         5 | Vivek      | Bhati     | 500000 | 2014-06-11 09:00:00 | Admin      |             5 | Manager       | 2016-06-11 00:00:00 |
|         6 | Vipul      | Diwan     | 200000 | 2014-06-11 09:00:00 | Account    |             6 | Lead          | 2016-06-11 00:00:00 |
|         7 | Satish     | Kumar     |  75000 | 2014-01-20 09:00:00 | Account    |             7 | Executive     | 2016-06-11 00:00:00 |
|         8 | Geetika    | Chauhan   |  90000 | 2014-04-11 09:00:00 | Admin      |             8 | Executive     | 2016-06-11 00:00:00 |
+-----------+------------+-----------+--------+---------------------+------------+---------------+---------------+---------------------+


-- Q-30. Write an SQL query to show records from one table that another table does not have.
-- MINUS

-- Q-31. Write an SQL query to show the current date and time.
-- DUAL
mysql> select curdate();
+------------+
| curdate()  |
+------------+
| 2023-10-22 |
+------------+

mysql> select curtime();
+-----------+
| curtime() |
+-----------+
| 11:46:35  |

mysql> select now();
+---------------------+
| now()               |
+---------------------+
| 2023-10-22 11:47:08 |
+---------------------+



-- Q-32. Write an SQL query to show the top n (say 5) records of a table order by descending salary.
mysql> select first_name, salary from Worker order by salary desc limit 5;
+------------+--------+
| first_name | salary |
+------------+--------+
| Amitabh    | 500000 |
| Vivek      | 500000 |
| Vishal     | 300000 |
| Vipul      | 200000 |
| Monika     | 100000 |
+------------+--------+


-- Q-33. Write an SQL query to determine the nth (say n=5) highest salary from a table.
mysql> select first_name, salary from Worker order by salary desc limit 4, 1;
+------------+--------+
| first_name | salary |
+------------+--------+
| Monika     | 100000 |
+------------+--------+


-- Q-34. Write an SQL query to determine the 5th highest salary without using LIMIT keyword.

 
-- Q-35. Write an SQL query to fetch the list of employees with the same salary.
select distinct w.first_name, w.salary from Worker w, Worker m where w.salary =
 m.salary and w.worker_id <> m.worker_id;
+------------+--------+
| first_name | salary |
+------------+--------+
| Vivek      | 500000 |
| Amitabh    | 500000 |
+------------+--------+



-- Q-36. Write an SQL query to show the second highest salary from a table using sub-query.

mysql> select max(salary) from Worker where (select max(salary) from Worker) not in (select max(salary));
+-------------+
| max(salary) |
+-------------+
|      300000 |
+-------------+


-- third highest for homework

-- Q-37. Write an SQL query to show one row twice in results from a table.
--union all
select first_name from Worker union all select first_name from Worker;
+------------+
| first_name |
+------------+
| Monika     |
| Niharika   |
| Vishal     |
| Amitabh    |
| Vivek      |
| Vipul      |
| Satish     |
| Geetika    |
| Monika     |
| Niharika   |
| Vishal     |
| Amitabh    |
| Vivek      |
| Vipul      |
| Satish     |
| Geetika    |
+------------+


-- Q-38. Write an SQL query to list worker_id who does not get bonus.
--not in    worker id from bonus table -- inner query then not in  then where
mysql> select worker_id from Worker where worker_id not in (select worker_ref_id from
Bonus group by worker_ref_id);
+-----------+
| worker_id |
+-----------+
|         4 |
|         5 |
|         6 |
|         7 |
|         8 |
+-----------+


-- Q-39. Write an SQL query to fetch the first 50% records from a table.
-- worker_id auto incre count -- divide 2
mysql> select * from Worker where worker_id <= (select count(worker_id) from Worker) div 2;
+-----------+------------+-----------+--------+---------------------+------------+
| WORKER_ID | FIRST_NAME | LAST_NAME | SALARY | JOINING_DATE        | DEPARTMENT |
+-----------+------------+-----------+--------+---------------------+------------+
|         1 | Monika     | Arora     | 100000 | 2014-02-20 09:00:00 | HR         |
|         2 | Niharika   | Verma     |  80000 | 2014-06-11 09:00:00 | Admin      |
|         3 | Vishal     | Singhal   | 300000 | 2014-02-20 09:00:00 | HR         |
|         4 | Amitabh    | Singh     | 500000 | 2014-02-20 09:00:00 | Admin      |
+-----------+------------+-----------+--------+---------------------+------------+



-- Q-40. Write an SQL query to fetch the departments that have less than 4 people in it.
--group by having

-- Q-41. Write an SQL query to show all departments along with the number of people in there.
-- group by

-- Q-42. Write an SQL query to show the last record from a table.
--workerid auto incre max of workeid

-- Q-43. Write an SQL query to fetch the first row of a table.
--min of workerid

-- Q-44. Write an SQL query to fetch the last five records from a table.
--  desc sort workerid order by again

-- Q-45. Write an SQL query to print the name of employees having the highest salary in each department.
--inner join

-- Q-46. Write an SQL query to fetch three max salaries from a table using co-related subquery

-- DRY RUN AFTER REVISING THE CORELATED SUBQUERY CONCEPT FROM LEC-9.


-- Q-47. Write an SQL query to fetch three min salaries from a table using co-related subquery


-- Q-48. Write an SQL query to fetch nth max salaries from a table.


-- Q-49. Write an SQL query to fetch departments along with the total salaries paid for each of them.


-- Q-50. Write an SQL query to fetch the names of workers who earn the highest salary.
