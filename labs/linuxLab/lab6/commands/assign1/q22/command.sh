#!/bin/bash
# Create an account “user1” with root privileges and user2, user3 with normal privileges.

sudo usermod -mG sudo user1
sudo usermod -m user2
sudo usermod -m user3
