//Intention: Greedy Choose Best at moment, 
fun main() {
    val list = listOf(5,2,7,4,9,1,8,3)
    println(list.sorted().last())
    println(getLargest(list))
    println("By DP: ${getLargestByDp(list)}")
}

fun getLargest(list: List<Int>): Int {
    var largest = 0
    list.forEach {
        largest = Math.max(largest, it)
    }
    return largest
}


fun getLargestByDp(list: List<Int>): Int {
    var largest = IntArray(list.size)
    var i = 1
    var j = 0
    largest[j] = list.first()

    while (i < list.size) {
        if (list[i] > largest[j]){
            largest[++j] = list[i]
        }
        i++
    }
    println(largest.toTypedArray().contentToString())
    return largest[j]
}
