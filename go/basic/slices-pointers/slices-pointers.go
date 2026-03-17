package main

import "fmt"

/**
* Slices are like references to arrays
*
* A slice does not store any data, it just describes a section of an underlying array.
*
* Changing the elements of a slice modifies the corresponding elements of its underlying array.
*
* Other slices that share the same underlying array will see those changes.
*
 */
func main() {
	names := [5]string{
		"Johnny",
		"Giovana",
		"Bill",
		"Harvey",
		"Jocelyn",
	}
	fmt.Println(names)

	a := names[0:2] // ['Johnny' 'Giovana']
	b := names[1:4] // ['Giovana' 'Bill' 'Harvey']
	fmt.Println(a, b)

	b[1] = "Joseph" // -> change 'Bill' to 'Joseph'
	fmt.Println(a, b)
	fmt.Println(names)
}
