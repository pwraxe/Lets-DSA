/*
* Todo,
*  -Make Graph, Read it,
*  - Understand Kruskal's and Prims Algorithms from YouTube or Anywhere,
*  - Implement your own,then
*  -
*  - Convert Graph in Kruskal's Algorithm, Read it (Int Vertex)
*  - Convert Graph in Prims Algorithm, Read it (Int Vertex)
*  -
*  - Convert Graph in Kruskal's Algorithm, Read it (Char Vertex)
*  - Convert Graph in Prims Algorithm, Read it (Char Vertex)
*
* */

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



    private val parents = hashMapOf<Char,Char>()
    private val allEdge = mutableListOf<Edge>()
    private val mstGraph = hashMapOf<Char, MutableSet<Edge>>()

    fun applyKruskalAlgorithm() {

        //Step 1: Extract all Edges
        graph.forEach {
            allEdge.addAll(it.value)
        }

        //Step 2: Sort Edges in Ascending Order by its weights
        allEdge.sortBy { it.weight }

        //Fill Each Node with itself as a parent
        graph.keys.forEach {
            parents[it] = it
        }

        fun find(char: Char): Char {
            if (char == parents[char]) return char
            parents[char] = find(parents[char]!!)
            return parents[char]!!
        }
        fun union(src: Char, dest: Char) {
            parents[find(dest)] = find(parents[src]!!)
        }

        fun addEdge(src: Char,dest: Char, weight: Int) {
            mstGraph[src] = mstGraph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest, weight)) }
        }
        allEdge.forEach {
            val srcParent = find(it.src)
            val destParent = find(it.dest)
            if (srcParent != destParent) {
                addEdge(it.src,it.dest,it.weight)
                union(srcParent,destParent)
            }
        }

        var sum = 0
        mstGraph.forEach {
            it.value.forEach {edge ->
                println("(${edge.src}) --${edge.weight}--> (${edge.dest})")
                sum += edge.weight
            }
        }

        println("Min Weight Sum: $sum")
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

//====================OUTPUT======================
[A] -> B, G, 
[B] -> A, G, C, 
[C] -> B, D, F, 
[D] -> C, E, F, 
[E] -> D, 
[F] -> C, D, G, 
[G] -> A, B, F, 
=====================
(A) --2--> (B)
(A) --3--> (G)
(C) --1--> (F)
(D) --2--> (E)
(D) --4--> (F)
(F) --2--> (G)
Min Weight Sum: 14
