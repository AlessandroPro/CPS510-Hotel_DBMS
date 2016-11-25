#!/bin/bash

echo $'\n'
echo '1: Create Tables'
echo '2: Populate Tables'
echo '3: Drop Tables'
echo '4: Special Queries'
echo 'q: Quit'

read input

while [ "$input" != "q" ] && [ "$input" != "Q" ]; 
do
    if [ "$input" = "1" ]; then
        echo 'You have chosen option 1'
        ./adminscripts/createTables.sh
    elif [ "$input" = "2" ]; then
        echo 'You have chosen option 2'
        ./adminscripts/populateTables.sh
    elif [ "$input" = "3" ]; then
        echo 'You have chosen option 3'
        ./adminscripts/dropTables.sh
    elif [ "$input" = "4" ]; then
        echo 'You have chosen option 4'
        ./adminscripts/specialQueries.sh
    else
        echo 'Invalid Input'
    fi
    
    echo $'\n'
    echo '1: Create Tables'
    echo '2: Populate Tables'
    echo '3: Drop Tables'
    echo '4: Special Queries'
    echo 'q: Quit'

    read input
done
