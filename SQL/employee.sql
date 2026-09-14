CREATE TABLE emp_department (
    DPT_CODE INT PRIMARY KEY,
    DPT_NAME VARCHAR(50),
    DPT_ALLOTMENT DECIMAL(10,2)
);

CREATE TABLE emp_details (
    EMP_IDNO INT PRIMARY KEY,
    EMP_FNAME VARCHAR(50),
    EMP_LNAME VARCHAR(50),
    EMP_DEPT INT,
    FOREIGN KEY (EMP_DEPT) REFERENCES emp_department(DPT_CODE)
);

INSERT INTO emp_department
(DPT_CODE, DPT_NAME, DPT_ALLOTMENT)
VALUES
(57, 'IT', 65000),
(63, 'Finance', 15000),
(47, 'HR', 240000),
(27, 'RD', 55000),
(89, 'QC', 75000);

INSERT INTO emp_details
(EMP_IDNO, EMP_FNAME, EMP_LNAME, EMP_DEPT)
VALUES
(127323, 'Michale', 'Robbin', 57),
(526689, 'Carlos', 'Snares', 63),
(843795, 'Enric', 'Dosio', 57),
(328717, 'Jhon', 'Snares', 63),
(444527, 'Joseph', 'Dosni', 47),
(659831, 'Zanifer', 'Emily', 47),
(847674, 'Kuleswar', 'Sitaraman', 57),
(748681, 'Henrey', 'Gabriel', 47),
(555935, 'Alex', 'Manuel', 57),
(539569, 'George', 'Mardy', 27),
(733843, 'Mario', 'Saule', 63),
(631548, 'Alan', 'Snappy', 27),
(839139, 'Maria', 'Foster', 57);

/*Write a query to find all the details of employees whose last name is Gabriel or Dosio.*/
select * from emp_details
where emp_lname ='Gabriel' or emp_lname='Dosio';

/*Write a query to display all the details of employees who work in department 89 or 63.*/
select * from emp_details 
where emp_dept=89 or emp_dept=63;

/*Question:
Write a query to display the first name and last name of employees working for the department whose allotment amount is more than 50000.*/
select e.emp_fname,e.emp_lname from emp_details e
join emp_department ed
on e.emp_dept=ed.DPT_CODE
where DPT_ALLOTMENT>50000;

/*Write a query to find the departments whose sanction amount is larger than the average sanction amount of all departments.*/
select dpt_name from emp_department
where DPT_ALLOTMENT>
(select avg(DPT_ALLOTMENT) 
from emp_department);

/*Write a query to find the names of departments where more than two employees are working.*/
select ed.dpt_name from emp_department ed
join emp_details e
on e.EMP_DEPT=ed.DPT_CODE
group by ed.dpt_name
having count(e.EMP_IDNO)>2;

/*Write a query to find the first name and last name of employees working for the department which has the second-lowest allotment*/
select e.emp_fname,e.emp_lname from emp_details e
join emp_department ed
on e.emp_dept=ed.DPT_CODE
WHERE ed.DPT_ALLOTMENT = (
    SELECT DPT_ALLOTMENT
    FROM emp_department
    ORDER BY DPT_ALLOTMENT
    LIMIT 1 OFFSET 1
);