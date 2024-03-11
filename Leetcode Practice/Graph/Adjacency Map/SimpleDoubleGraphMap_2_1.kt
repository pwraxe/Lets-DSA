//Target: Using Adjacency Hashmap, Create a Simple Graph, Read it, BFS, DFS
//Double as a Key, (DoubleGraph)

class DoubleGraph {
    private val graph = hashMapOf<Double, MutableSet<Double>>()

    fun addEdge(src:Double, dest:Double) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(dest) }
    }

    fun readGraph() {
        println(graph)
        graph.forEach { (key, value) ->
            println("$key -> ${value.toTypedArray().contentToString()}")
        }
    }

    fun bfs(src: Double) {
        val queue = ArrayDeque<Double>()
        val visited = mutableSetOf<Double>()
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
    fun dfs(src: Double) {
        val stack = Stack<Double>()
        val visited = mutableSetOf<Double>()
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
    DoubleGraph().apply {
        addEdge(1.1,6.15)
        addEdge(1.1,31.145)

        addEdge(6.15,1.1)
        addEdge(6.15,31.145)
        addEdge(6.15,0.001)
        addEdge(6.15,123.456)

        addEdge(31.145,1.1)
        addEdge(31.145,6.15)
        addEdge(31.145,0.001)

        addEdge(0.001,31.145)
        addEdge(0.001,6.15)
        addEdge(0.001,123.456)

        addEdge(123.456,6.15)
        addEdge(123.456,0.001)

        readGraph()

        bfs(1.1)
        dfs(1.1)
    }
}




{0.001=[31.145, 6.15, 123.456], 6.15=[1.1, 31.145, 0.001, 123.456], 31.145=[1.1, 6.15, 0.001], 123.456=[6.15, 0.001], 1.1=[6.15, 31.145]}
0.001 -> [31.145, 6.15, 123.456]
6.15 -> [1.1, 31.145, 0.001, 123.456]
31.145 -> [1.1, 6.15, 0.001]
123.456 -> [6.15, 0.001]
1.1 -> [6.15, 31.145]
BFS: [1.1, 6.15, 31.145, 0.001, 123.456]
DFS: [1.1, 31.145, 0.001, 123.456, 6.15]
