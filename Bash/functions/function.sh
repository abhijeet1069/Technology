#!/bin/sh

#shell has no functional arguments

# Output:
#   Hello World
#   
#   Hello
#   World

function myfunc {
    echo $1
    echo $2
}
myfunc "Hello World"
myfunc Hello World