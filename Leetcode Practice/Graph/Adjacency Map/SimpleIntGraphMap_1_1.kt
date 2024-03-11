//SimpleIntGraphMap_1_1.kt
//Target: Using Adjacency Hashmap, Create a Simple Graph, Read it, BFS, DFS
//Int as a Key
class Graph {
    private val graph = hashMapOf<Int, MutableSet<Int>>()

    fun addEdge(src:Int, dest:Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(dest) }
    }

    fun readGraph() {
        println(graph)
        graph.forEach { (key, value) ->
            println("$key -> ${value.toTypedArray().contentToString()}")
        }
    }

    fun bfs(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.poll()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun dfs(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge(1,2)
        addEdge(1,3)

        addEdge(2,1)
        addEdge(2,3)
        addEdge(2,4)
        addEdge(2,5)

        addEdge(3,1)
        addEdge(3,2)
        addEdge(3,4)

        addEdge(4,3)
        addEdge(4,2)
        addEdge(4,5)

        addEdge(5,2)
        addEdge(5,4)

        readGraph()

        bfs(1)
        dfs(1)
    }
}
