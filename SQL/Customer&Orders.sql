/*Consider following customer table and orders table
Customer
cust-id	  name	city

Orders
ord-id	cust-id	  order-date	order-amount

i)Find the total no of orders placed by each customer excluding the orders placed in June
*/

desc orders1;
desc customer;
Select c.customer_id,count(*) as total_orders
from orders1 o
join customer c on
o.customer_id=c.customer_id
where month(o.order_date)!=6
group by c.customer_id;

/*ii)Find the customers who has placed the highest total order value*/

SELECT customer_id, name
FROM customer
WHERE customer_id IN (
    SELECT customer_id
    FROM orders
    GROUP BY customer_id
    HAVING SUM(order_amount) = (
        SELECT MAX(total_value)
        FROM (
            SELECT customer_id, SUM(order_amount) AS total_value
            FROM orders
            GROUP BY customer_id
        ) AS x
    )
);

/*iii)List all the orders placed on 2023-07-04 and 2027-07-06*/

select order_id from orders1
where order_date in (2023-07-04 , 2027-07-06);
 
select * from orders1;

/*iv)Find avg order value for each city*/

select c.city,avg(order_amount) 
from orders1 o
join customer c
on c.customer_id=o.customer_id
group by c.city; 

/*v)Identify customers who has not placed any orders*/

SELECT c.customer_id
FROM customer c
LEFT JOIN orders1 o
ON o.customer_id = c.customer_id
WHERE o.customer_id IS NULL;

/*vi)Find the month with highest total order value*/

select month(order_date) as month ,sum(order_amount)as max_amount
from orders1
group by month(order_date)
order by max_amount desc
limit 1;

/*vii)Write a query to display the top two customers with the most orders in the last 30 days*/

SELECT c.customer_id,
       c.name,
       COUNT(o.order_id) AS total_orders
FROM customer c
JOIN orders1 o
ON c.customer_id = o.customer_id
WHERE o.order_date >= CURRENT_DATE - INTERVAL 30 DAY
GROUP BY c.customer_id, c.name
ORDER BY total_orders DESC
LIMIT 2;

/*viii)List all the orders placed on 2023-07-04 and 2027-07-06 and their corresponding customer names*/

select o.order_id,c.name
from orders1 o
join customer c
on o.customer_id=c.customer_id
where o.order_date in ('2023-07-04','2027-07-06');




