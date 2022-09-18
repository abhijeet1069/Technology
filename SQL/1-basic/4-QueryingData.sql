
##Using regex
SELECT * from Actors where FirstName REGEXP '[.a]';  

##LIKE operator works only with String datatypes

## LIMIT to only top 2 rows after 1st row
## We can use LIMIT in DELETE too
SELECT * from Actors order by NetWorthInMillions desc LIMIT 2 OFFSET 1;

#Order By using two keys. If there is a tie in first key, second key will come into effect
SELECT * FROM Actors ORDER BY NetWorthInMillions DESC, FirstName ASC, Gender DESC;

/*
Operators with WHERE clause:
	 > : Greater Than
     >= : Greater Than or equal to
     < : Less than
     <= : Less than or equal to
     != : Not equal
     <> : Not equal
     <=> : Null safe equal to operator
     = : equal to
     BETWEEN..AND.. : Whether a value is within a range of values
     COALASCE() : Return the first non-null argument
     GREATEST() : Return the largest argument
     IN : Whether a value is within set of values
     INTERVAL : Return the index of argument that is greater than the first argument
     IS : Test a value against a boolean
     IS NOT : Test a value against a boolean
     IS NOT NULL : NOT NULL value test
     IS NULL : NULL value test
     ISNULL() : NULL value test
     LEAST() : Return the smallest argument
     LIKE : Simple pattern matching
     NOT BETWEEN..AND.. : Whehther a value is not within a range of values
     NOT IN() : Whether a value is not within a set of values
     NOT LIKE : Negation of simple pattern matching
     STRCMP() : Compare two strings
     */