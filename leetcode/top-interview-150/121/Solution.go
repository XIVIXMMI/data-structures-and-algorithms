package main

import (
	"fmt"
)

func main() {
	prices := [6]int{7, 1, 5, 3, 6, 4}
	fmt.Println(maxProfit(prices[:]))
}

func maxProfit(prices []int) int {
	maxProfit := 0
	minIndex := 0
	for i, price := range prices {
		if prices[minIndex] > price {
			minIndex = i
		}
		maxProfit = max(prices[i]-prices[minIndex], maxProfit)
	}

	return maxProfit
}
