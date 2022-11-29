/*
	For WHERE clause MySQL does a linear scan of the table to find the matching rows.    
    INDEX : An index primary purpose is to provide an ordered representaiton of indexed data.
		Clustered Index - Stored in B-tree
        Non-Clustered Index - Leaf nodes hold a pointer to data
	Index takes up additional disk space.
*/

#show index on actor table
SHOW INDEX FROM Actors;

#Create an index on Actor table
CREATE index actors_idx on Actors(FirstName);

#drop index
drop index actors_idx on Actors;

select * from actor_idx;
