package main

import (
	"fmt"
	"example.com/greetings"
)

func main() {
	message := greetings.Hello("Bill")
	fmt.Println(message)
}
