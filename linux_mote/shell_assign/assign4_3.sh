#!/bin/bash

count=1

for (( i=1; i<6; i++ ))
do

	for (( k=1;k<=i; k++ ))
	do
		echo -n "$k"
	done
	
	echo " "
	count=$(( $count + 1 ))
done
