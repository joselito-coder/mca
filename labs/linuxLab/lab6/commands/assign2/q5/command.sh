#!/bin/bash

# change current directory to roll_no
cd mca_18 || exit

# Write a command to list the files in directory M1, where the filename starts with a digit.

# assuming current directory is mca_18
# subshell to change to m1 directory and list 
(
    cd b1/m1 || exit

    ls [0-9]*

)
