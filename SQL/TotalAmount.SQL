/*Create database VeevaSystems;
use VeevaSystems;
Create table orders
(
    id int primary key,
    order_date date not null,
    order_amount decimal(10, 2) not null
)*/
/*INSERT INTO orders (id, order_date, order_amount) VALUES
(1,  '2023-05-09', 1250),
(2,  '2023-05-09', 900),
(3,  '2023-05-10', 1810),
(4,  '2023-05-11', 750),

(5,  '2023-05-15', 1200),
(6,  '2023-05-15', 800),
(7,  '2023-05-20', 1500),
(8,  '2023-05-25', 950),

(9,  '2023-06-02', 1100),
(10, '2023-06-02', 900),
(11, '2023-06-10', 2000),
(12, '2023-06-15', 750),
(13, '2023-06-20', 1250),

(14, '2023-07-01', 3000),
(15, '2023-07-05', 1200),
(16, '2023-07-05', 800),
(17, '2023-07-10', 1750),
(18, '2023-07-20', 950);*/

/*select * from orders;*/
 select order_date,sum(order_amount)
 from orders
 group by order_date;