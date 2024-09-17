#!/bin/bash

# Create a directory <YourRollNo>. Make <YourRollNo> as the current working directory. Create the directory structure as shown below with a single command.
# Refer doc for the diagram

# create rollNumDir and create the directory structure given in the diagram
mkdir -p mca_18 && cd mca_18 || exit
mkdir -p b1/m1 b1/m2 b1/m3
mkdir -p b2/m4 b2/m5
mkdir -p b3/m6