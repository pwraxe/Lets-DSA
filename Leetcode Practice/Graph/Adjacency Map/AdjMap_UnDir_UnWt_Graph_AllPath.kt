class Graph {

    private lateinit var allPaths: MutableList<List<Int>>

    private val graph = hashMapOf<Int,MutableSet<Int>>()

    fun addEdge(src:Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(dest) }
    }

    fun readGraph() {
        graph.forEach { (key, value) ->
            println("[$key] -> ${value.toTypedArray().contentToString()}")
        }
    }


    private fun getAllPaths(src: Int, dest:Int, visited:BooleanArray, currentPath: MutableList<Int>) {
        if (src == dest) {
            allPaths.add(currentPath.toList())
            return
        }

        graph[src]?.forEach {
            if (!visited[it]) {
                visited[src] = true
                currentPath.add(it)
                getAllPaths(it,dest,visited,currentPath)
                currentPath.remove(it)
                visited[src] = false
            }
        }
    }
    fun allPathsSourceTarget(): List<List<Int>> {
        allPaths = mutableListOf()
        getAllPaths(1, 5, BooleanArray(7), mutableListOf(1))
        return allPaths
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
        addEdge(3,5)

        addEdge(4,2)
        addEdge(4,3)
        addEdge(4,5)
        addEdge(4,6)

        addEdge(5,3)
        addEdge(5,2)
        addEdge(5,4)
        addEdge(5,6)

        addEdge(6,4)
        addEdge(6,5)

        readGraph()
        println("=======================================")
        allPathsSourceTarget().forEach {
            println(it.toTypedArray().contentToString())
        }
    }
}


[1] -> [2, 3]
[2] -> [1, 3, 4, 5]
[3] -> [1, 2, 4, 5]
[4] -> [2, 3, 5, 6]
[5] -> [3, 2, 4, 6]
[6] -> [4, 5]
=======================================
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 6, 5]
[1, 2, 3, 5]
[1, 2, 4, 3, 5]
[1, 2, 4, 5]
[1, 2, 4, 6, 5]
[1, 2, 5]
[1, 3, 2, 4, 5]
[1, 3, 2, 4, 6, 5]
[1, 3, 2, 5]
[1, 3, 4, 2, 5]
[1, 3, 4, 5]
[1, 3, 4, 6, 5]
[1, 3, 5]
