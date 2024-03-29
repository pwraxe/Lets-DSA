fun IntArray.radixSort(): IntArray {
    var result = this
    val max = getMax()

    var place = 1
    while (max / place > 0) {
        result = result.countingSort(place)
        place *= 10
    }

    return result
}

fun IntArray.countingSort(place: Int): IntArray {
    val result = IntArray(size)
    val count = IntArray(10)

    for (i in 0 until result.size) {
        val digit = (this[i] / place) % 10
        count[digit] += 1
    }

    for (i in 1 until count.size) {
        count[i] += count[i - 1]
    }

    for (i in size - 1 downTo 0) {
        val digit = (this[i] / place) % 10
        result[count[digit] - 1] = this[i]
        count[digit]--
    }

    return result
}

fun IntArray.getMax(): Int {
    var mx = this[0]
    for (i in 1..size - 1)
        if (this[i] > mx)
            mx = this[i]
    return mx
}

fun main(args : Array<String>){
    val mArray = intArrayOf(99, 44, 283, 0, 5, 16, 76, 2, 145)
    println(mArray.radixSort().contentToString())
}
