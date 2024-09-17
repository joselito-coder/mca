#!/bin/bash

# Write a command to list the files in your current working directory where the file name satisfies the given condition. 

# A) file name starts with a vowel
ls [aeiou]*

# B) The file name does not start with a vowel
ls [!aeiou]*

# C) Only five characters in the file name.
find . -maxdepth 1 -name "?????"

# D) Name which contains 5 characters, out of which, first and last should be either a or b.
find . -maxdepth 1 -name "[ab]???[ab]"

# E) File where name contains 3rd letter as a digit.
find . -maxdepth 1 -name "??[0-9]?*"

# F) The name with the first character should not be a, b or c.
ls [!abc]*

# G) Names containing "seq" in the filename.
ls ./*seq*

# H) The first three chracters are only digits
find . -maxdepth 1 -name "[0-9][0-9][0-9]?*"

# I) Name that starts and ends with “a”.
ls a*a

# J) Name with at least 2 characters in it.
find . -maxdepth 1 -name "??*"

# K) Name with exactly 2 characters in it.
find . -maxdepth 1 -name "??"

