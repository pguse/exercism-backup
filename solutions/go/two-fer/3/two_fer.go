// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package twofer generates a Two-fer response - 'One for you and one for me.'
package twofer

// ShareWith returns a response of the form "One for X, one for me.",
// where X is a name if given or "you" if no name is provided
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return "One for " + name + ", one for me."
}
