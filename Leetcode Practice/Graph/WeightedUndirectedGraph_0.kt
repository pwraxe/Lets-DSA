class Graph (n:Int) {

    private val graph = Array(n+1) { mutableSetOf<Int>() }

    fun addEdge(src: Int, dest: Int) {
        graph[src].add(dest)
    }

    fun readGraph() {

        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                println("[$index] -> ${set.toTypedArray().contentToString()}")
            }
        }
    }
}

fun main() {
    Graph(5).apply {
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
    }
}

//Output
[1] -> [2, 3]
[2] -> [1, 3, 4, 5]
[3] -> [1, 2, 4]
[4] -> [3, 2, 5]
[5] -> [2, 4]
