#!/bin/bash

count=1

for (( i=6; i>0; i-- ))
do	

	for (( k=1;k<=count; k++ ))
	do
		echo -n "$count"
	done
	
	
	echo " "
	count=$(( $count + 1 ))
done
