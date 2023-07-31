class Queue<T> {
    private val elements = mutableListOf<T>()
    val size: Int
        get() = elements.size

    fun enQ(item: T) { elements.add(item)}
    fun deQ():T? = if(size > 0) elements.removeAt(0) else null
    fun isEmpty() = size == 0
}

fun Int.next() = if(this == 9) 0 else this+1
fun Int.prev() = if(this == 0) 9 else this-1

class Solution {

    data class LockCode(val first: Int, val second:Int, val third: Int, val forth: Int) {
        override fun toString() = "$first$second$third$forth"
        fun generateNextLevel() : List<LockCode> = listOf(
                copy(first = first.next()),
                copy(second = second.next()),
                copy(third = third.next()),
                copy(forth = forth.next()),

                copy(first = first.prev()),
                copy(second = second.prev()),
                copy(third = third.prev()),
                copy(forth = forth.prev())
            )
    }

    fun openLock(deadends: Array<String>, target: String): Int {
        val queue = Queue<LockCode>()
        val visited = mutableSetOf<LockCode>()
        val deadEnds = deadends.toList()
        var steps = 0

        queue.enQ(LockCode(0,0,0,0))
        while(!queue.isEmpty()) {
            repeat(queue.size) {
                val newCode = queue.deQ()

                if(newCode.toString() == target) return steps
                
                if(newCode.toString() !in deadEnds) {

                    val next = newCode?.generateNextLevel()
                    
                    next?.forEach {code ->
                        if(code.toString() == target) return steps+1
                        if (code.toString() !in deadEnds && code !in visited){
                            visited.add(code)
                            queue.enQ(code)
                        }
                    }
                }
            }
            steps++
        }
        return -1
    }
}
