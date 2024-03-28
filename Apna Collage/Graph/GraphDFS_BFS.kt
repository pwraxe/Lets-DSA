import java.util.ArrayDeque
import java.util.Queue
import java.util.Stack
import kotlin.math.max

/**
 *
 * * * * * * * * * * * * * * * * * * * * * * * *
 *                                             *
 *                  END OF IDE                 *
 *                                             *
 * * * * * * * * * * * * * * * * * * * * * * * *
 * **/

data class Edge(val src: Int, val dest:Int)
class Graph (val n:Int){

    private val graph = Array(n) { mutableListOf<Int>() }
    fun addEdge(src: Int,dest: Int) {
        graph[src] = graph[src].also { it.add(dest) }
    }

    private val visited = mutableSetOf<Int>()
    private val visitedByBFS = mutableSetOf<Int>()

    fun dfs(src:Int) {
        visited.add(src)
        graph[src].forEach {
            if (it !in visited) dfs(it)
        }
    }
    fun bfs(src: Int, queue: Queue<Int>) {
        if (visitedByBFS.size == n) return
        visitedByBFS.add(src)
        graph[src].forEach {
            if (it !in visitedByBFS) {
                queue.offer(it)
            }
        }
        bfs(queue.poll(),queue)
    }

    fun bfsIter(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.offer(src)
        while (queue.isNotEmpty()){
            val front = queue.poll()
            visited.add(front)
            graph[front].forEach {
                if (it !in visited) queue.offer(it)
            }
        }

        println("BFS by Iteration: ${visited.toTypedArray().contentToString()}")
    }
    fun dfsIter(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top].forEach {
                if (it !in visited) stack.push(it)
            }
        }
        println("DFS by Iteration :${visited.toTypedArray().contentToString()}")
    }

    fun read() {
        if (visited.isNotEmpty()) {
            println("DFS: ${visited.toTypedArray().contentToString()}")
        }

        if (visitedByBFS.isNotEmpty()) {
            println("BFS: ${visitedByBFS.toTypedArray().contentToString()}")
        }
    }

    fun hashPath(src:Int,dest: Int, visited:BooleanArray): Boolean {
        if (src == dest) return true

        graph[src].forEach {
            if (!visited[it]) {
                visited[it] = true
                if (hashPath(it,dest,visited)) return true
            }
        }
        return false
    }
}

fun main() {
    Graph(7).apply {
        addEdge(0,1)
        addEdge(0,2)

        addEdge(1,0)
        addEdge(1,3)

        addEdge(2,0)
        addEdge(2,4)

        addEdge(3,1)
        addEdge(3,4)
        addEdge(3,5)

        addEdge(4,2)
        addEdge(4,3)
        addEdge(4,5)

        addEdge(5,3)
        addEdge(5,4)
        addEdge(5,6)

        addEdge(6,5)

        dfs(0)
        bfs(0,ArrayDeque<Int>())
        read()
        val src = 0
        val dest = 5
        println("Has Path from $src to $dest : ${hashPath(src, dest, BooleanArray(7))}")
        bfsIter(0)
        dfsIter(0)
    }
}
