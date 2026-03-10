package main

import "fmt"

type Vertex struct {
	X int
	Y int
}

func main() {
	v := Vertex{2, 1}
	p := &v
	p.X = 1e9 // change value of v.X to 1e9
	fmt.Println(v)
}

/**
* Struct fields can be accessed through a struct pointer
* To access the fields X of a struct when we have the struct pointer p
* we could write (*p).X
* However, that notation is cumbersome,
* So the language permits us instead to write just p.X
* without the explicit dereference.
 */
