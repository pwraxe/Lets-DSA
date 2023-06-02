//Problem: Swap No. without third variable
fun main() {
	var a = 10
    var b = 20
    
    swapByMethod1(a,b)
    println("\n\n")
    swapByMethod2(a,b)
}

fun swapByMethod1(a: Int, b: Int) {
    var num1 = a
    var num2 = b
    
    println("Before Swap : a = $num1, b = $num2")
    num1 = num1 + num2
    num2 = num1 - num2
    num1 = num1 - num2
    
    print("After Swap : a = $num1, b = $num2")
}

fun swapByMethod2(a: Int, b: Int) {
    var num1 = a
    var num2 = b
    println("Before Swap : a = $num1, b = $num2")
    num1 = num2.also{ num2 = num1 }
    print("After Swap : a = $num1, b = $num2")
}

 

