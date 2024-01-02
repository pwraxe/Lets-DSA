//Intention: According to Greedy, I want max element from given pair
//Each steps get new pair, Greedy select max element from given current pair, and save to global optimal result (i.e. list)

fun main() {
    val pairs = listOf(
        Pair(2,4), Pair(4,5), Pair(1,7), Pair(6,7), Pair(2,3),
        Pair(3,4), Pair(7,8), Pair(5,6), Pair(1,2), Pair(-5,-1)
    )
    println(getMaxList(pairs).toTypedArray().contentToString())
}

fun getMaxList(pairs: List<Pair<Int,Int>>): IntArray {
    val list = IntArray(pairs.size)
    for (index in 0 until pairs.size) {
        val pair = pairs[index]
        println("Current Pair: ${pair}")
        list[index] = Math.max(pair.first, pair.second)
    }
    return list
}
