//Linear Find Element
fun main() {
    val list = intArrayOf(1,2,3,4,5,6,7,8,9)
    println(findTarget1(list, 8))
    println(findTarget2(list, 8))
    println(findTarget2(list, 8))
}

fun findTarget1(list: IntArray, target: Int): Boolean {
    for (index in 0 until list.size) {
        if (list[index] == target) {
            return true
        }
    }
    return false
}

//Using Binary Search | Recursive Way
fun findTarget2(list: IntArray, target: Int, start: Int = 0, end: Int = list.size-1): Boolean {
    if (start > end) return false

    val mid = start + (end - start) / 2
    if (list[mid] == target) return true

    return if(target < list[mid]) {
        findTarget2(list, target, start, mid-1)
    } else {
        findTarget2(list, target, mid+1, end)
    }
}

fun findTarget3(list: IntArray, target: Int,index: Int): Boolean {
    if (index == list.size) return false
    return list[index] == target || findTarget3(list, target, index+1)
}
