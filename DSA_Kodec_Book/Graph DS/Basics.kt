enum class EdgeType { DIRECTED, UNDIRECTED }
data class Vertex<T> (val index: Int, val dataItem: T)
data class Edge<T> (val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight: Double? = null)

interface Graph<T> {

    fun createVertex(dataItem: T) : Vertex<T>

    fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double)
    fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double)
    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double, edgeType: EdgeType)

    fun getAllEdges(startVertex: Vertex<T>) : ArrayList<Edge<T>>
    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double?

}

class AdjacencyList<T> : Graph<T> {


    private val adjacencies : HashMap<Vertex<T> , ArrayList<Edge<T>>> = hashMapOf()
    /**
     * Where,
     *  Vertex<T> = Here We have used vertex as key like node in trie
     *  ArrayList<Edge<T>> = single vertex can have multiple edges connected, hence we took arrayList
     * **/


    override fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex<T>(adjacencies.count(), dataItem)
        adjacencies[vertex] = arrayListOf()
        return vertex
    }

    override fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double) {
        val edge = Edge(startVertex, destinationVertex, weight)
        adjacencies[startVertex]?.add(edge)
    }

    override fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double) {
        addDirectedEdge(startVertex, destinationVertex, weight)
        addDirectedEdge(destinationVertex,startVertex, weight)
    }

    override fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double, edgeType: EdgeType) {
        when(edgeType) {
            EdgeType.DIRECTED -> { addDirectedEdge(startVertex, destinationVertex, weight) }
            EdgeType.UNDIRECTED -> {  addUndirectedEdge(startVertex, destinationVertex, weight) }
        }
    }

    override fun getAllEdges(startVertex: Vertex<T>): ArrayList<Edge<T>> = adjacencies[startVertex] ?: arrayListOf()

    override fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>): Double? {
        return getAllEdges(startVertex).firstOrNull { it.destinationVertex == destinationVertex }?.weight
    }
}
