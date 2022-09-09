#!/bin/sh
#Glob chaaracters
# * - matches all
# ? - matches any single character
# [abd] - matches any character a,b,d
# [a-d] - matches any character from a,b,c,d


#create a directory test if not created
mkdir -p test
#change to that directory
cd test
#create some random files
touch file1 file2 file3 file4 file4 file5

#delete file from 2-4
rm file[2-4]


