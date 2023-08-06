//Sum of 10 nums //ref. from factorial 
fun main() {
	val sum = sumTo(1)
    println("Sum of 10: $sum")
}

fun sumTo(n: Int) : Int {
    if(n == 10) return n
    return n + sumTo(n+1)
}
