/*8) Store List of students based on branch in a university for every branch store list of students so that students can be accessed based on branch name for every student maintain following details roll no name branch section marks CGPA then we store data roll no name branch sections marks CGPA as input grade should be computed now
1. display list of students branch wise
2. display list if students branch wise descending order of grade
3. list of students branch wise sorted in ascending order of marks
4. given a branch find number of students in that branch and names of students with s grade
5. find dept where we have highest number of s grades
same problem implement in DBMS in SQL Queries.*/

USE VeevaSystems;
CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50),
    branch VARCHAR(30),
    section CHAR(1),
    marks INT,
    cgpa DECIMAL(3,2),
    grade CHAR(1)
);
INSERT INTO students
(roll_no, name, branch, section, marks, cgpa, grade)
VALUES
(101, 'Arjun', 'CSE', 'A', 95, 9.80, 'S'),
(102, 'Bhavya', 'CSE', 'A', 88, 9.10, 'A'),
(103, 'Charan', 'CSE', 'B', 76, 8.20, 'B'),
(104, 'Divya', 'CSE', 'B', 92, 9.50, 'S'),
(105, 'Esha', 'CSE', 'A', 68, 7.40, 'C'),
(106, 'Farhan', 'CSE', 'B', 85, 8.90, 'A'),

(201, 'Gowtham', 'AIML', 'A', 98, 9.90, 'S'),
(202, 'Harini', 'AIML', 'A', 91, 9.60, 'S'),
(203, 'Ishaan', 'AIML', 'B', 82, 8.60, 'A'),
(204, 'Jahnavi', 'AIML', 'B', 74, 8.00, 'B'),
(205, 'Kiran', 'AIML', 'A', 89, 9.20, 'A'),
(206, 'Lavanya', 'AIML', 'B', 96, 9.80, 'S'),

(301, 'Manoj', 'ECE', 'A', 93, 9.50, 'S'),
(302, 'Nandini', 'ECE', 'A', 87, 9.00, 'A'),
(303, 'Omkar', 'ECE', 'B', 79, 8.40, 'B'),
(304, 'Pranavi', 'ECE', 'B', 95, 9.70, 'S'),
(305, 'Rahul', 'ECE', 'A', 71, 7.80, 'B'),
(306, 'Sanjana', 'ECE', 'B', 84, 8.80, 'A'),

(401, 'Teja', 'EEE', 'A', 90, 9.40, 'S'),
(402, 'Uday', 'EEE', 'A', 86, 8.90, 'A'),
(403, 'Vaishnavi', 'EEE', 'B', 94, 9.60, 'S'),
(404, 'Varun', 'EEE', 'B', 73, 7.90, 'B'),
(405, 'Yamini', 'EEE', 'A', 81, 8.50, 'A'),
(406, 'Zoya', 'EEE', 'B', 67, 7.20, 'C'),

(501, 'Aditya', 'IT', 'A', 97, 9.90, 'S'),
(502, 'Ananya', 'IT', 'A', 89, 9.20, 'A'),
(503, 'Bharat', 'IT', 'B', 92, 9.50, 'S'),
(504, 'Chaitanya', 'IT', 'B', 78, 8.30, 'B'),
(505, 'Deepika', 'IT', 'A', 85, 8.90, 'A'),
(506, 'Karthik', 'IT', 'B', 94, 9.70, 'S');

Select * from students
order by branch;

Select * from students 
order by branch,grade desc;

Select * from students
order by branch,marks asc;

SELECT COUNT(*) AS total_students
FROM students
WHERE branch = 'CSE';

SELECT name
FROM students
WHERE branch = 'CSE'
AND grade = 'S';

SELECT branch, COUNT(*) AS sgrade
FROM students
WHERE grade = 'S'
GROUP BY branch
HAVING COUNT(*) = (
    SELECT MAX(sgrade)
    FROM (
        SELECT COUNT(*) AS sgrade
        FROM students
        WHERE grade = 'S'
        GROUP BY branch
    ) AS temp
);