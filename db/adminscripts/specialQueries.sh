 #!/bin/bash

    export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
    
    username="thewa"
    password="07250503"
    	
	echo '1. Select rooms that are not in Wing #2'
	echo '2. Select rooms that are on the same floor as amenities'
	echo '3. List of employees that in FoodServices but are Cooks'
	echo '4. Average salary for full-time employees'
	echo '5. Capacity of all the restaurants'
    
    read input

	if [ "$input" = "1" ]; then
         sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"  < ./adminscripts/specialQuery1
     elif [ "$input" = "2" ]; then
         sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"  < ./adminscripts/specialQuery2
     elif [ "$input" = "3" ]; then
         sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"  < ./adminscripts/specialQuery3
     elif [ "$input" = "4" ]; then
         sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"  < ./adminscripts/specialQuery4
     elif [ "$input" = "5" ]; then
	     sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"  < ./adminscripts/specialQuery5
     else
         echo 'Invalid Input'
     fi
