#!/bin/bash

# Define the range of numbers you want to check (e.g., 1 to 20)
start=1
end=10

echo "Even numbers between $start and $end:"

# Loop through the range of numbers
for ((number=start; number<=end; number++))
do
    # Check if the number is even (divisible by 2)
    if [ $((number % 2)) -eq 0 ]
    then
        echo "$number"
    fi
done