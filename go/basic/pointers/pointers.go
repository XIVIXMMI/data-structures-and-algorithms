package main

import (
	"fmt"
)

// "Use pointers when you need mutation or performance benefits — not by default."
func main() {
	i, j := 42, 2701

	p := &i // point to i
	fmt.Println(*p)

	*p = 21 // set i through the pointer
	fmt.Println(i)

	p = &j       // point to j
	*p = *p / 37 // divide j through the pointer
	fmt.Println(j)
}

func example() {

	// pointer to a int value, it zero value is nil
	var p *int

	// The '&' operation generates a pointer to its operand
	i := 42
	p = &i

	// The * operator denotes the pointer's underlying value
	fmt.Println(*p)
	*p = 21

}
