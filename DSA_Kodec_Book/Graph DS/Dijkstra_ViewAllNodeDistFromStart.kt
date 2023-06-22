import java.util.*
import kotlin.collections.HashMap

data class Vertex<T>(val index: Int, val dataItem : T)

data class Edge<T>(val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight : Double? = null) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int = weight?.compareTo(other.weight ?: 0.0) ?: 0
}

class GraphByAdjList<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), dataItem)
        adjacencies[vertex] = mutableSetOf()
        return vertex
    }

    private fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }
    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }

    fun getAllEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>> {
        return adjacencies[startVertex] ?: mutableSetOf()
    }

    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0.0
    }

    fun dijkstra(graph: GraphByAdjList<String>, startVertex: Vertex<String>): Map<Vertex<String>, Double> {
        val distances = mutableMapOf<Vertex<String>, Double>()
        for (vertex in graph.adjacencies.keys) {
            distances[vertex] = Double.POSITIVE_INFINITY
        }
        distances[startVertex] = 0.0

        val priorityQueue = PriorityQueue<Vertex<String>>(compareBy { distances[it] })
        priorityQueue.add(startVertex)

        while (priorityQueue.isNotEmpty()) {
            val currentVertex = priorityQueue.poll()

            for (edge in graph.getAllEdges(currentVertex)) {
                val destinationVertex = edge.destinationVertex
                val newDistance = distances[currentVertex]?.plus(edge.weight ?: 0.0) ?: 0.0

                if (newDistance < distances[destinationVertex]!!) {
                    distances[destinationVertex] = newDistance
                    priorityQueue.add(destinationVertex)
                }
            }
        }

        return distances
    }
}

fun main() {
    GraphByAdjList<String>().apply {

        val vertexA = createVertex("A")
        val vertexB = createVertex("B")
        val vertexC = createVertex("C")
        val vertexD = createVertex("D")
        val vertexE = createVertex("E")
        val vertexF = createVertex("F")
        val vertexG = createVertex("G")
        val vertexH = createVertex("H")

        //Add All Edges
        addEdge(vertexA, vertexB,5.0)
        addEdge(vertexA, vertexC, 2.0)
        addEdge(vertexA, vertexD, 2.0)

        addEdge(vertexB, vertexA, 5.0)
        addEdge(vertexB,vertexE, 4.0)

        addEdge(vertexC,vertexG,2.0)
        addEdge(vertexC,vertexF,5.0)
        addEdge(vertexC,vertexA,2.0)

        addEdge(vertexD,vertexA,2.0)

        addEdge(vertexE,vertexB,4.0)
        addEdge(vertexE,vertexF,6.0)
        addEdge(vertexE,vertexH,6.0)

        addEdge(vertexF,vertexE,6.0)
        addEdge(vertexF,vertexC,5.0)
        addEdge(vertexF,vertexG,3.0)

        addEdge(vertexG,vertexF,3.0)
        addEdge(vertexG,vertexC,2.0)
        addEdge(vertexH,vertexE,6.0)

        getAllEdges(vertexA).forEach {
            println("${it.startVertex.dataItem}----${it.weight}---->${it.destinationVertex.dataItem}")
        }
        println()
        getAllEdges(vertexC).forEach {
            println("${it.startVertex.dataItem}----${it.weight}---->${it.destinationVertex.dataItem}")
        }
        println()
        getAllEdges(vertexE).forEach {
            println("${it.startVertex.dataItem}----${it.weight}---->${it.destinationVertex.dataItem}")
        }

        println("Weight of G ---> F : ${getWeight(vertexG, vertexF)}")

        dijkstra(this,vertexA).forEach {
            println("${it.key.dataItem} = ${it.value}")
        }
    }
}
