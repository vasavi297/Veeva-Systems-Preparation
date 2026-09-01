/*use veevasystems;
create table customer
(
    customer_id int primary key,
    name varchar(50) not null,
    city varchar(50) not null
);

create table orders1
(
    order_id int primary key,
    customer_id int not null,
    order_date date not null,
    order_amount decimal(10, 2) not null,
    foreign key (customer_id) references customer(customer_id)
);*/

/*INSERT INTO customer (customer_id, name, city) VALUES
(1, 'Ravi', 'Hyderabad'),
(2, 'Anu', 'Vijayawada'),
(3, 'Rahul', 'Chennai'),
(4, 'Priya', 'Bangalore'),
(5, 'Kiran', 'Hyderabad'),
(6, 'Sneha', 'Mumbai'),
(7, 'Arjun', 'Delhi'),
(8, 'Divya', 'Pune'),
(9, 'Sai', 'Hyderabad'),
(10, 'Meena', 'Chennai');*/

/*INSERT INTO orders1 (order_id, customer_id, order_date, order_amount) VALUES
(101, 1, '2023-05-09', 1250),
(102, 1, '2023-05-10', 900),
(103, 2, '2023-05-10', 1810),
(104, 3, '2023-05-11', 750),
(105, 2, '2023-05-15', 1200),
(106, 4, '2023-05-20', 2000),
(107, 5, '2023-06-02', 1500),
(108, 5, '2023-06-05', 850),
(109, 6, '2023-06-10', 2200),
(110, 7, '2023-06-15', 1750),
(111, 1, '2023-06-20', 950),
(112, 8, '2023-07-01', 3000),
(113, 9, '2023-07-05', 1250),
(114, 9, '2023-07-10', 1800),
(115, 10, '2023-07-15', 950),
(116, 4, '2023-07-20', 2100),
(117, 2, '2023-08-01', 1400),
(118, 6, '2023-08-05', 2500),
(119, 8, '2023-08-10', 1100),
(120, 3, '2023-08-15', 900);*/





