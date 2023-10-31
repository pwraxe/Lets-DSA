fun main() {
    //Tabulation: Bottom-Up Case
    val fib = IntArray(10)

    //Starts from Base case
    fib[0] = 0
    fib[1] = 1

    //Implemented by Iteration
    for (index in 2 until fib.size) {
        fib[index] = fib[index-1] + fib[index-2]
    }

    println(fib.toTypedArray().contentToString())
}
