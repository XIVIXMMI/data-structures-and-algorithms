package main

import "fmt"

func main() {
	// nums := []int{2, 2, 1, 1, 1, 2, 2}
	nums := []int{6, 5, 5}
	fmt.Print(majorityElement(nums))
	fmt.Print(boyerMooreVotingAlgorithm(nums))
}

func majorityElement(nums []int) int {
	freq := make(map[int]int)

	for _, num := range nums {
		freq[num]++
	}

	maxFreq := 0
	resutl := 0

	for key, value := range freq {
		if value > maxFreq {
			maxFreq = value
			resutl = key
		}
	}

	return resutl
}

func boyerMooreVotingAlgorithm(nums []int) int {
	candidate := 0
	count := 0
	for _, num := range nums {
		if count == 0 {
			candidate = num
			count++
		} else if num == candidate {
			count++
		} else {
			count--
		}
	}
	return candidate
}
