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

class GraphImplByMatrix<T> : Graph<T> {

    private val vertices : ArrayList<Vertex<T>> = arrayListOf()
    private val weightMatrix : ArrayList<ArrayList<Double?>> = arrayListOf()
    //Declare 2D Array in ALT,
    //private val matrix = Array (vertices.size){ Array(vertices.size) { 0.0 } }



    /**
     * Note: Here you need to expand matrix by column and rows
     *
     * At each time you add One More column and 1 more row in matrix
     * Total Rows and Column = vertices.size * vertices.size
     *
     * Step 1 : Add 1 more box at end of each row
     * Step 2 : Create a empty list with size of total vertices.size
     *      in loop { add each column with default value }
     *  Step 3 : Add row in weightMatrix list
     *
     * **/
    override fun createVertex(dataItem: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), dataItem)
        vertices.add(vertex)

        //Now Add 1 more column to matrix at each row
        weightMatrix.forEach {
            it.add(0.0)
        }

        //Create one more row at below metrix
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(0.0)
        }

        //Add row at end of matrix
        weightMatrix.add(row)
        return vertex
    }


    override fun addDirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double) {
        weightMatrix[startVertex.index][destinationVertex.index] = weight
    }

    override fun addUndirectedEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double) {}
    override fun addEdge(startVertex: Vertex<T>, destinationVertex: Vertex<T>, weight: Double, edgeType: EdgeType) {}

    override fun getAllVertexEdges(startVertex: Vertex<T>): MutableSet<Edge<T>> {
        val edges = mutableSetOf<Edge<T>>()
        (0 until weightMatrix.size).forEach { column ->
            val weight = weightMatrix[startVertex.index][column]
            if(weight != 0.0) {
                edges.add(Edge(startVertex, vertices[column],weight))
            }
        }
        return edges
    }

    override fun getEdgeWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>): Double {
        return weightMatrix[startVertex.index][destinationVertex.index] ?: 0.0
    }

    fun readAll() {
        weightMatrix.forEach {
            it.forEach {
                print("$it      ")
            }
            println()
        }
    }
}






fun main() {

    //In Order to Understand Graph, you need to create own graph for this
    GraphImplByMatrix<String>().apply {

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
        addDirectedEdge(vertexA, vertexB,5.0)
        addDirectedEdge(vertexA, vertexX, 2.0)

        addDirectedEdge(vertexB, vertexA, 5.0,)
        addDirectedEdge(vertexB,vertexX, 4.0,)
        addDirectedEdge(vertexB, vertexC,3.0,)
        addDirectedEdge(vertexB, vertexG, 3.0,)

        addDirectedEdge(vertexC,vertexG,2.0,)
        addDirectedEdge(vertexC,vertexX,5.0,)
        addDirectedEdge(vertexC,vertexD,7.0,)

        addDirectedEdge(vertexD,vertexX,6.0,)
        addDirectedEdge(vertexD,vertexC,7.0,)
        addDirectedEdge(vertexD,vertexF,8.0,)

        addDirectedEdge(vertexF,vertexD,8.0,)
        addDirectedEdge(vertexF,vertexC,7.0,)
        addDirectedEdge(vertexF,vertexH,6.0,)

        addDirectedEdge(vertexG,vertexB,3.0)
        addDirectedEdge(vertexG,vertexH,10.0)

        addDirectedEdge(vertexH,vertexF,6.0)
        addDirectedEdge(vertexH,vertexG,10.0)

        readAll()

//        readEdges(vertexA)
    }
}
