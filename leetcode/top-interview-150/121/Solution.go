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
	minPrice := prices[0]

	for _, price := range prices {
		if minPrice > price {
			minPrice = price
		}
		if price-minPrice > maxProfit {
			maxProfit = price - minPrice
		}
	}

	return maxProfit
}
