SQL is a relational database and can be divided into:
	1. Application/Client Layer - Repsonbile for client connections, authorization, authentication and security.
	2. MySQL server layer - Repsonsible for parsing, analyzing and optimising submitted query
	3. Storage Engine layer - Writes/Retrieves data from physical storage medium

The SQL commands are mainly categorized into:
	1. DDL(Data Definition Language) : SQL commands that can be used to define database schema.
		CREATE - Creates database, table, index. function, procedure etc.
		DROP - Delete objects from database
		ALTER - Alter the structure from database
		TRUNCATE - Removes all records from table, including all spaces allocated for records
		COMMENT - Used to add comments to the data dictionary
		RENAME - Rename an object existing in the database
		
	2. DQL(Data Query Language) - Get a schema relation based on query
		SELECT - Read data from DB

	3. DML(Data Manipulation Language) : Manipulation of data
		INSERT - Insert new data in a table
		UPDATE - Updates existing data within a table
		DELETE - Delete records from a database table
		LOCK - Table control concurrency
		CALL - Call a routine
		EXPLAIN PLAN - Describe the access path to data
		
	4. DCL(Data Control Language) : Rights, permission or other control
		GRANT
		REVOKE
		
	5. TCL(Transaction Control Language)
		COMMIT - Commits a transation
		ROLLBACK - Rollbacks a transaction in case of any error.
		SAVEPOINT - Sets a savepoint within a transaction
		SET TRANSACTION - Specify characteristics of a transaction 

# Show all database in system
	SHOW DATABASES; (MySQL)

# mysql is database name
	USE mysql; (MySQL)

# shows all tables of a given database
	SHOW TABLES; (MySQL)
	select * from INFORMATION_SCHEMA.TABLES; (SQL Server)

# shows detail of user table
	DESCRIBE user;
	exec sp_columns Actors


# Datatypes
	Numeric - INT, BIGINT, TINYINT, DECIMAL
	String - VARCHAR, CHAR, ENUM, SET, BLOB
	Date and Time - DATE, TIME, TIMESTAMP, YEAR
	JSON
	Spatial Data - Represents location, size and shape. GEOMETRY, POINT

