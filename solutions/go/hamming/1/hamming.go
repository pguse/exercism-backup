// Package hamming calculates the Hamming distance between two DNA strands
package hamming

import "errors"

// Distance calculates the Hamming distance between two strings
func Distance(a, b string) (int, error) {
	count := 0

	if len(a) != len(b) {
		return count, errors.New("DNA strands are not equal length")
	}

	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			count++
		}
	}

	return count, nil

}
