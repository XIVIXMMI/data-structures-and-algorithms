package main

import "fmt"

/**
* When slicing, you may omit the high or low bounds to use their defaults instead.
* The default is zero for the low bound and the length of the slice for the high bound.
 */
func main() {
	var a = [10]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}

	fmt.Println(a[0:10])

	fmt.Println(a[:10])

	fmt.Println(a[0:])

	fmt.Println(a[:])

	// EXPECT: the same result.
}
