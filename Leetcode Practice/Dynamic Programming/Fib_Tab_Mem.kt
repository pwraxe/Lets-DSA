fun main() {
    val n = 10
    println(fibM(n, IntArray(n+1){ -1 }))
    println(fibT(n))
}

//==> DP/Memorization
fun fibM(n:Int, result: IntArray):Int {
    if(n <= 1) return n
    if(result[n] != -1) return result[n]
    val left = fibM(n-1, result)
    val right = fibM(n-2,result)
    result[n] = left + right
    return result[n]
}

//DP/Tabulation
fun fibT(n:Int) : Int {
    val result = IntArray(n+1) { -1 }
    result[0] = 0
    result[1] = 1

    for (index in 2 .. n) {
        result[index] = result[index-1] + result[index-2]
    }
    return result[result.lastIndex]
}
