  -- assignement 7

mysql> create database department2;
Query OK, 1 row affected (0.01 sec)

mysql> use department2;
Database changed
mysql> show tables;
Empty set (0.00 sec)

mysql> create table employee (
    -> empid int,
    -> empname varchar(20),
    -> department varchar(20),
    -> contact long,
    -> email varchar(30),
    -> empheadid int);
Query OK, 0 rows affected (0.02 sec)

mysql> desc employee;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| empid      | int         | YES  |     | NULL    |       |
| empname    | varchar(20) | YES  |     | NULL    |       |
| department | varchar(20) | YES  |     | NULL    |       |
| contact    | mediumtext  | YES  |     | NULL    |       |
| email      | varchar(30) | YES  |     | NULL    |       |
| empheadid  | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)


mysql> alter table employee rename column empid to emp_id;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee rename column empname to emp_name;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee rename column empheadid to emp_head_id;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| emp_id      | int         | YES  |     | NULL    |       |
| emp_name    | varchar(20) | YES  |     | NULL    |       |
| department  | varchar(20) | YES  |     | NULL    |       |
| contact     | mediumtext  | YES  |     | NULL    |       |
| email       | varchar(30) | YES  |     | NULL    |       |
| emp_head_id | int         | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> alter table employee add constraint primary key (emp_id);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| emp_id      | int         | NO   | PRI | NULL    |       |
| emp_name    | varchar(20) | YES  |     | NULL    |       |
| department  | varchar(20) | YES  |     | NULL    |       |
| contact     | mediumtext  | YES  |     | NULL    |       |
| email       | varchar(30) | YES  |     | NULL    |       |
| emp_head_id | int         | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> create table emp_dept(
    -> dept_id int,
    -> dept_name varchar(20),
    -> dept_off varchar(10),
    -> dept_head int,
    -> constraint fk_emp_dept_employee foreign key (dept_id) references employee(emp_id));
Query OK, 0 rows affected (0.01 sec)

mysql> desc emp_dept;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| dept_id   | int         | YES  | MUL | NULL    |       |
| dept_name | varchar(20) | YES  |     | NULL    |       |
| dept_off  | varchar(10) | YES  |     | NULL    |       |
| dept_head | int         | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> create table emp_salary (
    -> emp_id int,
    -> salary long,
    -> is_permanent varchar(10),
    -> constraint fk_emp_salary_employee foreign key (emp_id) references employee(emp_id));
Query OK, 0 rows affected (0.01 sec)

mysql> desc emp_salary;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| emp_id       | int         | YES  | MUL | NULL    |       |
| salary       | mediumtext  | YES  |     | NULL    |       |
| is_permanent | varchar(10) | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> create table project(
    -> project_id varchar(10),
    -> duration int );
Query OK, 0 rows affected (0.01 sec)

mysql> desc project;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| project_id | varchar(10) | YES  |     | NULL    |       |
| duration   | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> create table country( c_id varchar(10), c_name varchar(20) );
Query OK, 0 rows affected (0.01 sec)

mysql> desc country;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| c_id   | varchar(10) | YES  |     | NULL    |       |
| c_name | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> alter table emp_dept add constraint primary key (dept_id);
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table emp_salary add constraint primary key (emp_id);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> show tables;
+-----------------------+
| Tables_in_department2 |
+-----------------------+
| country               |
| emp_dept              |
| emp_salary            |
| employee              |
| project               |
+-----------------------+
5 rows in set (0.00 sec)

mysql> create table client(
    -> client_id varchar(10),
    -> client_name varchar(20),
    -> c_id varchar(10),
    -> constraint fk_client_country foreign key (c_id) references country(c_id));
Query OK, 0 rows affected (0.01 sec)


mysql> create table emp_project( emp_id int, project_id varchar(10), client_id varchar(10), start_year int, end_year int, primary key (emp_id), constraint fk_emp_project_emp_id_employee foreign key (emp_id) references employee(emp_id), constraint fk_emp_project_project_id_project foreign key (project_id) references project(project_id),constraint fk_emp_project_client_id_client foreign key (client_id) references client(client_id));
Query OK, 0 rows affected (0.02 sec)

mysql> desc emp_project;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| emp_id     | int         | NO   | PRI | NULL    |       |
| project_id | varchar(10) | YES  | MUL | NULL    |       |
| client_id  | varchar(10) | YES  | MUL | NULL    |       |
| start_year | int         | YES  |     | NULL    |       |
| end_year   | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

####################################################################################################3

1. Select the detail of the employee whose name start with P.
mysql> select * from employee where emp_name like 'p%';
+--------+----------+---------+------------+-----------------+-------------+
| emp_id | emp_name | dept_id | contact    | email           | emp_head_id |
+--------+----------+---------+------------+-----------------+-------------+
|    102 | Priya    | E-104   | 7456267890 | priya@yahoo.com |         103 |
+--------+----------+---------+------------+-----------------+-------------+


2. How many permanent candidate take salary more than 5000.
mysql> select * from emp_salary where is_permanent = "Yes" and salary > 5000;
+--------+--------+--------------+
| emp_id | salary | is_permanent |
+--------+--------+--------------+
|    102 | 10000  | Yes          |
+--------+--------+--------------+


3. Select the detail of employee whose emailId is in gmail.
mysql> select * from employee where email like '%gmail%';
+--------+----------+---------+------------+--------------------+-------------+
| emp_id | emp_name | dept_id | contact    | email              | emp_head_id |
+--------+----------+---------+------------+--------------------+-------------+
|    101 | Isha     | E-101   | 1234567890 | isha@gmail.com     |         105 |
|    103 | Neha     | E-101   | 4556267890 | neha@gmail.com     |         101 |
|    105 | Abhishek | E-101   | 9854787890 | abhishek@gmail.com |         102 |
+--------+----------+---------+------------+--------------------+-------------+



4. Select the details of the employee who work either for department E-104 or E-102.
mysql> select * from employee where dept_id="E-102" or dept_id="E-104";
+--------+----------+---------+------------+-----------------+-------------+
| emp_id | emp_name | dept_id | contact    | email           | emp_head_id |
+--------+----------+---------+------------+-----------------+-------------+
|    102 | Priya    | E-104   | 7456267890 | priya@yahoo.com |         103 |
|    104 | Rahul    | E-102   | 1496267890 | rahul@yahoo.com |         105 |
+--------+----------+---------+------------+-----------------+-------------+


5. What is the department name for DeptID E-102?
mysql> select dept_name from emp_dept where dept_id="E-102";
+-------------+
| dept_name   |
+-------------+
| Development |
+-------------+


6. What is total salarythat is paid to permanent employees?
mysql> select sum(salary) from  emp_salary where is_permanent="Yes";
+-------------+
| sum(salary) |
+-------------+
|       16200 |
+-------------+


7. List name of all employees whose name ends with a.
mysql> select emp_name from employee where emp_name like "%a";
+----------+
| emp_name |
+----------+
| Isha     |
| Priya    |
| Neha     |
+----------+

**8. List the number of department of employees in each project.
mysql> select count(emp_id) as employee, project_id from emp_project group by project_id;
+----------+------------+
| employee | project_id |
+----------+------------+
|        2 | p-1        |
|        1 | p-2        |
|        2 | p-4        |
+----------+------------+
3 rows in set (0.00 sec)


9. How many project started in year 2010.
mysql> select count(project_id) from emp_project where start_year = 2010;
+-------------------+
| count(project_id) |
+-------------------+
|                 2 |
+-------------------+
1 row in set (0.00 sec)


10. How many project started and finished in the same year.
mysql> select count(project_id) from emp_project where start_year=end_year;
+-------------------+
| count(project_id) |
+-------------------+
|                 1 |
+-------------------+
1 row in set (0.01 sec)


11. Select the name of the employee whose name's 3rd charactor is 'h''.
mysql> select emp_name from employee where emp_name like "__h%";
+----------+
| emp_name |
+----------+
| Isha     |
| Neha     |
| Rahul    |
| Abhishek |
+----------+


12. Select the department name of the company which is assigned to the employee whose
employee id is grater 103.


13. Select the name of the employee who is working under Abhishek.
14. Select the name of the employee who is department head of HR.
15. Select the name of the employee head who is permanent.
16. Select the name and email of the Dept Head who is not Permanent.
17. Select the employee whose department off is monday
18. Select the indian clients details.
19. Select the details of all employee working in development department.
20. Create a procedure to calculate the average salaries of employees.
21. Join first tow tables using inner join.
22. Create a copy of employee table, add three extra entries in it and find the union, difference
and intersect.
23. Create a procedure to pass employee id as input and generate his id, salary, contact number
and department name as output.
24. Create a view for the data retrieved client name, project id, start and end year.
25. Calculate average salary of permanent employees.
26. Create a function to print department off when department name is given as input.
27. Write a function to deduct the 10% TDS from employees salary. The selct statement should
generate empid, salary after TDS, and department name on screen.
28. Write a cursor to extract id, name, contact and email from first table and store it in another
tenporary table.
29. Create a trigger on first table to check that user inserted dept head id between 101 and 105
or not. If he doesnt enter the same, make dept head id as 100.
30. Create a trigger to create the log for updation done on first two tables. The log table will
contain the changes made by user on both of these tables.

