# SQL Server
	insert into Movie values(1,'Star Wars');

# MySQL
use satyam;

##Interesting way of inserting data
INSERT INTO Actors SET
	DOB="1950-12-12", FirstName="Rajnikanth", SecondName="Thalaiva", Gender="Male", 
	NetWorthInMillions=50, MaritalStatus="Married";

INSERT INTO Actors(
FirstName, SecondName, DOB, Gender, MaritalStatus,NetWorthInMillions) VALUES
("Brad","Pitt","1963-12-18","Male","Single","240");

INSERT INTO Actors(
FirstName, SecondName, DOB, Gender, MaritalStatus,NetWorthInMillions) VALUES
("Jennifer","Aniston","1969-11-02","Female","Single",240.0),
("Angelina","Jolie","1975-06-04","Female","Single",100.0),
("Johnny","Depp","1963-06-09","Male","Single",200.00);

INSERT INTO Actors VALUES
(DEFAULT,"Jennifer","Lopez","1999-01-03","Female","Single",00.00);

##Inserted but with truncated values for last column
INSERT INTO Actors VALUES(NULL,"Gordon","Ramsey","1981-01-01","Male","Single",23.44);

INSERT INTO Actors() VALUE();

SELECT * from Actors;

describe actors;