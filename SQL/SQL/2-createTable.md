# MySQL
CREATE DATABASE IF NOT EXISTS satyam;

# MySQL
USE satyam;

# MySQL
CREATE TABLE IF NOT EXISTS Actors(
	ID INT AUTO_INCREMENT,
	FirstName VARCHAR(20) NOT NULL,
    SecondName VARCHAR(20) NOT NULL,
    DOB DATE NOT NULL,
    Gender ENUM('Male','Female','Other') NOT NULL,
    MaritalStatus ENUM('Married','Divorced','Single','Unknown') DEFAULT 'Unknown',
    NetWorthInMillions DECIMAL NOT NULL,
    PRIMARY KEY(ID)
);

# SQL server
CREATE TABLE Cinema(
	MovieID INT PRIMARY KEY,
	CinemaName VARCHAR(30) NOT NULL,
	RunForDays INT
);

# Rename table
    exec sp_rename 'schema.old_table_name', 'new_table_name'
