  -- assignement 5
  
  
create database department;
Query OK, 1 row affected (0.01 sec)

mysql> use department;
Database changed

mysql> create table employee ( emp_id int primary key, f_name varchar(20),l_name varchar(20),salary long,
    -> j_date date, dept varchar(20));
Query OK, 0 rows affected (0.01 sec)

mysql> desc employee
    -> ;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| emp_id | int         | NO   | PRI | NULL    |       |
| f_name | varchar(20) | YES  |     | NULL    |       |
| l_name | varchar(20) | YES  |     | NULL    |       |
| salary | mediumtext  | YES  |     | NULL    |       |
| j_date | date        | YES  |     | NULL    |       |
| dept   | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
6 rows in set (0.01 sec)


mysql> alter table employee modify  column salary double;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee
    -> ;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| emp_id | int         | NO   | PRI | NULL    |       |
| f_name | varchar(20) | YES  |     | NULL    |       |
| l_name | varchar(20) | YES  |     | NULL    |       |
| salary | double      | YES  |     | NULL    |       |
| j_date | date        | YES  |     | NULL    |       |
| dept   | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)


mysql> create table reward ( emp_ref_id int constraint fk_reward_emp foreign key (emp_ref_id) refer^Cces employee(emp_id), date_reward date, amount doublmysql> create table reward ( emp_ref_id int, date_reward date, amount double, constraint fk_reward_emp foreign key (emp_ref_id) references employee(emp_id));
Query OK, 0 rows affected (0.01 sec)

mysql> desc reward;
+-------------+--------+------+-----+---------+-------+
| Field       | Type   | Null | Key | Default | Extra |
+-------------+--------+------+-----+---------+-------+
| emp_ref_id  | int    | YES  | MUL | NULL    |       |
| date_reward | date   | YES  |     | NULL    |       |
| amount      | double | YES  |     | NULL    |       |
+-------------+--------+------+-----+---------+-------+
3 rows in set (0.01 sec)

1. Get all employees.
mysql>select * from employee;
+--------+---------+-----------+---------+------------+-----------+
| emp_id | f_name  | l_name    | salary  | j_date     | dept      |
+--------+---------+-----------+---------+------------+-----------+
|      1 | Bob     | Kinto     | 1000000 | 2019-01-20 | Finance   |
|      2 | Jerry   | Kansxo    | 6000000 | 2019-01-15 | IT        |
|      3 | Philip  | Jose      | 8900000 | 2019-02-05 | Banking   |
|      4 | John    | Abraham   | 2000000 | 2019-02-25 | Insurance |
|      5 | Michael | Mathew    | 2200000 | 2019-02-28 | Finance   |
|      6 | Alex    | Chereketo | 4000000 | 2019-05-10 | IT        |
|      7 | Yohan   | Soso      | 1230000 | 2019-06-20 | Banking   |
+--------+---------+-----------+---------+------------+-----------+


2. Display the first name and last name of all employees.

mysql>select f_name, l_name from employee;
+---------+-----------+
| f_name  | l_name    |
+---------+-----------+
| Bob     | Kinto     |
| Jerry   | Kansxo    |
| Philip  | Jose      |
| John    | Abraham   |
| Michael | Mathew    |
| Alex    | Chereketo |
| Yohan   | Soso      |



3. Display all the values of the “First_Name” column using the alias “Employee Name”
mysql>select f_name as "Employee Name" from employee;
+---------------+
| Employee Name |
+---------------+
| Bob           |
| Jerry         |
| Philip        |
| John          |
| Michael       |
| Alex          |
| Yohan         |
+---------------+



4. Get all “Last_Name” in lowercase.
mysql>select lower(l_name) as "Lowercase" from employee;
+-----------+
| Lowercase |
+-----------+
| kinto     |
| kansxo    |
| jose      |
| abraham   |
| mathew    |
| chereketo |
| soso      |
+-----------+




5. Get all “Last_Name” in uppercase.
mysql>select upper(l_name) as "Lowercase" from employee;
+-----------+
| Lowercase |
+-----------+
| KINTO     |
| KANSXO    |
| JOSE      |
| ABRAHAM   |
| MATHEW    |
| CHEREKETO |
| SOSO      |
+-----------+



6. Get unique “DEPARTMENT”.
mysql> select distinct dept from employee;
+-----------+
| dept      |
+-----------+
| Finance   |
| IT        |
| Banking   |
| Insurance |
+-----------+
4 rows in set (0.00 sec)



7. Get the first 4 characters of “FIRST_NAME” column.
mysql> select left(f_name,4) from employee;
+----------------+
| left(f_name,4) |
+----------------+
| Bob            |
| Jerr           |
| Phil           |
| John           |
| Mich           |
| Alex           |
| Yoha           |
+----------------+
7 rows in set (0.00 sec)



8. Get the position of the letter ‘h’ in ‘John’.
mysql> select instr(f_name,"h") from employee where emp_id=4;
+-------------------+
| instr(f_name,"h") |
+-------------------+
|                 3 |
+-------------------+



9. Get all values from the “FIRST_NAME” column after removing white space on the right.
mysql> select rtrim(f_name) from employee ;
+---------------+
| rtrim(f_name) |
+---------------+
| Bob           |
| Jerry         |
| Philip        |
| John          |
| Michael       |
| Alex          |
| Yohan         |
+---------------+


10. Get all values from the “FIRST_NAME” column after removing white space on the left.
mysql> select ltrim(f_name) from employee ;
+---------------+
| ltrim(f_name) |
+---------------+
| Bob           |
| Jerry         |
| Philip        |
| John          |
| Michael       |
| Alex          |
| Yohan         |
+---------------+


11. Write the syntax to create the “employee” table.
mysql> create table employee ( emp_id int primary key, f_name varchar(20),l_name varchar(20),salary long,
    -> j_date date, dept varchar(20));
Query OK, 0 rows affected (0.01 sec)

mysql> desc employee
    -> ;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| emp_id | int         | NO   | PRI | NULL    |       |
| f_name | varchar(20) | YES  |     | NULL    |       |
| l_name | varchar(20) | YES  |     | NULL    |       |
| salary | mediumtext  | YES  |     | NULL    |       |
| j_date | date        | YES  |     | NULL    |       |
| dept   | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
6 rows in set (0.01 sec)
