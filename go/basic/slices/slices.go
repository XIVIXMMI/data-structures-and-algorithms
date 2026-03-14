package main

import "fmt"

func main() {
	primes := [6]int{0, 1, 2, 3, 4, 5}

	var s []int = primes[1:4]
	fmt.Println(s) // expect [1 2 3]
}
