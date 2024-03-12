class Graph {

    private val graph = hashMapOf<Int,MutableSet<Int>>()

    //Getting Total Nodes in Graph by getting total Keys in Map
    fun addEdge(src:Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also {
            it.add(dest)
        }
    }

    fun readGraph() {
        graph.forEach { (key, value) ->
            println("[$key] -> ${value.toTypedArray().contentToString()}")
        }
    }

    fun dfs(src: Int, visited: BooleanArray) {
        if (!visited[src]) {
            print("$src, ")
            graph[src]?.forEach {
                visited[src] = true
                dfs(it, visited)
            }
        }
    }

    //Same as Iteration
    fun bfs(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()

        queue.offer(src)
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            visited.add(front)
            graph[front]?.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("\nBFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {

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

        readGraph()
      
        print("DFS: ")
        dfs(0,BooleanArray(7))

        bfs(0)
    }
}


[0] -> [1, 2]
[1] -> [0, 3]
[2] -> [0, 4]
[3] -> [1, 4, 5]
[4] -> [2, 3, 5]
[5] -> [3, 4, 6]
[6] -> [5]
DFS: 0, 1, 3, 4, 2, 5, 6, 
BFS: [0, 1, 2, 3, 4, 5, 6]
