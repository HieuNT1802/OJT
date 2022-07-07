Create database JPL_TEST04
CREATE TABLE Employee (
emp_no INT PRIMARY KEY IDENTITY(1,1),
birth_date DATE Not Null,
first_name VARCHAR (50) Not Null CHECK(LEN(first_name)<=50),
last_name VARCHAR (50) Not Null CHECK(LEN(last_name)<=50),
gender CHARACTER(1) Not Null,
hire_date DATE Not Null
)
CREATE TABLE Department(
dept_no INT PRIMARY KEY IDENTITY(1,1),
dept_name VARCHAR (50) Not Null CHECK(LEN(dept_name)<=50) ,
[description] VARCHAR(100) Not Null,
)
CREATE TABLE Working_History(
dept_no INT FOREIGN KEY REFERENCES Department(dept_no),
emp_no  INT FOREIGN KEY REFERENCES Employee(emp_no),
from_date Date Not Null ,
to_date Date Not Null,
PRIMARY KEY (dept_no,emp_no)
)
SELECT * FROM Employee