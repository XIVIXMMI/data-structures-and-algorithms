package main

import "fmt"

func main() {
	nums := []int{1, 1, 2}
	removeDuplicates(nums)
}

func removeDuplicates(nums []int) int {
	k := 0
	for _, num := range nums {
		if num != nums[k] {
			k++
			nums[k] = num
		}
	}

	fmt.Print(nums)

	fmt.Print(k + 1)

	return k + 1
}
