package main

import "fmt"

func merge(nums1 []int, m int, nums2 []int, n int) {
	k := m + n - 1 // last index of nums1 array
	i := m - 1
	j := n - 1

	for j >= 0 {
		if i >= 0 && nums1[i] >= nums2[j] {
			nums1[k] = nums1[i]
			i--
		} else {
			nums1[k] = nums2[j]
			j--
		}
		k--
	}

	for _, num := range nums1 {
		fmt.Println(num)
	}
}

func main() {
	nums1 := []int{2, 0}
	nums2 := []int{1}
	m := 1
	n := 1
	merge(nums1, m, nums2, n)
}
