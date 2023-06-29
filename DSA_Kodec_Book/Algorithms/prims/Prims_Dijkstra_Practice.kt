import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.cos

/**
 * TODO of the Session
 * --> Practice Dijkstra
 * --> Practice Prims
 * --> Then Goto Next
 *
 * **/


data class Vertex<T>(val index: Int, val dataItem : T)
data class Edge<T>(val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight: Int = 0) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int = weight.compareTo(other.weight)
}

interface Graph<T> {

    fun createVertex(dataItem : T): Vertex<T>
    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Int)
    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Int
    fun getAllEdges(vertex: Vertex<T>) : MutableSet<Edge<T>>
}

class GraphByAdjList<T> : Graph<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    override fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex<T>(adjacencies.count(), dataItem)
        adjacencies[vertex] = mutableSetOf()
        return vertex
    }
    private fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Int) {
        val edge = Edge<T>(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }
    override fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Int) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }
    override fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>): Int = adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0
    override fun getAllEdges(vertex: Vertex<T>) : MutableSet<Edge<T>> = adjacencies[vertex] ?: mutableSetOf()



    val vertices: Set<Vertex<T>>
        get() = adjacencies.keys

    fun createAdjCopy(adjList: GraphByAdjList<T>) {
        adjList.vertices.forEach {
            adjacencies[it] = mutableSetOf()
        }
    }
}

data class Visits<T>(val visitType: VisitType, val edge: Edge<T>? = null)
enum class VisitType { START, EDGE }
class DijkstraAlgorithm<T>(private val adjList: GraphByAdjList<T>) {

    fun getRoute(destinationVertex: Vertex<T>, paths: HashMap<Vertex<T>, Visits<T>>) : ArrayList<Edge<T>> {
        val pathList = arrayListOf<Edge<T>>()
        var vertex = destinationVertex

        while (true) {
            val visits = paths[vertex] ?: break
            when(visits.visitType) {
                VisitType.EDGE -> {
                    visits.edge?.let {
                        pathList.add(it)
                        vertex = it.startVertex
                    }
                }
                VisitType.START -> break
            }
        }
        return pathList
    }

    fun letsConvertGraphInShortestPath(startVertex: Vertex<T>): HashMap<Vertex<T>, Visits<T>> {
        val pathList : HashMap<Vertex<T>, Visits<T>> = hashMapOf()
        pathList[startVertex] = Visits(VisitType.START)

        val comparator = Comparator <Vertex<T>>{ first, second ->
            getRoute(second, pathList).sumOf { it.weight } - getRoute(first, pathList).sumOf { it.weight }
        }

        val priorityQueue = PriorityQueue<Vertex<T>>(comparator)
        priorityQueue.add(startVertex)

        while (priorityQueue.isNotEmpty()) {
            val vertex = priorityQueue.poll()

            adjList.getAllEdges(vertex).forEach {

                val weight = it.weight
                val newDistance = getRoute(it.startVertex, pathList).sumOf { it.weight } + weight
                val existingDistance = getRoute(it.destinationVertex,pathList).sumOf { it.weight }

                if(pathList[it.destinationVertex] == null || newDistance < existingDistance) {
                    pathList[it.destinationVertex] = Visits(VisitType.EDGE, it)
                    priorityQueue.add(it.destinationVertex)
                }
            }
        }
        return pathList
    }
}

object Prims {


    private fun <T> addUnvisitedEdges(edgeList: MutableSet<Edge<T>>, visitedVertex: MutableSet<Vertex<T>>, priorityQueue: PriorityQueue<Edge<T>>) {
        edgeList.forEach {
            if(it.destinationVertex !in visitedVertex) {
                priorityQueue.add(it)
            }
        }
    }


    fun <T> letsCreateMinSpanningTree(adjList: GraphByAdjList<T>) : Pair<Int, MutableSet<Vertex<T>>> {
        var cost = 0
        val visitedVertices = mutableSetOf<Vertex<T>>()
        val minSpanningTree = GraphByAdjList<T>()

        val comparator = Comparator<Edge<T>> { first, second ->
            second.weight - first.weight
        }

        minSpanningTree.createAdjCopy(adjList)
        val priorityQueue = PriorityQueue<Edge<T>>(comparator)

        val startVertex = adjList.vertices.firstOrNull() ?: return Pair(cost, visitedVertices)
        visitedVertices.add(startVertex)
        addUnvisitedEdges(adjList.getAllEdges(startVertex), visitedVertices, priorityQueue)

        while (true) {
            val edge = priorityQueue.poll() ?: break
            val destinationVertex = edge.destinationVertex
            if(destinationVertex in visitedVertices) continue

            cost += edge.weight
            minSpanningTree.addEdge(edge.startVertex, edge.destinationVertex, edge.weight)
            visitedVertices.add(destinationVertex)
            addUnvisitedEdges(adjList.getAllEdges(destinationVertex), visitedVertices, priorityQueue)
        }
        return Pair(cost, visitedVertices)
    }


}


fun main() {

    GraphByAdjList<String>().apply {
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
        addEdge(vertexB, vertexE, 5)
        addEdge(vertexB, vertexF, 3)

        addEdge(vertexD, vertexA, 4)
        addEdge(vertexD, vertexE, 3)
        addEdge(vertexD, vertexG, 5)

        addEdge(vertexF, vertexB, 3)
        addEdge(vertexF, vertexE, 6)
        addEdge(vertexF, vertexH, 5)
        addEdge(vertexF, vertexI, 8)

        addEdge(vertexE, vertexD, 3)
        addEdge(vertexE, vertexB, 5)
        addEdge(vertexE, vertexF, 6)
        addEdge(vertexE, vertexI, 6)
        addEdge(vertexE, vertexG, 3)

        addEdge(vertexG, vertexA, 8)
        addEdge(vertexG, vertexD, 5)
        addEdge(vertexG, vertexE, 3)
        addEdge(vertexG, vertexI, 4)

        addEdge(vertexH, vertexF, 5)

        addEdge(vertexI, vertexG, 4)
        addEdge(vertexI, vertexE, 6)
        addEdge(vertexI, vertexF, 8)

        DijkstraAlgorithm<String>(this).apply {
            val shortestPathsList = letsConvertGraphInShortestPath(vertexA)
            getRoute(vertexF, shortestPathsList).reversed().forEach {
                println("${it.startVertex.dataItem} --- ${it.weight} ---> ${it.destinationVertex.dataItem}")
            }
        }

        Prims.letsCreateMinSpanningTree<String>(this).apply {
            println("Vertices : ${second.map { it.dataItem }}, ")
        }
    }
}
