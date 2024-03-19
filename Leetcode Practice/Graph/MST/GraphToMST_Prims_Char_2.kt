import java.util.PriorityQueue

/*
* Todo,
*  -Make Graph, Read it,
*  - Understand Kruskal's and Prims Algorithms from YouTube or Anywhere,
*  - Implement your own,then
*  -
*  - Convert Graph in Kruskal's Algorithm, Read it (Int Vertex)
*  - Convert Graph in Kruskal's Algorithm, Read it (Char Vertex)
*  -
*  - Convert Graph in Prims Algorithm, Read it (Int Vertex)
*  - Convert Graph in Prims Algorithm, Read it (Char Vertex)
*
* */
data class Edge(val src:Char, val dest: Char, val weight: Int)
class MstGraph {

    private val graph = hashMapOf<Char,MutableList<Edge>>()
    fun addEdge(src:Char, dest: Char, weight:Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest, weight)) }
    }
    fun readGraph() {
        graph.forEach { (k,v) ->
            print("[$k] -> ")
            v.forEach {
                print("${it.src} --${it.weight}--> ${it.dest}, ")
            }
            println()
        }
    }

    fun applyPrimsAlgorithm(src: Char) {
        val visited = mutableListOf<Char>()
        val pq = PriorityQueue<Edge> { a,b -> a.weight - b.weight }
        val mstGraph = mutableListOf<Edge>()
        graph[src]?.forEach {
            pq.offer(it)
        }
        visited.add(src)

        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (edge.dest !in visited) {
                visited.add(edge.dest)
                mstGraph.add(edge)
            }
            graph[edge.dest]?.forEach {
                if (it.dest !in visited) {
                    pq.offer(it)
                }
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
        applyPrimsAlgorithm('A')
    }
}


[A] -> A --2--> B, A --3--> G, 
[B] -> B --2--> A, B --3--> G, B --4--> C, 
[C] -> C --4--> B, C --5--> D, C --1--> F, 
[D] -> D --5--> C, D --2--> E, D --4--> F, 
[E] -> E --2--> D, 
[F] -> F --1--> C, F --4--> D, F --2--> G, 
[G] -> G --3--> A, G --3--> B, G --2--> F, 
=====================
(A) --2--> (B)
(A) --3--> (G)
(G) --2--> (F)
(F) --1--> (C)
(F) --4--> (D)
(D) --2--> (E)

MST Weight: 14
