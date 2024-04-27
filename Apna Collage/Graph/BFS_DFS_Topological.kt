import java.util.ArrayDeque
import java.util.Stack

data class Edge(val src: Int, val dest: Int)

class Graph {
    private val graph = hashMapOf<Int,MutableList<Edge>>()
    fun addEdge(src: Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest)) }
    }
    fun readGraph() {
        for ((k,v) in graph) {
            print("$k --> ")
            v.forEach {
                print("${it.dest}, ")
            }
            println()
        }
    }
    fun dfs(start: Int) {
        val visited = mutableSetOf<Int>()
        val stack = Stack<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top]?.forEach {
                if (it.dest !in visited) stack.push(it.dest)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
    fun bfs(start: Int) {
        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Int>()
        queue.offer(start)
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            visited.add(front)
            graph[front]?.forEach {
                if (it.dest !in visited) queue.offer(it.dest)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun topologicalSort() {
        //get inDegree of all nodes
        val visited = mutableSetOf<Int>()
        val inDegree = hashMapOf<Int,Int>()
        graph.forEach { map ->
            map.value.forEach {
                inDegree[it.dest] = inDegree.getOrDefault(it.dest,0) + 1
            }
        }
        //enqueue nodes having inDegree zero
        val queue = ArrayDeque<Int>()
        inDegree[1] = 0
        inDegree.forEach {
            if (it.value == 0) queue.offer(it.key)
        }

        //Treating 1 as Source


        //loop
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            visited.add(front)
            graph[front]?.forEach {
                val degree = inDegree.getOrDefault(it.dest,0)
                inDegree[it.dest] = degree-1
                if (degree-1 == 0) queue.offer(it.dest)
            }
        }

        println("Topological Sort: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge(1,2)

        addEdge(2,3)
        addEdge(2,4)

        addEdge(3,5)

        addEdge(4,5)
        addEdge(4,6)

        addEdge(5,7)

        addEdge(6,3)
        addEdge(6,7)

        addEdge(7,8)

        readGraph()
        dfs(1)
        bfs(1)

        topologicalSort()
    }
}


//==================================================
1 --> 2, 
2 --> 3, 4, 
3 --> 5, 
4 --> 5, 6, 
5 --> 7, 
6 --> 3, 7, 
7 --> 8, 
DFS: [1, 2, 4, 6, 7, 8, 3, 5]
BFS: [1, 2, 3, 4, 5, 6, 7, 8]
Topological Sort: [1, 2, 4, 6, 3, 5, 7, 8]
