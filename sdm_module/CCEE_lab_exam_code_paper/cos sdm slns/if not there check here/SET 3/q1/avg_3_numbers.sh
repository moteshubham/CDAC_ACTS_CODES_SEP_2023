#!/bin/bash

echo "Enter first number: "
read num1

echo "Enter second number: "
read num2

echo "Enter third number: "
read num3

avg=$(( ($num1 + $num2 + $num3) / 3 ))

echo "The average of the three numbers is: $avg"
