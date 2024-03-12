//Adjacency Map, UnDirected UnWeighted Graph
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

    fun dfs(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top]?.forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }

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
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }

    fun getSinglePathFromSrcToDest(src: Int, dest: Int) {
        val stack = Stack<Int>()
        val visited = BooleanArray(graph.keys.size)
        var path = ""

        stack.push(src)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            path += "$top -> "
            visited[top] = true
            if (top == dest) {
                println("\nStack: ${stack.toTypedArray().contentToString()}")
                println("Visited: ${visited.toTypedArray().contentToString()}")
                println("Path: ${path.removeSuffix(" -> ")}")
                return
            }

            graph[top]?.forEach {
                if (!visited[it]) stack.push(it)
            }
        }
    }

    private val allPaths = mutableListOf<String>()
    fun getAllPathsFromSrcToDest(src: Int, dest: Int, path:String, visited:BooleanArray) {
        //You have solved this using recursion
    }

    fun readAllPaths() {
        allPaths.forEach {
            println(it)
        }
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

        dfs(0)
        bfs(0)

        getSinglePathFromSrcToDest(0,5)
        println("\nAll Paths are")
        getAllPathsFromSrcToDest(0,5,"0", BooleanArray(7))
        readAllPaths()
    }
}


DFS: [0, 2, 4, 5, 6, 3, 1]
BFS: [0, 1, 2, 3, 4, 5, 6]

Stack: [1, 3]
Visited: [true, false, true, false, true, true, false]
Path: 0 -> 2 -> 4 -> 5

All Paths are
 //You have solved this using recursion
