//Leetcode Problem: Max consecutive 1's

fun main() {
    val list = intArrayOf(1,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,0,1,0)
    var max1s = 0
    var count = 0
    list.forEach {
        if(it == 1) count++ else count = 0
        max1s = Math.max(count, max1s)
    }
    println("Max 1is : $max1s")
}
