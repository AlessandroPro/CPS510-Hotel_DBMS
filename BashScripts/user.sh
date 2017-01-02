 #!/bin/bash

 echo $'\n\n'
 echo '1: Add'
 echo '2: Update'
 echo '3: Delete'
 echo '4: Query'
 echo 'q: Quit'

 read input

 while [ "$input" != "q" ] && [ "$input" != "Q" ];
 do
     if [ "$input" = "1" ]; then
         echo 'You have chosen option 1'
         ./userscripts/add.sh
     elif [ "$input" = "2" ]; then
         echo 'You have chosen option 2'
         ./userscripts/update.sh
     elif [ "$input" = "3" ]; then
         echo 'You have chosen option 3'
         ./userscripts/delete.sh
     elif [ "$input" = "4" ]; then
         echo 'You have chosen option 4'
         ./userscripts/query.sh
     else
         echo 'Invalid Input'
     fi

     echo $'\n1: Add'
     echo '2: Update'
     echo '3: Delete'
     echo '4: Query'
     echo 'q: Quit'

     read input
 done
