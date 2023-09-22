#!/bin/bash

count=1

for (( i=5; i>0; i-- ))
do

	for (( k=1;k<=count; k++ ))
	do
		echo -n "|"
		
        	if [ $i -lt 5 ]     
                then
        		echo -n " "
		fi
	done
            	
  
	echo "_"
	echo " "
	count=$(( $count + 1 ))
done
