/*Display the first name, last name, department number, and department name for each employee.*/
select e.first_name,e.last_name,d.department_id,d.department_name
from employees e
join departments d
on e.department_id=d.department_id;

/*Display the first name, last name, job title, and salary for all employees.*/
select e.first_name,e.last_name,j.job_title,e.salary
from employees e 
join jobs j
on e.job_id=j.job_id;

/*Display the first name, last name, department name, and city for each employee.*/
select e.first_name,e.last_name,d.department_name,l.city
from employees e
join departments d 
on e.department_id=d.department_id
join locations l
on d.location_id=l.location_id;

/*Display the first name, last name, job title, and department name for each employee.*/
select e.first_name,e.last_name,j.job_title,d.department_name
from employees e 
join jobs j 
on e.job_id=j.job_id
join departments d
on e.department_id=d.department_id;

/*Display the first name, last name, salary, and grade level for each employee.*/
select e.first_name,e.last_name,e.salary,j.grade_level
from employees e 
join job_grade j 
on e.salary between j.lowest_sal and j.highest_sal;

/*Display the employee first name, last name, and their manager's first name and last name.*/
select e.first_name,e.last_name ,m.first_name,m.last_name
from employees e
join employees m 
on e.manager_id=m.employee_id;

/*Display the first name, last name, and department name for employees who work in the 'IT' department.*/
select e.first_name,e.last_name,d.department_name
from employees e
join departments d 
on e.department_id=d.department_id
where d.department_name='IT';

/*Display the first name, last name, and salary of employees whose salary is greater than 10,000.*/
select e.first_name,e.last_name,e.salary 
from employees e
where e.salary > 10000;

/*Display the first name, last name, and job title for employees who work as 'Programmer'.*/
select e.first_name,e.last_name,j.job_title 
from employees e 
join jobs j 
on e.job_id=j.job_id
where j.job_title='Programmer';

/*Display the first name, last name, and salary of employees who earn between 5,000 and 10,000.*/
select e.first_name,e.last_name,e.salary
from employees e 
where e.salary between 5000 and 10000;

/*Display the first name, last name, department name, and city for employees who work in the 'Seattle' city.*/
select e.first_name,e.last_name,d.department_name,l.city
from employees e
join departments d 
on e.department_id=d.department_id 
join locations l 
on d.location_id=l.location_id 
where l.city='Seattle';

/*Display the first name, last name, department name, and job title for employees working in the 'Sales' department.*/
select e.first_name,e.last_name,d.department_name,j.job_title 
from employees e 
join departments d 
on e.department_id=d.department_id
join jobs j 
on e.job_id=j.job_id 
where d.department_name='Sales';

/*Display the first name, last name, and salary of employees who work in the 'IT' department and earn more than 5,000.*/
select e.first_name,e.last_name,e.salary 
from employees e 
join departments d 
on d.department_id=e.department_id 
where d.department_name='IT' and e.salary>5000;

/*Display the first name, last name, department name, and city for employees whose salary is greater than 10,000.*/
select e.first_name,e.last_name,d.department_name,l.city 
from employees e 
join departments d 
on e.department_id=d.department_id 
join locations l 
on d.location_id=l.location_id 
where e.salary>10000;

/*Display the first name, last name, department name, and job title for employees who work in the 'IT' department.*/
select e.first_name,e.last_name,d.department_name,j.job_title 
from employees e 
join departments d 
on d.department_id=e.department_id 
join jobs j 
on e.job_id=j.job_id 
where d.department_name='IT';

/*Display the first name, last name, department name, and city for employees who work in the 'Sales' department.*/
select e.first_name,e.last_name,d.department_name,l.city 
from employees e 
join departments d 
on e.department_id=d.department_id 
join locations l 
on d.location_id=l.location_id 
where d.department_name='Sales';

/*Display the first name, last name, and job title for employees whose salary is greater than 10,000.*/
select e.first_name,e.last_name,j.job_title
from employees e 
join jobs j 
on e.job_id=j.job_id 
where e.salary>10000;

/*Display the first name, last name, department name, and 
salary for employees who work in the 'Sales' department and earn more than 8,000.*/
select e.first_name,e.last_name,d.department_name,e.salary
from employees e 
join departments d 
on e.department_id=d.department_id 
where d.department_name='Sales' and e.salary>8000;

/*Display the first name, last name, and department name for employees 
who were hired after January 1, 2005.*/
select e.first_name,e.last_name,d.department_name
from employees e 
join departments d 
on e.department_id=d.department_id 
where hire_date>'2005-01-01';

/*Display the first name, last name, and department name for employees who were hired before January 1, 2005.*/
select e.first_name,e.last_name,d.department_name
from employees e 
join departments d 
on e.department_id=d.department_id 
where hire_date<'2005-01-01';

/*Display the first name, last name, department name, and job title for 
employees who work in the 'IT' department and have the job title 'Programmer'.*/
select e.first_name,e.last_name,d.department_name,j.job_title 
from employees e 
join departments d 
on d.department_id=e.department_id 
join jobs j 
on e.job_id=j.job_id 
where d.department_name='IT' and j.job_title='Programmer';

/*Display the first name, last name, and salary for employees who work in the 
'Sales' department and have a salary between 5,000 and 10,000.*/
select e.first_name,e.last_name,e.salary
from employees e 
join departments d 
on e.department_id=d.department_id 
where d.department_name='Sales' and e.salary between 5000 and 10000;

/*Display the first name, last name, department name, and job title for employees
 who work in the 'Sales' department and have the job title 'Sales Representative'.*/
 select e.first_name,e.last_name,d.department_name,j.job_title 
from employees e 
join departments d 
on d.department_id=e.department_id 
join jobs j 
on e.job_id=j.job_id 
where d.department_name='Sales' and j.job_title='Sales Representative';

/*Display the first name, last name, department name, and city for employees
 who work in the 'IT' department and live in the 'Seattle' city.*/
select e.first_name,e.last_name,d.department_name,l.city 
from employees e 
join departments d 
on e.department_id=d.department_id 
join locations l 
on d.location_id=l.location_id 
where d.department_name='IT' and l.city='Seattle';

/*Display the first name, last name, department name, and salary for employees who 
work in the 'Sales' department and have a salary greater than 10,000*/
select e.first_name,e.last_name,d.department_name,e.salary
from employees e 
join departments d 
on e.department_id=d.department_id 
where d.department_name='Sales' and e.salary>10000;

/*Display the first name, last name, department name, and job title for employees
 who work in the 'IT' department and have a salary greater than 5,000.*/
select e.first_name,e.last_name,d.department_name,j.job_title 
from employees e 
join departments d 
on d.department_id=e.department_id 
join jobs j 
on e.job_id=j.job_id 
where d.department_name='IT' and e.salary>5000;

/*Display the first name, last name, department name, job title, and city for employees
 who work in the 'Sales' department and have a salary greater than 8,000.*/
 select e.first_name,e.last_name,d.department_name,j.job_title ,l.city
from employees e 
join departments d 
on d.department_id=e.department_id 
join jobs j 
on e.job_id=j.job_id 
join locations l
on d.location_id=l.location_id
where d.department_name='Sales' and e.salary>8000;