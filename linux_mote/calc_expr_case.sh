#!/bin/bash

read -p "Enter num1 : " num1
read -p "Enter num2 : " num2
read -p "Operations (1) Add (2) Subtract (3) Multiply (4) Divide (5) Modulus Enter the choice :  " operator

case $operator in
	1) result=`echo $num1 + $num2 | bc`
	echo "Addition is : $result"
		;;
		
	2) result=`echo $num1 - $num2 | bc`
	echo "Subtraction is : $result"
		;;

	3) result=`echo $num1 \* $num2 | bc`
	echo "Addition is : $result"
		;;

	4) result=`echo "scale=2; $num1 / $num2" | bc`
	echo "Division is : $result"
		;;

	5) result=`echo $num1 % $num2 | bc`
	echo "Modulo is : $result"
		;;
esac	

