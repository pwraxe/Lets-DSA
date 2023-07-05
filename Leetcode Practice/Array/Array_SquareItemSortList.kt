//Leetcode Problem: Square each item sort, return

fun main() {
    val list = arrayOf(-2,8,4,3,9,-5,-7,-1)

    for(index in list.indices) {
        val square = Math.abs(list[index]) * Math.abs(list[index])
        list[index] = square
    }
    list.sort()
    println(list.map{ it })
}
