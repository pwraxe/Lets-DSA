fun main() {
    val n = 119
    (0 .. 7).forEach {
        print("$n binary: ${n.toString(2)}  |  ")
        val mask = 1 shl it
        val bit = if (n and mask > 0) 1 else 0
        println("${it}th bit = $bit")
    }
}


119 binary: 1110111  |  0th bit = 1
119 binary: 1110111  |  1th bit = 1
119 binary: 1110111  |  2th bit = 1
119 binary: 1110111  |  3th bit = 0
119 binary: 1110111  |  4th bit = 1
119 binary: 1110111  |  5th bit = 1
119 binary: 1110111  |  6th bit = 1
119 binary: 1110111  |  7th bit = 0
