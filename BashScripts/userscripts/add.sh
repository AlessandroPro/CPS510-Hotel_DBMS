
echo 'Please enter table name: '
read table_name
if [ "$table_name" = "manages" ]; then
    ./userscripts/add/manages.sh
elif [ "$table_name" = "supplies" ]; then
    ./userscriptsadd/supplies.sh
elif [ "$table_name" = "services" ]; then
    ./userscriptsadd/services.sh
elif [ "$table_name" = "books" ]; then
    ./userscripts/add/books.sh
elif [ "$table_name" = "part_time_employee" ]; then
    ./userscripts/add/part_time_employee.sh
elif [ "$table_name" = "full_time_employee" ]; then
    ./userscripts/add/full_time_employee.sh
elif [ "$table_name" = "promotion" ]; then
    ./userscripts/add/promotion.sh
elif [ "$table_name" = "recreation" ]; then
    ./userscripts/add/reaction.sh
elif [ "$table_name" = "dining" ]; then
    ./userscripts/add/dining.sh
elif [ "$table_name" = "inventory" ]; then
    ./userscripts/add/inventory.sh
elif [ "$table_name" = "amenity" ]; then
    ./userscripts/add/amenity.sh
elif [ "$table_name" = "guest" ]; then
    ./userscripts/add/guest.sh
elif [ "$table_name" = "room" ]; then
    ./userscripts/add/room.sh
elif [ "$table_name" = "department" ]; then
    ./userscripts/add/department.sh
else
   echo 'Invalid Input'
fi
