package main

import (
	"fmt"
	"log"

	"example.com/greetings"
)

func main() {
	log.SetPrefix("greeting: ")
	log.SetFlags(0)

	// Request a greeeting message
	message, err := greetings.Hello("Bill")
	// If an error was return, print it to console
	// and exit the program!
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(message)
}
