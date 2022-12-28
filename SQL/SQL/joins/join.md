# SQL server

Cross Joins
    Cartesian Product (Row of 2nd table with all the rows of 1st table)
        select * from Movie cross join cinema

Inner Joins:
    Instersection of two tables on a common property
        select * from Movie as m inner join cinema as c
        on m.ID = c.MovieID
    
    Common condition can be following also:
        on m.ID > c.MovieID
        on m.ID + c.MovieID = 5

    
Left Outer Join:
    Returns all records from the left table and matching records from the right table and NULL otherwise.  
        select * from Movie as m left join cinema as c
        on m.ID = c.MovieID

Right Outer Join:
    Returns all records from the right table and matching records from the left table and NULL otherwise.  
        select * from Movie as m right join cinema as c
        on m.ID = c.MovieID

Full Outer Join:
    Returns all matching records from both tables whether the other tables match and NULL otherwise.
        select * from Movie as m full outer join cinema as c
        on m.ID = c.MovieID

Self Join:
    A table is joined to itself
    select * from Movie as m , Movie as c 
    where m.ID = c.ID

    Common Condition can also be !=