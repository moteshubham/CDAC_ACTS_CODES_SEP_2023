#!/bin/bash

read -p "Enter the number : " num

if [ $num -lt 0 ]
	then
		echo "Number is Negative"

elif [ $num -gt 0 ]
	then
		echo "Number is Positive"

else
	echo "Number is neither Negative nor Positive"
fi
