package main

import (
	"fmt"
	"log"

	"example.com/greetings"
)

func main() {
	log.SetPrefix("greeting: ")
	log.SetFlags(0)

	// A slice of names
	names := []string{"Bill", "Kristine", "Darwin"}
	message, err := greetings.Hellos(names)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(message)
}
