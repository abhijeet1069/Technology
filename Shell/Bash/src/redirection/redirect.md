# File manipulation commands
cat - concatenate files
sort - sort lines of text
uniq - report or omit repeated lines
grep - print lines matching a pattern
wc - print newline,word,and byte count for each file
head - output first part of file
tee - read from standard input and write to standard output and files

# Redirect
Connects a command with file
> creates new file
>> concatenate in file

# Pipelines
Connects the output of one command with the input of second command
For ex:
    pagify long content of ls/var
        ls /var | less 
        
    list /usr/bin contents, sort it and pagify
        ls /bin /usr/bin | sort | less

    save all files of /usr/bin in ls.txt and find files containing zip
        ls /usr/bin | tee ls.txt | grep zip
    
    