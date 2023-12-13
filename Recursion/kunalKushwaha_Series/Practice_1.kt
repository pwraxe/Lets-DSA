//Is list sorted?
fun main() {
    val list = intArrayOf(1,2,3,4,5,6,7,8,9)
    println(isListSorted1(list))
    println(isListSorted2(list))
    println(isListSorted3(list))
}

fun isListSorted1(list: IntArray): Boolean {

    for (index in 1..<list.size) {
        val prev = list[index-1]
        val curr = list[index]
        if (prev > curr) return false
    }
    return true
}

fun isListSorted2(list: IntArray, index :Int = 0): Boolean {
    if (index == list.size-1) return true
    if (list[index] > list[index+1]) return false
    return isListSorted2(list, index+1)
}

fun isListSorted3(list: IntArray, index :Int = 0): Boolean {
    if (index == list.size-1) return true
    return list[index] < list[index + 1] && isListSorted2(list, index+1)
}
