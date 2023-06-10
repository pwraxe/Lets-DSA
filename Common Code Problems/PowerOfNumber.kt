//Program: Power of Number
fun main() {
    println(pow(3,4))
}

fun pow(num: Int, powerValue: Int) : Int {
    var power = powerValue 
    var ans = 1
    while(power != 0) {
        ans *= num 
        power--
    }
    
    return ans
}
