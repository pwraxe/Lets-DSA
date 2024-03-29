import java.util.ArrayDeque
import java.util.Queue
import java.util.Stack
import kotlin.math.max

data class Edge(val src: Int, val dest:Int, val weight: Int = 0)
class Graph (val n:Int){

    private val graph = Array(n) { mutableListOf<Edge>() }
    fun addEdge(src: Int,dest: Int, weight: Int = 0) {
        graph[src] = graph[src].also { it.add(Edge(src, dest, weight)) }
    }

    private val visited = mutableSetOf<Int>()
    private val visitedByBFS = mutableSetOf<Int>()

    fun dfsRecursive(src:Int) {
        visited.add(src)
        graph[src].forEach {
            if (it.dest !in visited) dfsRecursive(it.dest)
        }
    }
    fun bfsRecursive(src: Int, queue: Queue<Int>) {
        if (visitedByBFS.size == n) return
        visitedByBFS.add(src)
        graph[src].forEach {
            if (it.dest !in visitedByBFS) {
                queue.offer(it.dest)
            }
        }
        bfsRecursive(queue.poll(),queue)
    }

    fun bfsIterative(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.offer(src)
        while (queue.isNotEmpty()){
            val front = queue.poll()
            visited.add(front)
            graph[front].forEach {
                if (it.dest !in visited) queue.offer(it.dest)
            }
        }

        println("BFS by Iteration: ${visited.toTypedArray().contentToString()}")
    }
    fun dfsIterative(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top].forEach {
                if (it.dest !in visited) stack.push(it.dest)
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
            if (!visited[it.dest]) {
                visited[it.dest] = true
                if (hashPath(it.dest,dest,visited)) return true
            }
        }
        return false
    }

    //This checks for all Vertices
    fun detectCycleOnUndirectedGraph() : Boolean {
        val visited = BooleanArray(graph.size)
        for (i in graph.indices) {
            if (!visited[i]) {
                if (detectCycleOnUndirectedGraphUtils(i,-1, visited)) return true
            }
        }
        return false
    }
    //This checks for all Edges of given source vertex
    private fun detectCycleOnUndirectedGraphUtils(src: Int, parent: Int, visited: BooleanArray): Boolean {
        visited[src] = true
        graph[src].forEach {
            if (!visited[it.dest]) {
                if (detectCycleOnUndirectedGraphUtils(it.dest,src,visited)) return true
            } else if(visited[it.dest] && it.dest != parent) {
                return true
            }
        }
        return false
    }

    fun canBipartite(src: Int): Boolean {
        val color = IntArray(graph.size) { -1 }
        val visited = BooleanArray(graph.size)
        val queue = ArrayDeque<Int>()
        queue.offer(src)
        color[src] = 0
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            visited[front] = true
            val currentColor = color[front]
            graph[front].forEach {

                if (color[it.dest] == -1) {
                    color[it.dest] = if (currentColor == 0) 1 else 0
                } else if(color[it.dest] == currentColor) {
                    return false
                }

                if (!visited[it.dest]) queue.offer(it.dest)
            }
        }
        return true
    }
}

fun main() {
    println("=========================Operation on UnDirected Graph")
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

        dfsIterative(0)
        dfsRecursive(0)

        bfsIterative(0)
        bfsRecursive(0, ArrayDeque())
        read()

        println("Has path from 0 to 5: ${hashPath(0,5, BooleanArray(7))}")
        println("Can make Partition: ${canBipartite(0)}")
    }

    println("=========================Operation on Directed Graph")
    Graph(7).apply {

        addEdge(0,1)

        addEdge(1,3)
        addEdge(1,2)

        addEdge(2,0)
        addEdge(2,4)

        addEdge(3,5)

        addEdge(4,3)

        addEdge(5,4)
        addEdge(5,6)

        println("Has path from 0 to 5: ${hashPath(0,5, BooleanArray(7))}")
        println("Has path from 4 to 1: ${hashPath(4,1, BooleanArray(7))}")
        println()

        println("is Graph has Cycle : ${detectCycleOnUndirectedGraph()}")
        println("Can make Partition: ${canBipartite(0)}")
    }
}

=========================Operation on UnDirected Graph
DFS by Iteration :[0, 2, 4, 5, 6, 3, 1]
BFS by Iteration: [0, 1, 2, 3, 4, 5, 6]
DFS: [0, 1, 3, 4, 2, 5, 6]
BFS: [0, 1, 2, 3, 4, 5, 6]
Has path from 0 to 5: true
Can make Partition: false
=========================Operation on Directed Graph
Has path from 0 to 5: true
Has path from 4 to 1: false

is Graph has Cycle : true
Can make Partition: false
