use veevasystems;
CREATE TABLE transactions (
    trans_id INT PRIMARY KEY,
    merchant_id INT,
    creditcard_id INT,
    amount DECIMAL(10,2),
    transaction_timestamp DATETIME
);
INSERT INTO transactions
(trans_id, merchant_id, creditcard_id, amount, transaction_timestamp)
VALUES
(1, 101, 1001, 500.00, '2026-09-10 10:00:00'),
(2, 101, 1001, 500.00, '2026-09-10 10:05:00'),
(3, 101, 1001, 500.00, '2026-09-10 10:20:00'),
(4, 102, 1002, 750.00, '2026-09-10 11:00:00'),
(5, 102, 1002, 750.00, '2026-09-10 11:07:00'),
(6, 101, 1001, 300.00, '2026-09-10 11:30:00'),
(7, 103, 1003, 1000.00, '2026-09-10 12:00:00'),
(8, 103, 1003, 1000.00, '2026-09-10 12:09:00'),
(9, 103, 1004, 1000.00, '2026-09-10 12:05:00'),
(10, 101, 1001, 500.00, '2026-09-10 13:00:00');

CREATE TABLE search_frequency (
    searches INT,
    num_users INT
);

INSERT INTO search_frequency
(searches, num_users)
VALUES
(1, 2),
(2, 3),
(3, 5),
(4, 4),
(5, 2),
(6, 3),
(7, 1);

CREATE TABLE measurements (
    measurement_id INT PRIMARY KEY,
    measurement_value DECIMAL(10,2),
    measurement_time DATETIME
);

INSERT INTO measurements
(measurement_id, measurement_value, measurement_time)
VALUES
(1, 10.50, '2026-09-08 09:00:00'),
(2, 20.00, '2026-09-08 10:00:00'),
(3, 15.75, '2026-09-08 11:00:00'),
(4, 30.25, '2026-09-08 12:00:00'),
(5, 12.50, '2026-09-09 09:00:00'),
(6, 18.75, '2026-09-09 10:00:00'),
(7, 25.00, '2026-09-09 11:00:00'),
(8, 40.50, '2026-09-09 12:00:00'),
(9, 22.25, '2026-09-10 09:00:00'),
(10, 35.00, '2026-09-10 10:00:00');

/*i) Identify any payments made at the same merchant with the same credit card for the same amount within 10 min of each other count such repeated payments also*/

SELECT COUNT(*) AS repeated_payments
FROM transactions t1
JOIN transactions t2
    ON t1.merchant_id = t2.merchant_id
    AND t1.creditcard_id = t2.creditcard_id
    AND t1.amount = t2.amount
    AND t1.trans_id < t2.trans_id
    AND TIMESTAMPDIFF(
        MINUTE,
        t1.transaction_timestamp,
        t2.transaction_timestamp
    ) <= 10
    
    
/*8.you are given a summary table search-frequency
searches  num-users
write a query to report median of the searches made by user round the median to one decimal point*/

WITH cte AS (
    SELECT 
        searches,
        num_users,
        SUM(num_users) OVER (ORDER BY searches) AS cumulative_users,
        SUM(num_users) OVER () AS total_users
    FROM search_frequency
)
SELECT ROUND(AVG(searches), 1) AS median
FROM cte
WHERE cumulative_users >= (total_users + 1) / 2
  AND cumulative_users - num_users < (total_users + 2) / 2;
  
/*9.Consider following measurements table
measurement-id    measurement-value    measurement-time
now write a query to calculate sum of odd numbered measurements and even numbered measurements*/

SELECT
    SUM(CASE 
            WHEN measurement_id % 2 = 1 
            THEN measurement_value 
            ELSE 0 
        END) AS odd_sum,

    SUM(CASE 
            WHEN measurement_id % 2 = 0 
            THEN measurement_value 
            ELSE 0 
        END) AS even_sum
FROM measurements;


/*10.In the same problem find sum of measurement value date wise.*/

select date(measurement_time) as measurement_date,sum(measurement_value) as total
from measurements
group by measurement_date;