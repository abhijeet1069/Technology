#!/bin/sh

GREET="Hello, World"
echo $PPID
echo $GREET

#export variable to new shell
export GREET="Hello, Satyam"
#new shell
bash
#didn't work in new shell
echo $PPID
echo $GREET