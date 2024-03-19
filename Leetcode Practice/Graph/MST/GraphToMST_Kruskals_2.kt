data class Edge(val src:Char, val dest:Char, val weight: Int)
class MstGraph {

    private val graph = hashMapOf<Char,MutableList<Edge>>()

    fun addEdge(src: Char, dest: Char, weight: Int) {
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

    private val parents = hashMapOf<Char,Char>()
    private val allEdges = mutableListOf<Edge>()
    private val mstGraph = mutableListOf<Edge>()

    private fun find(char: Char): Char {
        if (char == parents[char]) return char
        parents[char] = find(parents[char]!!)
        return parents[char]!!
    }
    private fun union(src: Char, dest: Char) {
        parents[find(src)] = find(dest)
    }
    fun applyKruskalAlgorithm() {
        //Step 1: get all Edges
        graph.forEach {
            allEdges.addAll(it.value)
        }

        //Step 2: Sort edges by asc order
        allEdges.sortBy { it.weight }

        //Step 2.1: Fill Parent List, Initially, all nodes have itself as a parent
        graph.keys.forEach {
            parents[it] = it
        }

        allEdges.forEach {
            val srcParent = find(it.src)
            val destParent = find(it.dest)
            if (srcParent != destParent) {
                union(srcParent, destParent)
                mstGraph.add(it)
            }
        }

        var weightSum = 0
        mstGraph.forEach {
            println("(${it.src}) --${it.weight}--> (${it.dest})")
            weightSum += it.weight
        }

        println("\nMST Weight: $weightSum")
    }
}

fun main() {
    MstGraph().apply {
        addEdge('A','B',2)
        addEdge('A','G',3)

        addEdge('B','A',2)
        addEdge('B','G',3)
        addEdge('B','C',4)

        addEdge('C','B',4)
        addEdge('C','D',5)
        addEdge('C','F',1)

        addEdge('D','C',5)
        addEdge('D','E',2)
        addEdge('D','F',4)

        addEdge('E','D',2)

        addEdge('F','C',1)
        addEdge('F','D',4)
        addEdge('F','G',2)

        addEdge('G','A',3)
        addEdge('G','B',3)
        addEdge('G','F',2)

        readGraph()
        println("=====================")
        applyKruskalAlgorithm()
    }
}

//====================OUTPUT============
[A] -> B, G, 
[B] -> A, G, C, 
[C] -> B, D, F, 
[D] -> C, E, F, 
[E] -> D, 
[F] -> C, D, G, 
[G] -> A, B, F, 
=====================
(C) --1--> (F)
(A) --2--> (B)
(D) --2--> (E)
(F) --2--> (G)
(A) --3--> (G)
(D) --4--> (F)

MST Weight: 14
