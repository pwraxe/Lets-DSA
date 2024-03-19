data class Edge(val src:Int, val dest:Int, val weight: Int)
class MstGraph {

    private val graph = hashMapOf<Int,MutableList<Edge>>()

    fun addEdge(src: Int, dest: Int, weight: Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest, weight)) }
    }
    fun readGraph() {
        graph.forEach {
            print("[${it.key}] -> ")
            it.value.forEach {
                print("${it.dest}, ")
            }
            println()
        }
    }

    //=================================================================================================

    private val parents = IntArray(8) { it }
    private val allEdges = mutableListOf<Edge>()
    private val mstGraph = mutableListOf<Edge>()

    private fun find(i:Int):Int {
        if (i == parents[i]) return i
        parents[i] = find(parents[i])
        return parents[i]
    }
    private fun union(src: Int, dest: Int) {
        parents[find(src)] = find(dest)
    }

    fun applyKruskalAlgorithm() {
        //Step 1: Extract all edges
        graph.values.forEach {
            allEdges.addAll(it)
        }

        //Step 2: Sort All Edges
        allEdges.sortBy { it.weight }

        allEdges.forEach {
            val srcParent = find(it.src)
            val destParent = find(it.dest)
            if (srcParent != destParent) {
                mstGraph.add(it)
                union(srcParent, destParent)
            }
        }

        var weightSum = 0
        mstGraph.forEach {
            println("(${it.src}) --${it.weight}--> (${it.dest})")
            weightSum += it.weight
        }

        println("\nWeight Sum: $weightSum")
    }
}

fun main() {
    MstGraph().apply {
        addEdge(1,2,2)
        addEdge(1,7,3)

        addEdge(2,1,2)
        addEdge(2,7,3)
        addEdge(2,3,4)

        addEdge(3,2,4)
        addEdge(3,4,5)
        addEdge(3,6,1)

        addEdge(4,3,5)
        addEdge(4,5,2)
        addEdge(4,6,4)

        addEdge(5,4,2)

        addEdge(6,3,1)
        addEdge(6,4,4)
        addEdge(6,7,2)

        addEdge(7,1,3)
        addEdge(7,2,3)
        addEdge(7,6,2)

        readGraph()
        println("=====================")
        applyKruskalAlgorithm()
    }
}

//=========================
[1] -> 2, 7, 
[2] -> 1, 7, 3, 
[3] -> 2, 4, 6, 
[4] -> 3, 5, 6, 
[5] -> 4, 
[6] -> 3, 4, 7, 
[7] -> 1, 2, 6, 
=====================
(3) --1--> (6)
(1) --2--> (2)
(4) --2--> (5)
(6) --2--> (7)
(1) --3--> (7)
(4) --4--> (6)

Weight Sum: 14
