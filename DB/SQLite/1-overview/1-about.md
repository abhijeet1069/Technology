SQLite does not compete with client/server databases. It competes with fopen().

If you insert a non-numeric string like 'wxyz' into an INTEGER column, unlike other SQL databases, SQLite does not throw an error. 
Instead, SQLite stores the actual string value in the column.

As an accommodation for those who expect rigid typing, SQLite version 3.37.0 (2021-11-27) introduced the option of STRICT tables. 
These either impose the mandatory datatype constraints found in other SQL database engines.

SQLite does not have a separate BOOLEAN data type. Instead, TRUE and FALSE are (normally) represented as integers 1 and 0

SQLite has no DATETIME datatype. Instead, dates and times can be stored in any of these ways:
    As a TEXT string in the ISO-8601 format. Example: '2018-04-02 12:13:46'.
    As an INTEGER number of seconds since 1970 (also known as "unix time").
    As a REAL value that is the fractional Julian day number.

In SQLite datatype is optional.

Applications can activate foreign key enforcement at run-time using the PRAGMA foreign_keys statement. Or, foreign key enforcement can 
be activated at compile-time using the -DSQLITE_DEFAULT_FOREIGN_KEYS=1 compile-time option.

A PRIMARY KEY in an SQLite table is really the same as a UNIQUE constraint. Due to an historical oversight, 
the column values of such a PRIMARY KEY are allowed to be NULL. 

The SQL standard requires double-quotes around identifiers(variable name) and single-quotes around string literals(variable value). For example:
"this is a legal SQL column name"
'this is an SQL string literal'

 Keywords Can Often Be Used As Identifiers. For example, the following statement is valid in SQLite:
    CREATE TABLE union(true INT, with BOOLEAN);

NUL Characters Are Allowed In Text Strings

SQLite Distinguishes Between Integer And Text Literals
    SQLite says that the following query returns false:
        SELECT 1='1';