data class Vertex<T> (val index : Int, val dataItem: T)
enum class EdgeType { DIRECTED, UNDIRECTED }
data class Edge<T> (
    val startVertex: Vertex<T>,
    val destinationVertex: Vertex<T>,
    val weight: Double? = null
)

interface Graph<T> {

    fun createVertex(dataItem: T) : Vertex<T>

    fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double)
    fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double)
    fun addEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double, edgeType: EdgeType)

    fun getAllVertexEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>>
    fun getEdgeWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double

}

class GraphImplList<T> : Graph<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()


    override fun createVertex(dataItem: T) : Vertex<T> {
        val vertex = Vertex(adjacencies.count(), dataItem)
        adjacencies [vertex] = mutableSetOf()
        return vertex
    }

    //B--A
    //A--B
    override fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }


    //A--B
    //B--A
    override fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex : Vertex<T>, weight: Double) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex, startVertex, weight)
    }

    //A --- B
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

    override fun getAllVertexEdges(startVertex: Vertex<T>) : MutableSet<Edge<T>> {
        return adjacencies[startVertex] ?: mutableSetOf()
    }

    override fun getEdgeWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex  }?.weight ?: 0.0
    }

    fun readEdges(startVertex: Vertex<T>) {
        adjacencies[startVertex]?.forEach {
            //println("Edges[${it.startVertex.dataItem}] --> ${it}")
            println("(${it.startVertex.dataItem}) ----${it.weight}----(${it.destinationVertex.dataItem})")
        }
    }
    fun readAll() {
        adjacencies.forEach {
            it.value.forEach {
                println("(${it.startVertex.dataItem} | ${it.startVertex.index})----${it.weight}----(${it.destinationVertex.dataItem} | ${it.destinationVertex.index})")
            }
            println()
        }
    }
}


fun main() {

    //In Order to Understand Graph, you need to create own graph for this
    GraphImplList<String>().apply {

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
        addEdge(vertexA, vertexB,5.0, EdgeType.UNDIRECTED)
        addEdge(vertexA, vertexX, 2.0, EdgeType.UNDIRECTED)

        addEdge(vertexB, vertexA, 5.0, EdgeType.UNDIRECTED)
        addEdge(vertexB,vertexX, 4.0, EdgeType.UNDIRECTED)
        addEdge(vertexB, vertexC,3.0, EdgeType.UNDIRECTED)
        addEdge(vertexB, vertexG, 3.0, EdgeType.UNDIRECTED)

        addEdge(vertexC,vertexG,2.0, EdgeType.UNDIRECTED)
        addEdge(vertexC,vertexX,5.0, EdgeType.UNDIRECTED)
        addEdge(vertexC,vertexD,7.0, EdgeType.UNDIRECTED)

        addEdge(vertexD,vertexX,6.0, EdgeType.UNDIRECTED)
        addEdge(vertexD,vertexC,7.0, EdgeType.UNDIRECTED)
        addEdge(vertexD,vertexF,8.0, EdgeType.UNDIRECTED)

        addEdge(vertexF,vertexD,8.0, EdgeType.UNDIRECTED)
        addEdge(vertexF,vertexC,7.0, EdgeType.UNDIRECTED)
        addEdge(vertexF,vertexH,6.0, EdgeType.UNDIRECTED)

        addEdge(vertexG,vertexB,3.0,EdgeType.UNDIRECTED)
        addEdge(vertexG,vertexH,10.0,EdgeType.UNDIRECTED)

        addEdge(vertexH,vertexF,6.0,EdgeType.UNDIRECTED)
        addEdge(vertexH,vertexG,10.0,EdgeType.UNDIRECTED)

        readAll()
    }
}
