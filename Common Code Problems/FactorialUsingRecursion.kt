//Problem: Factorial of given No using recursion

fun main() {
    val no = 8
    println("Fact of $no : ${fact(no)}")
}

fun fact(n:Int):Int {
    if(n == 1) return 1
    return n * fact(n-1)
}
