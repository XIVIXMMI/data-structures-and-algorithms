package main

import "fmt"

/**
* Slice length and capacity
* A slice has both a length and a capacity.
*
* The length of a slice is the number of elements it contains.
*
* The capacity of a slice is the number of elements in the underlying array,
* counting from the first element in the slice.
*
* The length and capacity of a slice s can be obtained using the expressions len(s) and cap(s).
*
* You can extend a slice's length by re-slicing it,
* provided it has sufficient capacity.
 */

func main() {
	s := []int{2, 3, 5, 7, 9, 10}

	// Slice the slice to give it Zero length
	s = s[:0]
	printSlice(s)

	// Extend it's length
	s = s[:4]
	printSlice(s)

	// Drop first 2 elements
	s = s[2:]
	printSlice(s)

}

func printSlice(s []int) {
	fmt.Printf("len=%d, cap=%d, %v \n", len(s), cap(s), s)
}

/**
* len = number of elements the slice is currently "seeing"
* cap = number of elements from the current position to the end of the underlying array
*
* IMPORTANT:
* a slice does NOT point to the head of the original array,
* it points to the current starting position
*
* HOW TO CALCULATE CAP?
* cap = len(underlying array) - current start index
*
* IMPORTANT INSIGHT:
* drop head (s = s[n:])     -> len decreases, cap decreases
* truncate tail (s = s[:n]) -> len decreases, cap stays the same
 */
