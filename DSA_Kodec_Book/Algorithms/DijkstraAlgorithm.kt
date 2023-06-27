/***
 *
 * TODO (DONE)
 *
 * TODO-->
 *
 *  - Understand All Code
 *  - Save Somewhere Temp.
 *  - Delete All Code
 *  - REDO - All With Default Priority Queue using Comparator Inerface
 *  - REDO all with Customised Priority Queue
 *  - Find Shortest PAth of any node
 *  Change Graph and VErtex and try to find min Distance
 *  -- After-all you need to print shorted path of graph thats it
 * **/

data class Vertex<T>(val index: Int, val dataItem: T)
data class Edge<T>(val startVertex: Vertex<T>, val destinationVertex: Vertex<T>, val weight: Int) : Comparable<Edge<T>> {
    override fun compareTo(other: Edge<T>): Int = weight.compareTo(other.weight)
}
enum class VisitType { START, EDGE }
class Visits<T>(val type: VisitType, val edge: Edge<T>? = null)


class MinPriorityQueueHeap<T>(private val comparator: Comparator<T>) {

    private val elementsInQueue = arrayListOf<T>()

    fun enquque(item: T) {
        elementsInQueue.add(item)
        toMinHeapAfterEnqueue(elementsInQueue.size - 1)
    }

    fun dequeue() : T? {
        if(elementsInQueue.isNotEmpty()) {
            val lastIndex = elementsInQueue.size - 1
            elementsInQueue[0] = elementsInQueue[lastIndex].also { elementsInQueue[lastIndex] = elementsInQueue[0] }
            val item = elementsInQueue.removeLast()
            toMinHeapAfterDequeue(0)
            return item
        }

        return null
    }

    fun isEmpty () = elementsInQueue.isEmpty()

    private fun toMinHeapAfterEnqueue(index: Int) {
        val parentIndex = (index - 1) / 2
        try {
            if(parentIndex > 0 && comparator.compare(elementsInQueue[index], elementsInQueue[parentIndex]) > 0) {
                elementsInQueue[index] = elementsInQueue[parentIndex].also { elementsInQueue[parentIndex] = elementsInQueue[index] }
            }
        }catch (ex: Exception) {}

        if(index != parentIndex) {
            toMinHeapAfterEnqueue(parentIndex)
        }
    }

    private fun toMinHeapAfterDequeue(index: Int) {
        val leftChildIndex = (2 * index ) + 1
        val rightChildIndex = (2 * index) + 2
        var currentIndex = index

        if(leftChildIndex < elementsInQueue.size-1 && comparator.compare(elementsInQueue[leftChildIndex], elementsInQueue[currentIndex]) > 0) {
            currentIndex = leftChildIndex
        }
        if(rightChildIndex < elementsInQueue.size-1 && comparator.compare(elementsInQueue[rightChildIndex], elementsInQueue[currentIndex]) > 0) {
            currentIndex = rightChildIndex
        }

        if (currentIndex != index) {
            elementsInQueue[currentIndex] = elementsInQueue[index].also { elementsInQueue[index] = elementsInQueue[currentIndex] }
            toMinHeapAfterDequeue(currentIndex)
        }
    }
}


class GraphByAdjList<T> {

    private val adjacencies : HashMap<Vertex<T>, MutableSet<Edge<T>>> = hashMapOf()

    fun createVertex(dataItem: T) : Vertex<T> {
        val vertex = Vertex(adjacencies.count(),dataItem)
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

    fun getAllEdges(vertex: Vertex<T>) = adjacencies[vertex] ?: mutableSetOf()

    fun getWeight(startVertex: Vertex<T>, destinationVertex: Vertex<T>) : Int = adjacencies[startVertex]?.first { it.destinationVertex == destinationVertex }?.weight ?: 0
}

class DijkstraAlgorithm<T>(private val graphByAdjList: GraphByAdjList<T>) {

    fun letsExploreAllShortestPathToVertex(startVertex: Vertex<T>) : HashMap<Vertex<T>, Visits<T>> {
        val pathsList = hashMapOf<Vertex<T>, Visits<T>>()
        pathsList[startVertex] = Visits(VisitType.START)

        val comparator = Comparator<Vertex<T>> { first, second ->
            val secondTd = getShortestPathToDestination(second, pathsList).sumOf { it.weight ?: 0}
            val firstTd = getShortestPathToDestination(first, pathsList).sumOf { it.weight ?: 0 }
            (secondTd - firstTd)
        }

        val priorityQueue = MinPriorityQueueHeap<Vertex<T>>(comparator)
        priorityQueue.enquque(startVertex)

        while (!priorityQueue.isEmpty()) {
            val vertex = priorityQueue.dequeue() ?: break
            graphByAdjList.getAllEdges(vertex).forEach {
                val weight = it.weight ?: return@forEach

                val newDistance = getShortestPathToDestination(it.startVertex, pathsList).sumOf { it.weight ?: 0} + weight
                val existingDistance = getShortestPathToDestination(it.destinationVertex, pathsList) .sumOf { it.weight }

                if(pathsList[it.destinationVertex] == null || newDistance < existingDistance) {
                    pathsList[it.destinationVertex] = Visits(VisitType.EDGE,it)
                    priorityQueue.enquque(it.destinationVertex)
                }
            }
        }
        return pathsList

    }

    fun getShortestPathToDestination(destination: Vertex<T>, paths : HashMap<Vertex<T>, Visits<T>>) : ArrayList<Edge<T>> {

        var vertex = destination
        val pathList = arrayListOf<Edge<T>>()

        loope@while (true) {
            val visit = paths[vertex] ?: break
            when(visit.type) {
                VisitType.EDGE -> {
                    visit.edge?.let {
                        pathList.add(it)
                        vertex = it.startVertex
                    }
                }
                VisitType.START -> break@loope
            }
        }
        return pathList
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

        DijkstraAlgorithm(this).apply {
            val pathsList = this.letsExploreAllShortestPathToVertex(startVertex = vertexA)
            var dist = 0
            this.getShortestPathToDestination(vertexH,pathsList).forEach {
                dist += it.weight
                print("(${it.startVertex.dataItem} ---- ${it.weight} ----> ${it.destinationVertex.dataItem}), ")
            }
            println("Total Distance A ---> H: $dist")

            dist = 0
            this.getShortestPathToDestination(vertexI, pathsList).forEach {
                dist += it.weight
                print("(${it.startVertex.dataItem} ---- ${it.weight} ----> ${it.destinationVertex.dataItem}), ")
            }
            println("Total Distance A ---> I : $dist")
        }
    }
}
