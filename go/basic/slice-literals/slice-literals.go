package main

import (
	"fmt"
)

/**
* a slice literal is like an array without length
*
* In fact:
* - Go create an implicit array and point the slice to it
 */

func main() {
	q := []int{1, 3, 5, 7, 11, 13}
	fmt.Println(q)

	r := []bool{true, false, true, true, false, true}
	fmt.Println(r)

	s := []struct {
		i int
		b bool
	}{
		{1, true},
		{3, false},
		{5, true},
		{7, true},
		{11, true},
		{13, false},
	}
	fmt.Println(s)
}
