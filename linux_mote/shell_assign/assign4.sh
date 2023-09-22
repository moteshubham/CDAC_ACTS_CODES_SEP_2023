#!/bin/bash

count=1

for (( i=6; i>0; i-- ))
do
	for (( j=i-1; j>0; j-- ))
	do
		echo -n " "
	done	

	for (( k=1;k<=count; k++ ))
	do
		echo -n "$count "
	done
	
	for (( l=i-1; l>0; l-- ))
	do
		echo -n " "
	done
	echo " "
	count=$(( $count + 1 ))
done
