/*
Write a query to count the number of people above 35 years living in 
"Bangalore" or "Mumbai".

Sample output
-------------
total_people
1                                                                                


Table:   
======
indianPeople
    - name VARCHAR(100),
    - age INT,
    - gender VARCHAR(10),
    - phone_number VARCHAR(15),
    - location VARCHAR(50),
    - salary DECIMAL(10, 2)

*/

use fs;
-- write your query below

select COUNT(name) as total_people from indianPeople where age>35 and location in ('Bangalore','Mumbai');

