//SimpleIntGraphMap_1.kt
//Target: Using Adjacency Hashmap, Create a Simple Graph, Read it
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
    }
}


{1=[2, 3], 2=[1, 3, 4, 5], 3=[1, 2, 4], 4=[3, 2, 5], 5=[2, 4]}
1 -> [2, 3]
2 -> [1, 3, 4, 5]
3 -> [1, 2, 4]
4 -> [3, 2, 5]
5 -> [2, 4]
