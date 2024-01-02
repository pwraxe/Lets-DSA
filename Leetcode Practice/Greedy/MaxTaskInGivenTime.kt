fun main() {
    val tasks = intArrayOf(5,4,2,1,3).sorted()
    println(solve(tasks, 6).toTypedArray().contentToString())
}

fun solve(tasks: List<Int>, time:Int): IntArray {

    var totalTasks = 0
    var index = 0
    val result = mutableListOf<Int>()

    while (totalTasks <= time) {
        if (totalTasks + tasks[index] <= time) {
            totalTasks += tasks[index]
            result.add(tasks[index])
            index++
        } else break
    }

    return result.toIntArray()
}
