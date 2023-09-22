#!/bin/bash

read -p "Enter num1 : " num1
read -p "Enter num2 : " num2
read -p "Type the operator : " operator


if [ "$operator" = "+" ]
	then
		result=$(( $num1 + $num2 ))
		echo "Result is : $result"

elif [ "$operator" = "-" ]
	then
		result=$(( $num1 - $num2 ))
		echo "Result is : $result"

elif [ "$operator" = "*" ]
	then
		result=$(( $num1 * $num2 ))
		echo "Result is : $result"

elif [ "$operator" = "/" ]
	then
		result=$(( $num1 / $num2 ))
		echo "Result is : $result"
fi

