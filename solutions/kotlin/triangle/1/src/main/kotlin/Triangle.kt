class Triangle(val a: Number, val b: Number, val c: Number) {

    val sideA = a.toDouble()
    val sideB = b.toDouble()
    val sideC = c.toDouble()

    init {
        require(sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {                 "Violates Triangle Inequality" 
        }
    }

    val isEquilateral: Boolean = (sideA == sideB) && (sideB == sideC)
    val isIsosceles: Boolean = (sideA == sideB) || (sideA == sideC) || (sideB == sideC)
    val isScalene: Boolean = (sideA != sideB) && (sideA != sideC) && (sideB != sideC)
}
