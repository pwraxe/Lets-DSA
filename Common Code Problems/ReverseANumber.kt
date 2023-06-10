//Program: Reverse a No
fun main() {
    val input = 875421
	val reverse = getReverse(input)
    println(reverse)
    println(reverseAlt1(input))
    println(reverseAlt2(input))
}

fun getReverse(input: Int): Int {
    var number = input
	var reverse = 0

    while(number != 0) {
        val digits = number % 10
        reverse = reverse * 10 + digits
        number /= 10
    }
    return reverse
}

fun reverseAlt1(input: Int) : Int {
    var number = StringBuilder(input.toString())
    var low = 0
    var high = number.length-1
    while(low < high) {
        number[low] = number[high].also { number[high] = number[low] }
        low++
        high--
    }
    
    return number.toString().toInt()
}

fun reverseAlt2(input: Int) : Int = StringBuilder(input.toString()).reverse().toString().toInt() 
