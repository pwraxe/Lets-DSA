fun main() {
    val arr = intArrayOf(1,2,3)
    val total = arr.size * arr.size
    var index = 0
    val res = mutableListOf<String>()
    while (index < total) {
        val i = index / arr.size
        val j = index % arr.size
        res.add("(${arr[i]},${arr[j]})")
        index++
    }
    println(res.toTypedArray().contentToString())
}

O/P : [(1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3)]
