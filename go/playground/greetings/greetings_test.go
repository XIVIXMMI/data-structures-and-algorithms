package greetings

import (
	"regexp"
	"testing"
)

// Call greetings.Hello with a name
// checking for a valid value and return
func TestHelloName(t *testing.T) {
	name := "Bill"
	want := regexp.MustCompile(`\b` + name + `\b`)
	msg, err := Hello("Bill")
	if !want.MatchString(msg) || err != nil {
		t.Errorf(`Hello("Bill") = %q, %v, want match for %#q, nil`, msg, err, want)
	}
}

// Calls greetings.Hello with an empty String,
// Checking for an Error
func TestHelloEmpty(t *testing.T) {
	msg, err := Hello("")
	if msg != "" || err == nil {
		t.Errorf(`Hello("") = %q, %v, want "", error `, msg, err)
	}
}
