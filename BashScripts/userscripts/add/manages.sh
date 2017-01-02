#!/bin/bash

    export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib

    username="thewa"
    password="07250503"
    
    echo 'Department Name: '
    read dep_name
    echo 'Product ID: '
    read prod_id
    echo 'Quantity Removed: '
    read quan_rem
    echo 'Date (use the following format: yy/mm/dd hh24:mi:ss): '
    read date

    fin=$"INSERT INTO manages VALUES ('$dep_name',$prod_id,$quan_rem,TO_DATE('$date','yy/mm/dd hh24:mi:ss'));"

    echo $fin | sqlplus64 "$username/$password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"
