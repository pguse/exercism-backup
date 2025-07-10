object HandshakeCalculator {
    
    fun calculateHandshake(number: Int): List<Signal> {
        // number outside the allowed range -> no Handshake
        if (number < 1 || number > 31) return emptyList()
        // convert number to binary string and pad with zeros if necessary
        val binary = Integer.toBinaryString(number).padStart(5, '0')
        
        return mutableListOf<Signal>().apply {
           if (binary[4] == '1') add(Signal.WINK)
           if (binary[3] == '1') add(Signal.DOUBLE_BLINK)
           if (binary[2] == '1') add(Signal.CLOSE_YOUR_EYES)
           if (binary[1] == '1') add(Signal.JUMP)
           if (binary[0] == '1') reverse()
       }
    }
}
