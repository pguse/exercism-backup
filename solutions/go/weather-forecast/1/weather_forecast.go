// Package weather forecasts the current weather
// condition of various cities in Goblinocus.
package weather

// CurrentCondition represents the current weather condition in a particular city.
var CurrentCondition string
// CurrentLocation represents the location of a particular city.
var CurrentLocation string

// Forecast takes two string arguments, city - representing the city
// and conition - representing the current weather condition.  It returns
// a string representing the forecast for the given city.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
