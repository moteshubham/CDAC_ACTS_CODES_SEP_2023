#!/bin/bash

read -p "Enter the number : " num

rem=$(( $num % 2 ))

if [ $rem -eq 0 ]
	then
	echo "Number is even"
else 
	echo "Number is odd"
fi
