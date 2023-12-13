//Find First Index
//Find Last Index
//Find All Index and return it

fun main() {
    val list = intArrayOf(1,2,6,4,5,6,6,7,8,9)

    println(findFirstIndex1(list,6))
    println(findFirstIndex2(list,4))

    println(findLastIndex1(list,5))
    println(findLastIndex2(list,3))

    println(findAllIndexFromStart(list,6,0, mutableListOf()).toTypedArray().contentToString())
    println(findAllIndexFromEnd(list,6,list.size-1, mutableListOf()).toTypedArray().contentToString())

}

fun findFirstIndex1(list: IntArray, target: Int): Int {
    for (index in 0 until list.size) {
        if (list[index] == target) return index
    }
    return -1
}

fun findFirstIndex2(list: IntArray, target: Int, index :Int = 0): Int {
    if (index == list.size) return -1
    if (list[index] == target) return index
    return findFirstIndex2(list, target, index+1)
}

fun findLastIndex1(list: IntArray, target: Int): Int {
    for (index in list.size-1 downTo 0) {
        if (list[index] == target) return index
    }
    return -1
}

fun findLastIndex2(list: IntArray, target: Int, index: Int = list.size-1): Int {
    if (index == -1) return -1
    if (list[index] == target) return index
    return findLastIndex2(list, target, index-1)
}

fun findAllIndexFromStart(list: IntArray, target: Int, index :Int ,result: MutableList<Int>): List<Int> {
    if(index == list.size) return result
    if (list[index] == target) {
        result.add(index)
    }
    return findAllIndexFromStart(list, target, index+1, result)
}

fun findAllIndexFromEnd(list: IntArray, target: Int, index: Int,result: MutableList<Int>): List<Int> {
    if (index == -1) return result
    if (list[index] == target) {
        result.add(index)
    }
    return findAllIndexFromEnd(list, target, index-1, result)
}
