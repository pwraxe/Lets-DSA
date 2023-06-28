import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/****
class MinPriorityQueue<T: Comparable<T>> {

    private val persons = arrayListOf<T>()
    private fun count() = persons.size
    private fun isEmpty() = count() == 0

    private fun getParentIndex(index: Int) = (index - 1) / 2
    private fun getLeftChildIndex (index: Int) = (2 * index) + 1
    private fun getRightChildIndex(index: Int) = (2 * index) + 2


    fun readAll() = persons
    fun enqueue(item: T) {
        persons.add(item)
        if(count() > 1) {
            toUpperForMinHeap(count()-1)
        }
    }

    private fun toUpperForMinHeap(currentIndex: Int) {

        val parentIndex = getParentIndex(currentIndex)

        if(currentIndex > 0 && persons[currentIndex] < persons[parentIndex]) {
            persons[currentIndex] = persons[parentIndex].also { persons[parentIndex] = persons[currentIndex]}
        }

        if(currentIndex != parentIndex) {
            toUpperForMinHeap(parentIndex)
        }
    }

    fun dequeue() : T? {
        if(!isEmpty()) {
            val lastIndex = count() - 1
            persons[0] = persons[lastIndex].also {persons[lastIndex] = persons[0] }
            val item = persons.removeLast()
            if(count() > 1) toLowerForMinHeap(0)
            return item
        }
        return null
    }
    private fun toLowerForMinHeap(index: Int) {
        val leftChildIndex = getLeftChildIndex(index)
        val rightChildIndex = getRightChildIndex(index)
        var currentIndex = index

        if(leftChildIndex < count() && persons[leftChildIndex] < persons[currentIndex]) {
            currentIndex = leftChildIndex
        }

        if(rightChildIndex < count() && persons[rightChildIndex] < persons[currentIndex]) {
            currentIndex = rightChildIndex
        }

        if(index != currentIndex) {
            persons[index] = persons[currentIndex].also { persons[currentIndex] = persons[index] }
            toLowerForMinHeap(currentIndex)
        }
    }
}
***/

data class Vertex<T>(val index : Int, val dataItem: T)

data class Edge<T>(
    val startVertex: Vertex<T>,
    val destinationVertex: Vertex<T>,
    val weight: Double? = null
) : Comparable<Edge<T>> { override fun compareTo(other: Edge<T>): Int {
        return this.weight?.compareTo(other.weight ?: 0.0) ?: 0
    }
}
enum class EdgeType { DIRECTED, UNDIRECTED }
interface Graph<T> {
    fun createVertex(dataItem :T ): Vertex<T>

    fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?)
    fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?)
    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?, edgeType: EdgeType)

    fun getAllEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>>
    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double

}
class GraphImplByAdjList<T>  :Graph<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    override fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex<T>(adjacencies.count(), dataItem)
        adjacencies[vertex] = mutableSetOf()
        return vertex
    }

    override fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }

    override fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }

    override fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double?, edgeType: EdgeType) {
        when(edgeType) {
            EdgeType.DIRECTED -> { addDirectedEdge(startVertex, destinationVertex, weight) }
            EdgeType.UNDIRECTED -> { addUndirectedEdge(startVertex, destinationVertex, weight) }
        }
    }

    override fun getAllEdges(startVertex: Vertex<T>): MutableSet<Edge<T>> {
        return adjacencies[startVertex] ?: mutableSetOf()
    }

    override fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>): Double {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0.0
    }
}

class MinPriorityQueueByHeap<T>(private val comparator: Comparator<T>) {
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
        
        //Getting Crach at following code
        try {
            if(parentIndex > 0 && comparator.compare(elements[index], elements[parentIndex]) > 0) {
                elements[index] = elements[parentIndex].also { elements[parentIndex] = elements[index] }
            }
        }catch (ex:Exception){}


        println()

        if(index != parentIndex) {
            toMinHeap(parentIndex)
        }
    }
}

enum class VisitType { START, EDGE }

class Visit<T> (val visitType: VisitType, val edge: Edge<T>? = null)

class Dijkstra<T>(private val graphImplByAdjList: GraphImplByAdjList<T>) {

    fun routes(destinationVertex: Vertex<T>, path: HashMap<Vertex<T>, Visit<T>>) : ArrayList<Edge<T>> {
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

    fun shortestPath (startVertex: Vertex<T>)  : HashMap<Vertex<T>, Visit<T>> {
        val paths  : HashMap<Vertex<T>, Visit<T>> = hashMapOf()
        paths[startVertex]  = Visit(VisitType.START)

        val distComparator = Comparator<Vertex<T>> { first, second ->
            (totalDistance(second, paths) - totalDistance(first, paths)).toInt()
        }

        val priorityQueue = MinPriorityQueueByHeap<Vertex<T>>(distComparator)
        priorityQueue.enqueue(startVertex)

        while (true) {
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
        addEdge(vertexA, vertexB, 5.0, EdgeType.UNDIRECTED)
        addEdge(vertexA, vertexX, 2.0, EdgeType.UNDIRECTED)

        addEdge(vertexB, vertexA, 5.0, EdgeType.UNDIRECTED)
        addEdge(vertexB, vertexX, 4.0, EdgeType.UNDIRECTED)
        addEdge(vertexB, vertexC, 3.0, EdgeType.UNDIRECTED)
        addEdge(vertexB, vertexG, 3.0, EdgeType.UNDIRECTED)

        addEdge(vertexC, vertexG, 2.0, EdgeType.UNDIRECTED)
        addEdge(vertexC, vertexX, 5.0, EdgeType.UNDIRECTED)
        addEdge(vertexC, vertexD, 7.0, EdgeType.UNDIRECTED)

        addEdge(vertexD, vertexX, 6.0, EdgeType.UNDIRECTED)
        addEdge(vertexD, vertexC, 7.0, EdgeType.UNDIRECTED)
        addEdge(vertexD, vertexF, 8.0, EdgeType.UNDIRECTED)

        addEdge(vertexF, vertexD, 8.0, EdgeType.UNDIRECTED)
        addEdge(vertexF, vertexC, 7.0, EdgeType.UNDIRECTED)
        addEdge(vertexF, vertexH, 6.0, EdgeType.UNDIRECTED)

        addEdge(vertexG, vertexB, 3.0, EdgeType.UNDIRECTED)
        addEdge(vertexG, vertexH, 10.0, EdgeType.UNDIRECTED)

        addEdge(vertexH, vertexF, 6.0, EdgeType.UNDIRECTED)
        addEdge(vertexH, vertexG, 10.0, EdgeType.UNDIRECTED)


        val dijktras = Dijkstra(this)
        val startA = dijktras.shortestPath(vertexA)
        val path = dijktras.shortestPath(vertexH,startA)
        path.forEach {
            println("${it.startVertex.dataItem} ----${it.weight} ----> ${it.destinationVertex.dataItem}")
        }
    }
}
