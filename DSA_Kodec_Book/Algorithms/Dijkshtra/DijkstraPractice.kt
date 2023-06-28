import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
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
}

class Visits<T>(val type : VisitType, val edge: Edge<T>? = null)
enum class VisitType { START, EDGE }

class DijkstraAlgo<T>(private val graphByAdjList: GraphByAdjList<T>) {

    fun getRoute(destinationVertex: Vertex<T>, pathList: HashMap<Vertex<T>, Visits<T>>) : ArrayList<Edge<T>> {
        var vertex = destinationVertex
        val paths : ArrayList<Edge<T>> = arrayListOf()

        loop@while(true) {
            val visit = pathList[vertex] ?: break
            when(visit.type) {
                VisitType.EDGE -> {
                    visit.edge?.let {
                        paths.add(it)
                        vertex = it.startVertex
                    }
                }
                VisitType.START -> break@loop
            }
        }
        return paths
    }

    fun shortestPathToEachVertex(startVertex: Vertex<T>) : HashMap<Vertex<T>, Visits<T>> {

        val path : HashMap<Vertex<T>, Visits<T>> = hashMapOf()
        path[startVertex] = Visits(VisitType.START)

        val comparator = Comparator<Vertex<T>> {first, second ->
            getRoute(second, path).sumOf { it.weight } - getRoute(first, path).sumOf { it.weight }
        }

        val priorityQueue = PriorityQueue(comparator)
        priorityQueue.add(startVertex)

        while(priorityQueue.isNotEmpty()) {
            val vertex = priorityQueue.poll()

            graphByAdjList.getAllEdges(vertex).forEach {
                val weight = it.weight

                val newDistance = getRoute(it.startVertex,path).sumOf { it.weight } + weight
                val existingDistance = getRoute(it.destinationVertex,path).sumOf { it.weight }

                if(path[it.destinationVertex] == null || newDistance < existingDistance) {
                    path[it.destinationVertex] = Visits(VisitType.EDGE,it)
                    priorityQueue.add(it.destinationVertex)
                }
            }
        }
        return path
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

        DijkstraAlgo<String>(this).apply {
            val pathsList = this.shortestPathToEachVertex(vertexA)
            getRoute(vertexH,pathsList).forEach {
                println("${it.startVertex.dataItem}----${it.weight}---->${it.destinationVertex.dataItem}")
            }
        }
    }
}
