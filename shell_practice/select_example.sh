#!/bin/bash

PS3="Whats the day of week : "

select day in mon tue wed thur fri sat sun
do
	echo "You selected $day"
	break
done
