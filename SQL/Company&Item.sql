CREATE TABLE company_mast (
    COM_ID INT PRIMARY KEY,
    COM_NAME VARCHAR(50)
);
CREATE TABLE item_mast (
    PRO_ID INT PRIMARY KEY,
    PRO_NAME VARCHAR(50),
    PRO_PRICE DECIMAL(10,2),
    PRO_COM INT,
    FOREIGN KEY (PRO_COM) REFERENCES company_mast(COM_ID)
);

INSERT INTO company_mast
(COM_ID, COM_NAME)
VALUES
(11, 'Samsung'),
(12, 'iBall'),
(13, 'Epsion'),
(14, 'Zebronics'),
(15, 'Asus'),
(16, 'Frontech');

INSERT INTO item_mast
(PRO_ID, PRO_NAME, PRO_PRICE, PRO_COM)
VALUES
(101, 'Mother Board', 3200, 15),
(102, 'Key Board', 450, 16),
(103, 'ZIP drive', 250, 14),
(104, 'Speaker', 550, 16),
(105, 'Monitor', 5000, 11),
(106, 'DVD drive', 900, 12),
(107, 'CD drive', 800, 12),
(108, 'Printer', 2600, 13),
(109, 'Refill cartridge', 350, 13),
(110, 'Mouse', 250, 12);

/*Write a SQL query to find the average price of each manufacturer's products along with their name*/
select avg(i.pro_price) as avegrage_price,c.com_name
from item_mast i
join company_mast c
on c.COM_ID=i.PRO_COM
group by c.com_name;

/*Write a SQL query to display the average price of the products which is more than or equal to 350 along with their names.*/
select avg(i.pro_price)as avergae_price,c.com_name
from item_mast i
join company_mast c
on c.com_id=i.pro_com
where i.pro_price>=350
group by c.com_name;

/*Write a SQL query to display the name of each company and the price of their most expensive product.*/
select c.com_name,max( i.pro_price) as expensive_product
from item_mast i
join company_mast c 
on c.com_id=i.pro_com
group by c.com_name;



