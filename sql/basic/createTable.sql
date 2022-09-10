CREATE DATABASE IF NOT EXISTS satyam;

USE satyam;

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

DESC actors;


