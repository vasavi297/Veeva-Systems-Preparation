/*1. Consider following orders table
id   order-date   order-amount
-------------------------------
int   date          int
1     2023-05-09    1250
2     2023-05-09    900
3     2023-05-10    1810

Now write SQL Query to find total amount of order per day the output should be as follows.
order-date    sum(order-amount)
-------------------------------
2023-05-09        2150
2023-05-10        1810
2023-05-11        750
Display the total orders per each month.
*/

select order_date,sum(order_amount)
from orders
group by order_date;

select month(order_date)as month,
year(order_date)as year,
count(*) as number_of_orders_per_month
from orders
group by year(order_date),month(order_date)
order by year,month;