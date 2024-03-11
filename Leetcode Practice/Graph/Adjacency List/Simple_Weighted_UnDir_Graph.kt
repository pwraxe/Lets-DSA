//This graph uses Array to store its adj. values, 
//This is not recommended way, just learning and understanding the purpose you wrote this,
//Why is this not Recommended? --> Because we have to use vertex data as an index to get its adj list, 
//We don't know the data, it can go OutOfIndexBound to get adj List, and what if we get -ve value in vertex data,

//Edges have weight now

/*
Considered Constraints
 - Vertex data should be 0 to n (for init array)
 - Vertex data should not be negative, 
 - Vertex data should not below 0 or above n
*/



data class Edge(val src: Int, val dest: Int, val weight: Int)
class Graph (n: Int) {

    private val graph = Array(n+1) { mutableSetOf<Edge>() }

    fun addEdge(src: Int, dest: Int, weight:Int) {
        graph[src].add(Edge(src, dest, weight))
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
        addEdge(1,2,6)
        addEdge(1,3,8)

        addEdge(2,1,6)
        addEdge(2,3,10)
        addEdge(2,4,12)
        addEdge(2,5,15)

        addEdge(3,1,8)
        addEdge(3,2,10)
        addEdge(3,4,16)

        addEdge(4,3,16)
        addEdge(4,2,12)
        addEdge(4,5,20)

        addEdge(5,2,15)
        addEdge(5,4,20)

        readGraph()
    }
}
//Output
[1] -> [Edge(src=1, dest=2, weight=6), Edge(src=1, dest=3, weight=8)]
[2] -> [Edge(src=2, dest=1, weight=6), Edge(src=2, dest=3, weight=10), Edge(src=2, dest=4, weight=12), Edge(src=2, dest=5, weight=15)]
[3] -> [Edge(src=3, dest=1, weight=8), Edge(src=3, dest=2, weight=10), Edge(src=3, dest=4, weight=16)]
[4] -> [Edge(src=4, dest=3, weight=16), Edge(src=4, dest=2, weight=12), Edge(src=4, dest=5, weight=20)]
[5] -> [Edge(src=5, dest=2, weight=15), Edge(src=5, dest=4, weight=20)]
