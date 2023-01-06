USE satyam;

#Find highest worth actor and set his/her worth to 200 million
Update Actors SET NetWorthInMillions=200 ORDER BY NetWorthInMillions ASC LIMIT 1;

select * from Actors;

