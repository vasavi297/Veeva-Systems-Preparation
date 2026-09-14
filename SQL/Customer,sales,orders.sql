use veevasystems;
CREATE TABLE salesman2 (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50),
    commission DECIMAL(4,2)
);

CREATE TABLE customer2(
    customer_id INT PRIMARY KEY,
    cust_name VARCHAR(50),
    city VARCHAR(50),
    grade INT,
    salesman_id INT,
    FOREIGN KEY (salesman_id) REFERENCES salesman2(salesman_id)
);

CREATE TABLE orders2 (
    ord_no INT PRIMARY KEY,
    purch_amt DECIMAL(10,2),
    ord_date DATE,
    customer_id INT,
    salesman_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer2(customer_id),
    FOREIGN KEY (salesman_id) REFERENCES salesman2(salesman_id)
);

INSERT INTO salesman2
(salesman_id, name, city, commission)
VALUES
(5001, 'James Hoog', 'New York', 0.15),
(5002, 'Nail Knite', 'Paris', 0.13),
(5005, 'Pit Alex', 'London', 0.11),
(5006, 'Mc Lyon', 'Paris', 0.14),
(5003, 'Lauson Hen', NULL, 0.12),
(5007, 'Paul Adam', 'Rome', 0.13);

INSERT INTO customer2
(customer_id, cust_name, city, grade, salesman_id)
VALUES
(3002, 'Nick Rimando', 'New York', 100, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002),
(3001, 'Brad Guzan', 'London', NULL, 5005),
(3004, 'Fabian Johns', 'Paris', 300, 5006),
(3007, 'Brad Davis', 'New York', 200, 5001),
(3009, 'Geoff Camero', 'Berlin', 100, 5003),
(3008, 'Julian Green', 'London', 300, 5002),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007);

INSERT INTO orders2
(ord_no, purch_amt, ord_date, customer_id, salesman_id)
VALUES
(70001, 150.50, '2012-10-05', 3005, 5002),
(70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001),
(70004, 110.50, '2012-08-17', 3009, 5003),
(70007, 948.50, '2012-09-10', 3005, 5002),
(70005, 2400.60, '2012-07-27', 3007, 5001),
(70008, 5760.00, '2012-09-10', 3002, 5001),
(70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.40, '2012-10-10', 3009, 5003),
(70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007),
(70013, 3045.60, '2012-04-25', 3002, 5001);

/*Write a query to display all the orders from the orders table issued by the salesman 'Paul Adam'.*/
select * from orders2 o
left join salesman2 s on
o.salesman_id=s.salesman_id
where s.name='Paul Adam';

/*Write a query to display all the orders for the salesman who belongs to the city London*/
select * from orders2 o 
join salesman2 s on
o.salesman_id=s.salesman_id
where s.city='London';

/*Write a query to find all the orders issued against the salesman who works for customer whose ID is 3007*/
select * from orders2 o 
join customer2 c on
c.salesman_id=o.salesman_id
where c.customer_id=3007;

/*Write a query to display all the orders whose values are greater than the average order value for 10th October 2012*/
select * from orders2 
where purch_amt>(select avg(purch_amt) from orders2 where ord_date='2012-10-10');

/*Write a query to find all orders attributed to a salesman in New York.*/
select * from orders2 o 
join salesman2 s on
s.salesman_id=o.salesman_id
where s.city='New York';

/*Write a query to display the commission of all salesmen servicing customers in Paris.*/
select commission from salesman2 s 
join customer2 c on
c.salesman_id=s.salesman_id
where c.city='Paris';

/*Write a query to display all the customers whose ID is below the salesman ID of Mc Lyon.*/
SELECT *
FROM customer2
WHERE customer_id < (
    SELECT salesman_id
    FROM salesman2
    WHERE name='Mc Lyon'
);

/*Write a query to count the customers with grades above New York's average.*/
select count(*) from customer2
where grade>
(select avg(grade) 
from customer2 
where city='New York');

/*Write a query to display all customers who have orders on October 5, 2012.*/
select * from customer2 c
join orders2 o on 
o.customer_id=c.customer_id
where ord_date='2012-10-5';

/*Write a query to display all customers with orders issued on 17th August 2012.*/
select * from customer2 c 
join orders2 o on 
o.customer_id=c.customer_id
where ord_date='2012-08-17';

/*Write a query to find the name and number of all salesmen who had more than one customer.*/
select s.name,count(*) 
from salesman2 s
join customer2 c on
s.salesman_id=c.salesman_id
group by s.salesman_id
having count(c.salesman_id)>1;

/*Write a query to find all orders with order amounts which are above-average amounts for their customers.*/
SELECT *
FROM orders2 o
WHERE o.purch_amt > (
    SELECT AVG(x.purch_amt)
    FROM orders2 x
    WHERE x.customer_id = o.customer_id
);

/*Write a query to find the sums of the amounts from the orders table, grouped by date, eliminating dates where
 the sum was not at least 1000.00 above the maximum order amount for that date.*/
 use veevasystems;
 select ord_date,sum(purch_amt) from orders2
 group by ord_date
 having sum(purch_amt)>=max(purch_amt)+1000;
 
 /*Write a query to extract the data from the customer table if and only if one or more customers are located in London.*/
 select * from customer2
 where exists(select * from customer2
 where city='London');
 
 /*Write a query to find the salesmen who have multiple customers.*/
 select s.salesman_id 
 from salesman2 s
 join customer2 c
 on s.salesman_id=c.salesman_id
 group by s.salesman_id
 having count(c.salesman_id)>=2;

/*Write a query to find all the salesmen who work for only one customer.*/
 select s.salesman_id 
 from salesman2 s
 join customer2 c
 on s.salesman_id=c.salesman_id
 group by s.salesman_id
 having count(c.customer_id)=1;
 
 /*Write a query to extract the rows of all salesmen who have customers with more than one order.*/
 select s.salesman_id from salesman2 s
 join customer2 c
 on s.salesman_id=c.salesman_id
 join orders2 o
 on c.customer_id=o.customer_id
 group by s.salesman_id
 having count(o.ord_no)>1;
 
 /*Write a query to find salesmen with all information who live in a city where any of the customers live.*/
SELECT *
FROM salesman2 s
WHERE s.city = ANY (
    SELECT c.city
    FROM customer2 c
);

/*Write a query to find all the salesmen for whom there are customers that follow them.*/
SELECT *
FROM salesman2 s
WHERE s.salesman_id = ANY (
    SELECT c.salesman_id
    FROM customer2 c
);

/*Write a query to display the salesmen whose names are alphabetically lower than the names of the customers.*/
select * from salesman2 s
where s.name<any(select cust_name from customer2);

/*Write a query to display the customers who have a greater grade than any customer who belongs to a city alphabetically lower than New York.*/
select * from customer2
where grade>any(select grade from customer2 
where city<'New York');

/*Write a query to display all orders that had amounts greater than at least one of the orders on September 10th 2012.*/
select * from orders2 
where purch_amt>any(select purch_amt from orders2
where ord_date='2012-09-10');

/*Write a query to find all orders with an amount smaller than any amount for a customer in London.*/
select * from orders2 o 
where o.purch_amt<any(select o1.purch_amt from orders2 o1
join customer2 c
on o1.customer_id=c.customer_id
where c.city='London');

/*Write a query to display all orders with an amount smaller than the maximum amount for a customer in London.*/
select * from orders2 o
where o.purch_amt<(select max(o1.purch_amt) from orders2 o1
join customer2 c
on o1.customer_id=c.customer_id
where c.city='London');

/*Write a query to display only those customers whose grades are higher than every customer in New York.*/
select * from customer2
where grade>all(select grade from customer2
where city='New York');

/*Write a query to find only those customers whose grades are higher than every customer in the city New York.*/
select * from customer2
where grade>all(select grade from customer2
where city='New York');

/*Write a query to get all information for those customers whose grade is not the same as the grade of a customer who belongs to the city London.*/
select * from customer2
where grade !=all(select grade from customer2
where city='London'and grade is not null);

/*Write a query to find all customers whose grade is not the same as the grade belonging to the city Paris.*/
select * from customer2
where grade not in(select grade from customer2
where city='Paris');

/*Write a query to find all those customers who hold a different grade than any customer of the city Dallas.*/
select * from customer2
where grade not in (select grade from customer2
where city='Dallas');