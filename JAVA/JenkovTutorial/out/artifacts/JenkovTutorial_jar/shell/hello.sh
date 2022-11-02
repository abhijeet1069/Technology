#!/bin/sh
#File name of final build jar
JAR_FILE="JenkovTutorial.jar" 

#time in which file was last modified
CURRENT_TIME="$(date)"
BUILD_TIME="$(date -r $JAR_FILE)"

echo "\nCurrent Time: $CURRENT_TIME\nBuild File: $JAR_FILE \nLast Build: $BUILD_TIME\n"

time java -jar $JAR_FILE