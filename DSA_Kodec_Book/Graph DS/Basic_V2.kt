/**
* Note: This code is same as File `Basic.kt` 
* But I wrote this by my own using recursion and minimum function, (just tried)
*/


data class Vertex<T>(val index: Int, val dataItem: T)
enum class EdgeType { DIRECTED, UNDIRECTED }
data class Edge<T> (
	val startVertex: Vertex<T>,
    val destinationVertex: Vertex<T>,
    val weight: Double? = null
)

interface Graph<T> {
    
    fun createVertex(dataItem : T) 
    fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double, edgeType: EdgeType = EdgeType.UNDIRECTED)
    fun getAllEdges(startVertex: Vertex<T>) : ArrayList<Edge<T>> 
    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double?
}

class GraphImplByList<T> : Graph<T> {
    
    private val adjacencies : HashMap<Vertex<T>, ArrayList<Edge<T>>> = hashMapOf()
    
    
    override fun createVertex(dataItem : T) {
        adjacencies[Vertex(adjacencies.count(), dataItem)] = arrayListOf()
    }
    
    override fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double, edgeType: EdgeType) {
         
        when(edgeType) {
            EdgeType.DIRECTED -> {
                val edge = Edge(startVertex, destinationVertex,weight)
            	adjacencies[startVertex]?.add(edge)
            }
            EdgeType.UNDIRECTED -> {
                addEdge(startVertex, destinationVertex, weight, EdgeType.DIRECTED)
                addEdge(destinationVertex, startVertex, weight, EdgeType.DIRECTED)
            }
        }
    }
    
    override fun getAllEdges(startVertex: Vertex<T>) : ArrayList<Edge<T>> {
        return adjacencies[startVertex] ?: arrayListOf()
    }
    
    override fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Double? {
        return adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight
    }   
}
