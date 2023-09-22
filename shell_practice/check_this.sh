#!/bin/bash
echo " enter pkn"

read n1
read n2

result=$(echo "scale=5; $n1 / $n2" | bc)

echo " result is $result"
