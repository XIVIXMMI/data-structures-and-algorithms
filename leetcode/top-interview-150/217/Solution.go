package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4, 5, 6}
	fmt.Print(containsDuplicate(nums))
}

func containsDuplicate(nums []int) bool {
	set := make(map[int]struct{})
	for _, num := range nums {
		if _, exists := set[num]; exists {
			return true
		}
		set[num] = struct{}{}
	}
	return false
}
