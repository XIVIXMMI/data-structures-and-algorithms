package main

import "fmt"

func main() {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
	fmt.Print(nums)
}

func moveZeroes(nums []int) {
	j := 0
	for i, n := range nums {
		if n != 0 {
			nums[j] = n
			if i > j {
				nums[i] = 0
			}
			j++
		}
	}
}
