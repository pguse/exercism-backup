class SpaceAge(val age: Int) {

    fun onEarth(): Double = convert(age, 1.0)
    fun onMercury(): Double = convert(age, 0.2408467)
    fun onVenus(): Double = convert(age, 0.61519726)
    fun onMars(): Double = convert(age, 1.8808158)
    fun onJupiter(): Double = convert(age, 11.862615)
    fun onSaturn(): Double = convert(age, 29.447498)
    fun onUranus(): Double = convert(age, 84.016846)
    fun onNeptune(): Double = convert(age, 164.79132)
    
    fun convert(age: Int, factor: Double): Double = "%.2f".format(age.toDouble() / (31557600 * factor)).toDouble()

}
