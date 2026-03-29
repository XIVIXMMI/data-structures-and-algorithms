package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4, 5, 6, 7}
	k := 3

	// rotate(nums, k)
	// fmt.Println(nums)

	rotateTrick(nums, k)
	fmt.Println(nums)
}

func rotate(nums []int, k int) {
	k = k % len(nums) // Ensure k is within the bound of slice lengh
	result := append(nums[len(nums)-k:], nums[:len(nums)-k]...)
	copy(nums, result)
}

func rotateTrick(nums []int, k int) {
	k = k % len(nums)
	reverse(nums, 0, len(nums)-1) // expect reverse all the array
	reverse(nums, 0, k-1)
	reverse(nums, k, len(nums)-1)
}

func reverse(nums []int, left int, right int) {
	if left < 0 || right >= len(nums) {
		return
	}
	for left < right {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right--
	}
}
