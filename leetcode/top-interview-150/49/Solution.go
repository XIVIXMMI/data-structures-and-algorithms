package main

import (
	"fmt"
	"slices"
	// "sort"
)

func main() {
	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	fmt.Print(groupAnagrams(strs))
}

// O(n * k log k)
func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string)
	result := [][]string{}

	for _, s := range strs {
		c := []rune(s)

		// sort.Slice(c, func(i, j int) bool {
		// 	return c[i] < c[j]
		// })

		slices.Sort(c)

		key := string(c)

		m[key] = append(m[key], s)

	}

	for _, v := range m {
		result = append(result, v)
	}

	return result
}
