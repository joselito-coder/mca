#!/bin/bash
# Save the list of user names in a file usr.txt
cat /etc/passwd | cut -d ":" -f 1 > usr.txt
