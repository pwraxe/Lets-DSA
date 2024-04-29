//Little Diff. Not Much
//Just Discovery Time and Lowerst time calculated, on each DFS call
//once time to backtrack, then update lowerst time of current node, and check time[u] < time[v] this detects bridge, thats it,
//I can say Tarjans DFS is Modified Traversal

data class Edge(val src: Int, val dest: Int)
class Graph {
    private val graph = hashMapOf<Int,MutableList<Edge>>()
    fun addEdge(src: Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest)) }
    }

    //======================================================================================================

    //Discovery Time
    //Lowerst Time
    //Perform DFS on Node, at the time of backtrack, update lowerst time
    private fun tarjanDFS(currentNode: Int, parentNode: Int,currentTime: Int, discoveryTime: IntArray, lowestTime: IntArray, visited: BooleanArray) {
        visited[currentNode] = true
        discoveryTime[currentNode] = currentTime+1
        lowestTime[currentNode] = currentTime+1

        for (edge in graph[currentNode]!!) {
            if (edge.dest == parentNode) continue
            else if (!visited[edge.dest]) {
                tarjanDFS(edge.dest,currentNode,currentTime+1,discoveryTime, lowestTime, visited)

                //Update Lowest Time
                lowestTime[currentNode] = Math.min(lowestTime[currentNode], lowestTime[edge.dest])

                //Check for Bridge
                if (discoveryTime[currentNode] < lowestTime[edge.dest]) {
                    println("$currentNode --> ${edge.dest}")
                }
            } else {
                lowestTime[currentNode] = Math.min(lowestTime[currentNode], discoveryTime[edge.dest])
            }
        }
    }
    fun tarjansAlgorithm() {
        val discoveryTime = IntArray(graph.size+1)
        val lowestTime = IntArray(graph.size+1)
        val visited = BooleanArray(graph.size+1)
        var currentTime = 0

        graph.values.forEach {
            it.forEach {
                tarjanDFS(it.src,-1,currentTime, discoveryTime, lowestTime, visited)
            }
        }
    }
}

fun main() {
    Graph().apply {
        addEdge(1,2)

        addEdge(2,3)
        addEdge(2,5)

        addEdge(3,4)
        addEdge(3,5)

        addEdge(4,1)

        addEdge(5,6)

        addEdge(6,7)
        addEdge(7,8)
        addEdge(8,9)
        addEdge(9,6)

        tarjansAlgorithm()
    }
    println("===========================")
    Graph().apply {
        addEdge(0,1)
        addEdge(0,2)
        addEdge(0,3)

        addEdge(1,0)
        addEdge(1,2)

        addEdge(2,1)
        addEdge(2,0)

        addEdge(3,0)
        addEdge(3,4)
        addEdge(3,5)

        addEdge(4,3)
        addEdge(4,5)

        addEdge(5,3)
        addEdge(5,4)

        tarjansAlgorithm()
    }
}


5 --> 6
3 --> 5
===========================
0 --> 3
