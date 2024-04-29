// Articulation Point is point / Vertex, if we delte that vertex from graph then 2 or more component create, 
// such vertex or point call articulation point
data class Edge(val src: Int, val dest: Int)
class Graph {
    private val graph = hashMapOf<Int,MutableList<Edge>>()
    fun addEdge(src: Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest)) }
    }

    //======================================================================================================

    private fun dfs(src: Int, parent: Int, currentTime: Int, lowestTime: IntArray, discoveryTime: IntArray, visited:BooleanArray, ap: BooleanArray) {
        visited[src] = true
        lowestTime[src] = currentTime+1
        discoveryTime[src] = currentTime+1
        var childs = 0

        for (edge in graph[src]!!) {
            if (edge.dest == parent) continue
            else if (visited[edge.dest]) {
                lowestTime[src] = Math.min(lowestTime[src], discoveryTime[edge.dest])
            } else {
                dfs(edge.dest, src,currentTime+1,lowestTime, discoveryTime, visited, ap)
                lowestTime[src] = Math.min(lowestTime[src],lowestTime[edge.dest])
                if (parent != -1 && discoveryTime[src] <= lowestTime[edge.dest]) {
                    println("AP: $src")

                }
                childs++
            }
        }
        if (parent == -1 && childs > 1) {
            println("AP: $src")
        }
    }
    fun getAriticulationPoint() {
        val lowestTime = IntArray(graph.size+1)
        val discoveryTime = IntArray(graph.size+1)
        val visited = BooleanArray(graph.size+1)
        val ap = BooleanArray(graph.size+1)

        graph.values.forEach {edges ->
            edges.forEach {
                dfs(it.src,-1,0,lowestTime, discoveryTime, visited, ap)
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

        getAriticulationPoint()
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

        getAriticulationPoint()
    }
}


AP: 6
AP: 5
AP: 3
===========================
AP: 3
AP: 0
