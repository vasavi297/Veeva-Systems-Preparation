/*Given a employee table with columns employee id name salary dept no find and return second highest salary
find and return nth highest salary*/

Use VeevaSystems;
Show Tables;
Create table employee(
employee_id INT Primary key,
employee_name varchar (20),
salary decimal(10,2),
deptNo INT);

INSERT INTO employee (employee_id, employee_name, salary, deptNo)
VALUES
(101, 'Ravi', 30000, 10),
(102, 'Sita', 45000, 20),
(103, 'Kiran', 35000, 10),
(104, 'Anu', 50000, 30),
(105, 'Rahul', 40000, 20),
(106, 'Priya', 55000, 30),
(107, 'Vijay', 28000, 10),
(108, 'Sneha', 60000, 20);

select salary from(
Select employee_id,salary,dense_rank() over(order by salary desc) as rnk
from employee)as e
where rnk=2;

set @n=5;
select salary from(select employee_id,salary,dense_rank() over(order by salary desc) as rnk
from employee)as e
where rnk=@n;


