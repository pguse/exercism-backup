import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64) {"Only integers between 1 and 64 (inclusive) are allowed"}
        return 2.toBigInteger().pow(number-1)
    }
    
    fun getTotalGrainCount(): BigInteger {
        return 2.toBigInteger().pow(64)-1.toBigInteger()
    }
}
