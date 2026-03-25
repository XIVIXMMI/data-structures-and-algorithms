package main

import "fmt"

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, num := range nums {
		complement := target - num
		if preIndex, exists := m[complement]; exists {
			return []int{preIndex, i}
		}
		m[num] = i
	}
	return nil
}

func main() {
	nums := []int{3, 2, 4}
	target := 6

	fmt.Println(twoSum(nums, target))

}
