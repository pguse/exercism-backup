/*Package raindrops generates raindrop sounds from a number

The rules of `raindrops` are that if a given number:

- has 3 as a factor, add 'Pling' to the result.
- has 5 as a factor, add 'Plang' to the result.
- has 7 as a factor, add 'Plong' to the result.
- _does not_ have any of 3, 5, or 7 as a factor, the result should be the digits of the number.

Examples:

- 28 has 7 as a factor, but not 3 or 5, so the result would be "Plong".
- 30 has both 3 and 5 as factors, but not 7, so the result would be "PlingPlang".
- 34 is not factored by 3, 5, or 7, so the result would be "34".
*/
package raindrops

import "strconv"

// Convert converts an integer to a set of raindrop sounds
func Convert(num int) string {
	sounds := ""

	if num%3 == 0 {
		sounds += "Pling"
	}
	if num%5 == 0 {
		sounds += "Plang"
	}
	if num%7 == 0 {
		sounds += "Plong"
	}
	if sounds == "" {
		sounds = strconv.Itoa(num)
	}

	return sounds

}
