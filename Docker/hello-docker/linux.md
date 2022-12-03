In linux everything is a file.

# Redirection
Normally cat reads data from file and shows in standard output. However, redirection puts the data in a file.
To redirect input, we can use < redirection
    cat file.txt > file.txt

# show list of programs installed (fetches from local DB)
    apt list

# install applications from apt DB
    apt install <application-name>

# uninstall applications from apt DB
    apt remove <application-name>

# rename folder
    mv test docker

# remove directory 
    rm -r docker/

# show large pages in interactive mode
    less <filename>

# show first 5 lines of a file
    head -n 5 /etc/adduser.conf

# show last 5 lines of a file
    tail -n 5 /etc/adduser.conf