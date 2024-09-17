#!/bin/bash
# using command bc calculate the value of the following expression

# a)  (1456+234)/45
echo "(1456+234)/45" | bc

# b)  (1456+234)/45
x=10 
x=$(echo "$x+1" | bc)
echo $x 