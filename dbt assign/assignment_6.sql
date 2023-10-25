  -- assignement 6



1. Select FIRST_NAME AS WORKER_NAME from Worker;
2.Select upper(FIRST_NAME) from Worker;
3.Select distinct DEPARTMENT from Worker;
4.Select substring(FIRST_NAME,1,3) from Worker;
5.Select INSTR(FIRST_NAME, BINARY'a') from Worker where FIRST_NAME ='Amitabh';
6.Select INSTR(FIRST_NAME, BINARY'a') from Worker where FIRST_NAME ='Amitabh';
7.Select LTRIM(DEPARTMENT) from Worker;
8.Select distinct length(DEPARTMENT) from Worker;
9.Select REPLACE(FIRST_NAME,'a','A') from Worker;
10.Select CONCAT(FIRST_NAME, ' ', LAST_NAME) AS 'COMPLETE_NAME' fromWorker;
11.Select * from Worker order by FIRST_NAME asc;
12.Select * from Worker order by FIRST_NAME asc,DEPARTMENT desc;
13.Select * from Worker where FIRST_NAME in ('Vipul','Satish');
14.Select * from Worker where FIRST_NAME not in ('Vipul','Satish');
15.Select * from Worker where DEPARTMENT like 'Admin%'; 
16.Select * from Worker where FIRST_NAME like '%a%';
17.Select * from Worker where FIRST_NAME like '%a';
18.Select * from Worker where FIRST_NAME like '_____h';
19.Select * from Worker where SALARY between 100000 and 500000;
20.Select * from Worker where year(JOINING_DATE) = 2014 and month(JOINING_DATE)= 2; 
21.SELECT COUNT(*) FROM worker WHERE DEPARTMENT = 'Admin';
22.SELECT CONCAT(FIRST_NAME, ' ', LAST_NAME) As Worker_Name, SalaryFROM workerWHERE WORKER_ID IN(SELECT WORKER_ID FROM workerWHERE Salary BETWEEN 50000 AND 100000);
23.SELECT DEPARTMENT, count(WORKER_ID) No_Of_WorkersFROM workerGROUP BY DEPARTMENTORDER BY No_Of_Workers DESC
24.SELECT DISTINCT W.FIRST_NAME, T.WORKER_TITLEFROM Worker WINNER JOIN Title TON W.WORKER_ID = T.WORKER_REF_ID AND T.WORKER_TITLE in ('Manager'); 
25.SELECT WORKER_TITLE, AFFECTED_FROM, COUNT(*)FROM TitleGROUP BY WORKER_TITLE, AFFECTED_FROMHAVING COUNT(*) > 1;
26.SELECT * FROM Worker WHERE MOD (WORKER_ID, 2) <> 0;
27.SELECT * FROM Worker WHERE MOD (WORKER_ID, 2) = 0;
28.SELECT * INTO WorkerClone FROM Worker WHERE 1 = 0

29.(SELECT * FROM Worker)INTERSECT(SELECT * FROM WorkerClone); 
30.SELECT * FROM WorkerMINUSSELECT * FROM Title;
31.SELECT NOW();
32.SELECT * FROM Worker ORDER BY Salary DESC LIMIT 10;
33.SELECT TOP 1 SalaryFROM (SELECT DISTINCT TOP n SalaryFROM WorkerORDER BY Salary DESC)ORDER BY Salary ASC
34.ELECT SalaryFROM Worker W1WHERE 4 = (SELECT COUNT( DISTINCT ( W2.Salary ) )FROM Worker W2WHERE W2.Salary >= W1.Salary
35.Select distinct W.WORKER_ID, W.FIRST_NAME, W.Salaryfrom Worker W, Worker W1where W.Salary = W1.Salaryand W.WORKER_ID != W1.WORKER_ID;
36.elect max(Salary) from Workerwhere Salary not in (Select max(Salary) from Worker);
37.select FIRST_NAME, DEPARTMENT from worker W where W.DEPARTMENT='HR'union allselect FIRST_NAME, DEPARTMENT from Worker W1 where W1.DEPARTMENT='HR';;
38.(SELECT * FROM Worker)
INTERSECT(SELECT * FROM WorkerClone);
39.SELECT *FROM WORKERWHERE WORKER_ID <= (SELECT count(WORKER_ID)/2 from Worker);
40.SELECT DEPARTMENT, COUNT(WORKER_ID) as 'Number of Workers' FROMWorker GROUP BY DEPARTMENT HAVING COUNT(WORKER_ID) < 5;
