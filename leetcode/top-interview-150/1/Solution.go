package main

import "fmt"

func twoSum(nums []int, target int) []int {
	n := len(nums)

	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if target-nums[i] == nums[j] {
				arr := [2]int{i, j}
				return arr[:]
			}
		}

	}
	return nil

}

func main() {
	nums := []int{2, 5, 5, 11}
	target := 10

	fmt.Println(twoSum(nums, target))

}
