//Program: GCD of two no
fun main() {
    
    println(getGCD(72,120))
}

fun getGCD(num1: Int, num2: Int) : Int {
   
    var lcm = if(num1 > num2) num1 else num2
    while(true) {
        if(lcm % num1 == 0 && lcm % num2 == 0) {
            break
        }
        ++lcm
    }
    return lcm
}
