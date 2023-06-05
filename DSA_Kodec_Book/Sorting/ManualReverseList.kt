fun main() {
    val input = intArrayOf(8,2,5,4,1)
    println("${input.toTypedArray().contentToString()} equivalent reverse ${manualReverse(input).toTypedArray().contentToString()}")
}

//Time Complexity: O(n)
//Space Complexity: O(1)
fun manualReverse(list: IntArray) : IntArray {

    var left = 0
    var right = list.size-1
    while (left < right) {
        list[left] = list[right].also { list[right] = list[left] }
        left++
        right--
    }
    return list
}
