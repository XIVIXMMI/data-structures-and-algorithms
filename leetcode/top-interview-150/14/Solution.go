package main

import (
	"fmt"
	// "strings"
)

func main() {
	strs := []string{"flower", "flow", "flight"}
	// strs := []string{"dog", "racecar", "car"}
	// fmt.Print(longestCommonPrefix(strs))
	fmt.Print(longestCommonPrefix_reducePrefix(strs))
}

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	for i := 0; i < len(strs[0]); i++ {
		char := strs[0][i] // The character of index i of the first string element

		// Compare current character with the same index in every string of strs
		for _, s := range strs {
			// if i exceeds the length of current string -> the current string is shorter than current string -> then return
			// if character is not match then return
			if i >= len(s) || s[i] != char {
				return strs[0][:i]
			}
		}
	}
	// If no match was found, the entire first element string is the common prefix
	return strs[0]
}

func longestCommonPrefix_reducePrefix(strs []string) string {
	prefix := strs[0]

	for i := 1; i < len(strs); i++ {
		s := strs[i]
		// if s not start with prefix then prefix - 1 last character
		// for !strings.HasPrefix(s, prefix) {
		// 	prefix = prefix[:len(prefix)-1]
		// }
		for len(s) < len(prefix) || s[:len(prefix)] != prefix {
			prefix = prefix[:len(prefix)-1]
		}
	}
	return prefix
}
