#!/bin/bash

echo "Enter sales amount: "
read sales

echo "Enter cost amount: "
read cost

profit=$(( $sales - $cost ))

tax=$(( $profit * 10 / 100 ))

net_profit=$(( $profit -tax ))

echo "The net profit after taxes is: $net_profit"
