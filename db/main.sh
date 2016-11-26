 #!/bin/bash

 echo $'\n\nWelcome to the Hotel Database Management System, how can I help you?\n\n'
 echo '1: User'
 echo '2: Administrator'
 echo 'q: Quit'

 read input

 while [ "$input" != "q" ] && [ "$input" != "Q" ];
 do
     if [ "$input" = "1" ]; then
         echo 'You have chosen option 1'
         ./user.sh
     elif [ "$input" = "2" ]; then
         echo 'You have chosen option 2'
         ./admin.sh
     else
         echo 'Invalid Input'
     fi
     echo $'\n'
     echo '1: User'
     echo '2: Administrator'
     echo 'q: Quit'

     read input
 done
