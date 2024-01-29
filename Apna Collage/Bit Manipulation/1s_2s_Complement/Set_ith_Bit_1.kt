fun main() {
    val n = 53
    (0..7).forEach {
        var num = n
        print("Before $num toBin: ${num.toString(2)}  |  ")
        val mask = 1 shl it
        num = num or mask
        println("After $num toBin: ${num.toString(2)}")
    }
}


Before 53 toBin: 110101  |  After 53 toBin: 110101
Before 53 toBin: 110101  |  After 55 toBin: 110111
Before 53 toBin: 110101  |  After 53 toBin: 110101
Before 53 toBin: 110101  |  After 61 toBin: 111101
Before 53 toBin: 110101  |  After 53 toBin: 110101
Before 53 toBin: 110101  |  After 53 toBin: 110101
Before 53 toBin: 110101  |  After 117 toBin: 1110101
Before 53 toBin: 110101  |  After 181 toBin: 10110101
