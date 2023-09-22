#!/bin/bash

read -p "Enter the number : " num

while [ $(($num % 10)) -gt 0 ]
do
	rem=$(( $num % 10 ))
	sum=$(( $sum + $rem ))
	num=$(( $num / 10 ))
done

echo "$sum"

