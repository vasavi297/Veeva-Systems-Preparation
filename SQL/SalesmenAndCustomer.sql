/*Consider following tables
Salesmen            Customer
Sid name city      Cid name city
now find number of sales men living in the same city as Davis 
find the sales people who are not leaving in the same city as "Camaro" "Green" "Johns".*/

Use VeevaSystems;
CREATE TABLE Salesmen (
    sid INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50)
);
INSERT INTO Salesmen (sid, name, city)
VALUES
(1, 'Davis', 'New York'),
(2, 'Camaro', 'Chicago'),
(3, 'Green', 'New York'),
(4, 'Johns', 'Boston'),
(5, 'Smith', 'Chicago'),
(6, 'Allen', 'Boston'),
(7, 'Brown', 'New York'),
(8, 'Wilson', 'Dallas');

CREATE TABLE Customers (
    cid INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50)
);
INSERT INTO Customers (cid, name, city)
VALUES
(201, 'Davis', 'New York'),
(202, 'Camaro', 'Chicago'),
(203, 'Green', 'New York'),
(204, 'Johns', 'Boston'),
(205, 'Martin', 'Dallas'),
(206, 'Taylor', 'Houston');

Select count(*) from salesmen
where city=(select city from salesmen where name='Davis');

Select count(*) from salesmen
where city NOT IN (select city from salesmen where name in('Camaro','Green','Johns'));

