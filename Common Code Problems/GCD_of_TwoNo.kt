//Program: GCD of two no
fun main() {
    
    println(getGCD(81,153))
}

fun getGCD(num1: Int, num2: Int) : Int {
    
    var i = 1
    var gcd = i
    while(i < num1 && i < num2) {
        if(num1 % i ==0 && num2 % i == 0) {
            gcd = i
        }
        ++i
    }
    return gcd
}
