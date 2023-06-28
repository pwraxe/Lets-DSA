import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

data class Vertex<T>(val id: Int, val dataItem: T)
data class Edge<T>(val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight: Int) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int = weight.compareTo(other.weight)
}
class GraphByAdjList<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    fun createVertex(dataItem :T)  :Vertex<T> {
        val vertex =Vertex(adjacencies.count(), dataItem)
        adjacencies[vertex] = mutableSetOf()
        return vertex
    }

    private fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Int) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }

    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Int) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }

    fun getAllEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>> = adjacencies[startVertex] ?: mutableSetOf()


    //----------------------------following code for Prims

    val vertices : Set<Vertex<T>>
        get() = adjacencies.keys

    fun createNewCopyOfAdjacencies(adjList: GraphByAdjList<T>) {
        adjList.vertices.forEach {
            adjacencies[it] = mutableSetOf()
        }
    }

}



object Prims {

    private fun <T> addUnvisitedEdges(
        vertex: Vertex<T>,
        adjList: GraphByAdjList<T>,
        visitedVertices : Set<Vertex<T>>,
        priorityQueue: PriorityQueue<Edge<T>>) {
        adjList.getAllEdges(vertex).forEach {
            if(it.destinationVertex !in visitedVertices) {
                priorityQueue.add(it)
            }
        }
    }

    fun <T> producingMinSpanningTree(adjList: GraphByAdjList<T>) : Pair<Double, GraphByAdjList<T>> {
        var cost = 0.0
        val minSpanningTree = GraphByAdjList<T>()
        val visitedVertices = mutableSetOf<Vertex<T>>()
        
        val comparator = Comparator<Edge<T>> {first, second ->
            second.weight - first.weight
        }

        val priorityQueue = PriorityQueue(comparator)
        minSpanningTree.createNewCopyOfAdjacencies(adjList)

        val start = adjList.vertices.firstOrNull() ?: return Pair(cost,minSpanningTree)
        visitedVertices.add(start)
        addUnvisitedEdges(start,adjList,visitedVertices, priorityQueue)

        while(true) {

            val edge = priorityQueue.poll() ?: break
            val destination = edge.destinationVertex

            //if destinationVertex Node is already present in Visited then do not execute further , go to new iteration
            if(visitedVertices.contains(destination)) continue

            visitedVertices.add(destination)
            cost += edge.weight
            minSpanningTree.addEdge(edge.startVertex, edge.destinationVertex, edge.weight)
            addUnvisitedEdges(destination,adjList,visitedVertices, priorityQueue)
        }

        return Pair(cost, minSpanningTree)
    }
}

fun main() {

    GraphByAdjList<String> ().apply {
        val vertexA = createVertex("A")
        val vertexB = createVertex("B")
        val vertexD = createVertex("D")
        val vertexE = createVertex("E")
        val vertexF = createVertex("F")
        val vertexG = createVertex("G")
        val vertexH = createVertex("H")
        val vertexI = createVertex("I")

        addEdge(vertexA, vertexB, 3)
        addEdge(vertexA, vertexD, 4)
        addEdge(vertexA, vertexG, 8)

        addEdge(vertexB, vertexA, 3)
        addEdge(vertexB,vertexE,5)
        addEdge(vertexB,vertexF,3)

        addEdge(vertexD, vertexA, 4)
        addEdge(vertexD, vertexE,3)
        addEdge(vertexD, vertexG,5)

        addEdge(vertexF,vertexB,3)
        addEdge(vertexF,vertexE,6)
        addEdge(vertexF,vertexH,5)
        addEdge(vertexF,vertexI,8)

        addEdge(vertexE,vertexD,3)
        addEdge(vertexE,vertexB,5)
        addEdge(vertexE,vertexF,6)
        addEdge(vertexE,vertexI,6)
        addEdge(vertexE,vertexG,3)

        addEdge(vertexG, vertexA, 8)
        addEdge(vertexG, vertexD, 5)
        addEdge(vertexG, vertexE,3)
        addEdge(vertexG,vertexI,4)

        addEdge(vertexH,vertexF,5)

        addEdge(vertexI,vertexG,4)
        addEdge(vertexI,vertexE,6)
        addEdge(vertexI,vertexF,8)

        Prims.producingMinSpanningTree(this).apply {
            println("COST : ${this.first}")
        }
    }
}
