package main

import "fmt"

func main() {
	s := "anagram"
	t := "nagaram"
	fmt.Print(isAnagram(s, t))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// Frequency array for 26 lowercase Englist letters
	counter := make([]int, 26)

	/*
	* We asume that the input only contains the lowercase letters ('a' to 'z')
	*
	* Each character can be map to an index:
	* 'a' -> 0, 'b' -> 1, ... and so on
	* by subtracting the 'a' from the character.
	*
	* We increment for character in s
	* and decrement for character in t.
	* If s and t are anagram, all count return to 0.
	 */
	for i := 0; i < len(s); i++ {
		counter[s[i]-'a']++
		counter[t[i]-'a']--
	}

	for _, value := range counter {
		if value != 0 {
			return false
		}
	}
	return true
}
