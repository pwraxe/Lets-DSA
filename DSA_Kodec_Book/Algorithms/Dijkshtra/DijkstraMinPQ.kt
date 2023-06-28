import java.util.*
import kotlin.Comparator

data class Vertex<T>(val index : Int, val dataItem: T)
data class Edge<T>(
    val startVertex: Vertex<T>,
    val destinationVertex: Vertex<T>,
    val weight: Double? = null
) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int  = this.weight?.compareTo(other.weight ?: 0.0) ?: 0
}
enum class VisitType { START, EDGE }
class Visit<T> (val visitType: VisitType, val edge: Edge<T>? = null)

class GraphImplByAdjList<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex<T>(adjacencies.count(), dataItem)
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

    fun getAllEdges(startVertex: Vertex<T>): MutableSet<Edge<T>> {
        return adjacencies[startVertex] ?: mutableSetOf()
    }

    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>): Double {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0.0
    }
}

class MinPriorityQueueByHeap<T> (private val comparator: Comparator<T> ) {
    private val elements = arrayListOf<T>()

    private fun count() = elements.size
    private fun isEmpty() = count() == 0

    fun enqueue(item: T) {
        elements.add(item)
        toMinHeap(count() - 1)
    }

    fun dequeue() : T? {

        if(!isEmpty()) {
            val lastIndex = count() - 1
            elements[0] = elements[lastIndex].also { elements[lastIndex] = elements[0] }
            val item = elements.removeAt(lastIndex)
            if(count() > 0) toMinHeap(lastIndex)
            return item
        }
        return null
    }

    private fun toMinHeap(index: Int) {

        val parentIndex = (index - 1) / 2

        //Getting Crash at following code
        try {
            if(parentIndex > 0 && comparator.compare(elements[index], elements[parentIndex]) > 0) {
                elements[index] = elements[parentIndex].also { elements[parentIndex] = elements[index] }
            }
        }catch (ex:Exception){}


        if(index != parentIndex) {
            toMinHeap(parentIndex)
        }
    }
}

class Dijkstra<T>(private val graphImplByAdjList: GraphImplByAdjList<T>) {

    fun shortestPath (startVertex: Vertex<T>)  : HashMap<Vertex<T>, Visit<T>> {

        val paths  : HashMap<Vertex<T>, Visit<T>> = hashMapOf()
        paths[startVertex]  = Visit(VisitType.START)

        //I am passing custom comparator to Own Created MinPriorityQueueByHeap Class for comparing two vertices
        val distComparator = Comparator<Vertex<T>> { first, second ->
            val firstTD = routes(first, paths) .sumOf { it.weight ?: 0.0 }
            val secondTD = routes(second, paths).sumOf { it.weight ?: 0.0 }                     //totalDistance(second, paths)
            (secondTD - firstTD).toInt()
        }

        val priorityQueue = MinPriorityQueueByHeap<Vertex<T>>(distComparator)
        priorityQueue.enqueue(startVertex)

        while (true) {
            //val vertex =  priorityQueue.remove() ?: break
            val vertex =  priorityQueue.dequeue() ?: break
            val edges = graphImplByAdjList.getAllEdges(vertex)
            edges.forEach {
                val weight = it.weight ?: return@forEach
                if(paths[it.destinationVertex] == null || totalDistance(vertex,paths) + weight < totalDistance(it.destinationVertex, paths)) {
                    paths[it.destinationVertex] = Visit(VisitType.EDGE, it)
                    priorityQueue.enqueue(it.destinationVertex)
                }
            }
        }
        return paths
    }

    private fun routes(destinationVertex: Vertex<T>, path: HashMap<Vertex<T>, Visit<T>>) : ArrayList<Edge<T>> {
        var vertex = destinationVertex
        val pathList = arrayListOf<Edge<T>>()

        loop@while(true) {
            val visits = path[vertex] ?: break
            when (visits.visitType) {
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

    private fun totalDistance(destinationVertex: Vertex<T>, pathList: HashMap<Vertex<T>, Visit<T>>) : Double {
        val paths = routes(destinationVertex, pathList)
        return paths.sumOf { it.weight ?: 0.0 }
    }

    fun shortestPath(destinationVertex: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>)  :ArrayList<Edge<T>> {
        return routes(destinationVertex,paths)
    }
}

fun main () {

    GraphImplByAdjList<String>().apply {

        //Create All Vertex

        val vertexA = createVertex("A")
        val vertexB = createVertex("B")
        val vertexC = createVertex("C")
        val vertexD = createVertex("D")
        val vertexF = createVertex("F")
        val vertexG = createVertex("G")
        val vertexH = createVertex("H")
        val vertexX = createVertex("X")

        //Add All Edges
        addEdge(vertexA, vertexB, 5.0)
        addEdge(vertexA, vertexX, 2.0)

        addEdge(vertexB, vertexA, 5.0)
        addEdge(vertexB, vertexX, 4.0)
        addEdge(vertexB, vertexC, 3.0)
        addEdge(vertexB, vertexG, 3.0)

        addEdge(vertexC, vertexG, 2.0)
        addEdge(vertexC, vertexX, 5.0)
        addEdge(vertexC, vertexD, 7.0)

        addEdge(vertexD, vertexX, 6.0)
        addEdge(vertexD, vertexC, 7.0)
        addEdge(vertexD, vertexF, 8.0)

        addEdge(vertexF, vertexD, 8.0)
        addEdge(vertexF, vertexC, 7.0)
        addEdge(vertexF, vertexH, 6.0)

        addEdge(vertexG, vertexB, 3.0)
        addEdge(vertexG, vertexH, 10.0)

        addEdge(vertexH, vertexF, 6.0)
        addEdge(vertexH, vertexG, 10.0)


        val dijktras = Dijkstra(this)
        val startA = dijktras.shortestPath(vertexA)
        val path = dijktras.shortestPath(vertexH,startA)
        path.forEach {
            println("${it.startVertex.dataItem} ----${it.weight} ----> ${it.destinationVertex.dataItem}")
        }
    }
}
