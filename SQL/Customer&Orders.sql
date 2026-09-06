/*Consider following customer table and orders table
Customer
cust-id	  name	city

Orders
ord-id	cust-id	  order-date	order-amount

i)Find the total no of orders placed by each customer excluding the orders placed in June
ii)Find the customers who has placed the highest total order value
iii)List all the orders placed on 2023-07-04 and 2027-07-06
iv)Find avg order value for each city
v)Identify customers who has not placed any orders
vi)Find the month with highest total order value
vii)Write a query to display the top two customers with the most orders in the last 30 days
viii)List all the orders placed on 2023-07-04 and 2027-07-06 and their corresponding customer names
*/

desc orders1;
desc customer;
Select c.customer_id,count(*) as total_orders
from orders1 o
join customer c on
o.customer_id=c.customer_id
where month(o.order_date)!=6
group by c.customer_id;

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

select order_id from orders1
where order_date in (2023-07-04 , 2027-07-06);








