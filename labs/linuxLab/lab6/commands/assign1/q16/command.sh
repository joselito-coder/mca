#!/bin/bash
# Create a file MyCommand.txt containing the last 8 executed commands on your terminal.
history | tail -8 > MyCommand.txt