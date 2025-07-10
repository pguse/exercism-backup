class SpaceAge(val age: Int) {

    fun onEarth(): Double = "%.2f".format(age.toDouble() / 31557600).toDouble()
    fun onMercury(): Double  = "%.2f".format(age.toDouble() / (31557600*0.2408467)).toDouble()
    fun onVenus(): Double = "%.2f".format(age.toDouble() / (31557600*0.61519726)).toDouble()
    fun onMars(): Double = "%.2f".format(age.toDouble() / (31557600*1.8808158)).toDouble()
    fun onJupiter(): Double = "%.2f".format(age.toDouble() / (31557600*11.862615)).toDouble()
    fun onSaturn(): Double = "%.2f".format(age.toDouble() / (31557600*29.447498)).toDouble()
    fun onUranus(): Double = "%.2f".format(age.toDouble() / (31557600*84.016846)).toDouble()
    fun onNeptune(): Double = "%.2f".format(age.toDouble() / (31557600*164.79132)).toDouble()
}
