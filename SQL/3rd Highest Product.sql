/*Consider a product table in database now consider following schema of a product table
Product code Product name price quantity
now find name of the product that has 3rd highest value of price*quantity among all the products*/

Use VeevaSystems;
CREATE TABLE Products (
    product_code INT PRIMARY KEY,
    product_name VARCHAR(50),
    price DECIMAL(10,2),
    quantity INT
);
INSERT INTO Products (product_code, product_name, price, quantity)
VALUES
(101, 'Laptop', 50000, 5),
(102, 'Mobile', 25000, 10),
(103, 'Keyboard', 1500, 20),
(104, 'Monitor', 12000, 8),
(105, 'Mouse', 800, 30),
(106, 'Printer', 15000, 6),
(107, 'Headphones', 3000, 15),
(108, 'Tablet', 20000, 7);

select product_name from
(
Select product_name,price*quantity as highest,
dense_rank() over(order by price*quantity desc) as rnk
from products
)as t
where rnk=3;
