import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//Program: Graph by Adjacent List, BFS, DSF (expected Time : 20min)

data class Vertex<T>(val index: Int, val dataItem: T)
enum class EdgeType { DIRECTED, UNDIRECTED }
data class Edge<T> (
    val startVertex: Vertex<T>,
    val destinationVertex : Vertex<T>,
    val weight: Double? = null
)

interface Graph<T> {

    fun createVertex(dataItem : T): Vertex<T>

    fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double)
    fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double)
    fun addEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double, edgeType: EdgeType)

    fun getAllEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>>
    fun getWeight(startVertex: Vertex<T>, destinationVertex : Vertex<T>) : Double
}

class GraphImplByAdjList<T> : Graph<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    override fun createVertex(dataItem : T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), dataItem)
        adjacencies[vertex] = mutableSetOf()
        return vertex
    }

    override fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }

    override fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }

    override fun addEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double, edgeType: EdgeType) {
        when (edgeType) {
            EdgeType.DIRECTED -> {
                addDirectedEdge(startVertex, destinationVertex, weight)
            }
            EdgeType.UNDIRECTED -> {
                addUndirectedEdge(startVertex, destinationVertex, weight)
            }
        }
    }

    override fun getAllEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>> {
        return adjacencies[startVertex] ?: mutableSetOf<Edge<T>>()
    }

    override fun getWeight(startVertex: Vertex<T>, destinationVertex : Vertex<T>) : Double {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0.0
    }


    fun BFS(startVertex: Vertex<T>) : ArrayList<Vertex<T>> {
        val queue = LetsQueue<Vertex<T>>()
        val enqueued = arrayListOf<Vertex<T>>()

        queue.enqueue(startVertex)
        enqueued.add(startVertex)

        while(true) {
            val vertex = queue.dequeue() ?: break
            getAllEdges(vertex).forEach {
                if(it.destinationVertex !in enqueued) {
                    queue.enqueue(it.destinationVertex)
                    enqueued.add(it.destinationVertex)
                }
            }
        }

        return enqueued
    }

    fun DFS(startVertex: Vertex<T>) : ArrayList<Vertex<T>> {

        val stack = LetsStack<Vertex<T>>()
        val pushedElements = arrayListOf<Vertex<T>>()

        stack.push(startVertex)
        pushedElements.add(startVertex)

        outer@while (true) {

            if(stack.isEmpty()) break
            val peek = stack.peek() as Vertex<T>
            val edges = getAllEdges(peek)
            println("Edge Size : ${edges.size}  |  ${edges.isEmpty()} ")
            if(edges.isEmpty()) {
                stack.pop()
                continue
            }

            for (i in 0 until edges.size) {
                val destination = edges.elementAt(i).destinationVertex
                if (destination !in pushedElements) {
                    stack.push(destination)
                    pushedElements.add(destination)
                    continue@outer
                }
            }
            stack.pop()
        }
        return pushedElements
    }
}

class LetsQueue<T> {
    private val elements = arrayListOf<T>()

    fun enqueue(dataItem: T) {
        elements.add(dataItem)
    }
    fun dequeue() : T? {
        return if(elements.isNotEmpty()) elements.removeAt(0) else null
    }
}

class LetsStack<T> () {
    private val elements = arrayListOf<T>()
    fun push(dataItem  :T) {
        elements.add(dataItem)
    }
    fun pop() : T? = elements.removeLastOrNull()
    fun isEmpty()  = elements.isEmpty()
    fun peek() :T? = elements.lastOrNull()
}

fun main() {

    //In Order to Understand Graph, you need to create own graph for this
    GraphImplByAdjList<String>().apply {

        //Create All Vertex

        val vertexA = createVertex("A")
        val vertexB = createVertex("B")
        val vertexC = createVertex("C")
        val vertexD = createVertex("D")
        val vertexE = createVertex("E")
        val vertexF = createVertex("F")
        val vertexG = createVertex("G")
        val vertexH = createVertex("H")


        //Add All Edges
        addDirectedEdge(vertexA, vertexB,5.0)
        addDirectedEdge(vertexA, vertexC, 2.0)
        addDirectedEdge(vertexA, vertexD, 2.0)

        addDirectedEdge(vertexB, vertexA, 5.0)
        addDirectedEdge(vertexB,vertexE, 4.0)

        addDirectedEdge(vertexC,vertexG,2.0)
        addDirectedEdge(vertexC,vertexF,5.0)
        addDirectedEdge(vertexC,vertexA,7.0)

        addDirectedEdge(vertexD,vertexA,6.0)

        addDirectedEdge(vertexE,vertexB,6.0)
        addDirectedEdge(vertexE,vertexF,6.0)
        addDirectedEdge(vertexE,vertexH,6.0)

        addDirectedEdge(vertexF,vertexE,8.0)
        addDirectedEdge(vertexF,vertexC,7.0)
        addDirectedEdge(vertexF,vertexG,6.0)

        addDirectedEdge(vertexG,vertexF,3.0)
        addDirectedEdge(vertexG,vertexC,10.0)

        addDirectedEdge(vertexH,vertexE,6.0)

        

        BFS(vertexA).forEach { print("${it.dataItem}, ") }

        DFS(vertexA).forEach { print("${it.dataItem}, ") }
    }
}
