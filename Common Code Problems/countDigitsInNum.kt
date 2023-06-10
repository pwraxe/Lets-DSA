//Program: Count Digits in number
fun main() {
    
    val input = 8475124
    
    println("$input has ${countDigit_1(input)} Digits")
    println("$input has ${countDigit_2(input)} Digits")
}

fun countDigit_1(input: Int) : Int {
    var count = 0
    var num = input
    while(num != 0) {
        num /= 10
        ++count
    }
    return count
} 

fun countDigit_2(num:Int) = num.toString().length
