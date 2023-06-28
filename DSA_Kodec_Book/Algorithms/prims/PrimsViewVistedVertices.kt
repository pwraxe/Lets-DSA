import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

data class Vertex<T>(val id: Int, val dataItem: T)
data class Edge<T>(val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight: Int) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int = weight.compareTo(other.weight)
}
class GraphByAdjList<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()
    val vertices : Set<Vertex<T>> = adjacencies.keys

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


    //----------------------------following code for Prims

    fun createNewCopyOfAdjacencies(adjList: GraphByAdjList<T>) {
        adjList.vertices.forEach {
            adjacencies[it] = mutableSetOf()
        }
    }
}



object Prims {

    fun <T> producingMinSpanningTree(adjList: GraphByAdjList<T>) : Pair<Double, MutableSet<Vertex<T>>> {
        //To get total cost among all vertices
        var cost = 0.0

        //To Generate new Graph with Minimum Edges
        val minSpanningTree = GraphByAdjList<T>()

        //To keep track of vertices which is visited or which is remain to visit
        val visitedVertices = mutableSetOf<Vertex<T>>()

        //Here We are comparing Edges instead of Vertex like in Dijkstra,
        val comparator = Comparator<Edge<T>> {first, second ->
            second.weight - first.weight
        }

        val priorityQueue = PriorityQueue(comparator)
        //We create new adjacencies list for MST, having all vertices and emptyList to values
        minSpanningTree.createNewCopyOfAdjacencies(adjList)

        //from adjacency List get first vertex, if no vertex return
        val startVertex = adjList.vertices.firstOrNull() ?: return Pair(cost,visitedVertices)

        //this is first vertex which we just visit before loop, thats why we add it
        visitedVertices.add(startVertex)

        //CODE-COPY1
        //Get Edges and Check destination already visited or not, if not add to visited list
        //below code is same as CODE-COPY2, we can write in separate function
        adjList.getAllEdges(startVertex).forEach {
            if(!visitedVertices.contains(it.destinationVertex)) priorityQueue.add(it)
        }

        //instead of true we can write `priorityQueue.isNotEmpty()` function,
        while(true) {

            //get front vertex from PriorityQueue
            val edge = priorityQueue.poll() ?: break

            //get destination
            val destination = edge.destinationVertex

            //if destinationVertex Node is already present in Visited then do not execute further , go to new iteration
            if(visitedVertices.contains(destination)) continue

            cost += edge.weight

            //As we already check destination has in visitedVertices or not, this line executing mean visitedVertices not contains destination
            //hence add to visitedVertices
            visitedVertices.add(destination)

            //also we adding edge to newly created Spanning Tree
            minSpanningTree.addEdge(edge.startVertex, edge.destinationVertex, edge.weight)

            //CODE-COPY2
            //Get Edges and Check destination already visited or not, if not add to visited list,
            //below code is same as CODE-COPY1, we can write in separate function
            adjList.getAllEdges(destination).forEach {
                if(it.destinationVertex !in visitedVertices) priorityQueue.add(it)
            }
        }

        //Prims suppose to return min Edges Tree hence we are passing total cost and object of newly created graph
        return Pair(cost, visitedVertices)
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

        Prims.producingMinSpanningTree(this).apply {
            println("COST : ${this.first}")
            println("Vertices : ${second.map { it.dataItem }}")
        }
    }
}
