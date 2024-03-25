import java.util.*



data class Edge(val src:Char, val dest:Char)
class Graph {
    private val graph = hashMapOf<Char,MutableSet<Edge>>()
    fun addEdge(src: Char, dest: Char) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest)) }
    }

    fun readGraph() {
        graph.forEach {
            print("[${it.key}] -> ")
            it.value.forEach {
                print("[${it.src} ---> ${it.dest}]")
            }
            println()
        }
    }

    val visited = mutableSetOf<Char>()
    fun topologicalSortByDFS(src: Char) {
        val edge = graph[src]
        if (edge?.size == 1 && edge.first().src == edge.first().dest) {
            if (src !in visited) visited.add(src)
            return
        }

        if (src in visited) return
        graph[src]?.forEach {
            topologicalSortByDFS(it.dest)
        }
        if (src !in visited) visited.add(src)
    }

    fun kahnAlgorithm(src: Char) {

        //Step1: Calculate In-Degree of all Vertices
        //Step2: Add All Vertices in Queue having in-degree 0, including source vertex
        //Step3: Loop: pop element from queue mark as visited, reduce edge count from inDegree

        val queue = ArrayDeque<Char>()
        val result = mutableSetOf<Char>()
        val inDegree = hashMapOf<Char,Int>()

        //Step1: Calculate In-Degree of all Vertices
        inDegree[src] = 0
        graph.forEach {
            it.value.forEach { edge ->
                inDegree[edge.dest] = inDegree.getOrDefault(edge.dest,0) + 1
            }
        }

        //Step2: Add All Vertices in Queue having in-degree 0, including source vertex
        for ((char,degree) in inDegree) {
            if (degree == 0) queue.offer(char)
        }

        //Step3: Loop: pop element from queue mark as visited, reduce edge count from inDegree
        while (queue.isNotEmpty()) {
            val char = queue.poll()
            result.add(char)

            graph[char]?.forEach {edge ->
                val degree = inDegree[edge.dest]!!
                if (degree > 0) {
                    inDegree[edge.dest] = degree - 1
                }
                if (inDegree[edge.dest] == 0) {
                    queue.offer(edge.dest)
                }

            }
        }

        println("Kahn Algo: ${result.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge('A','B')
        addEdge('A','D')

        addEdge('B','C')
        addEdge('B','D')

        addEdge('C','E')
        addEdge('C','F')

        addEdge('D','C')
        addEdge('D','E')

        addEdge('E','F')
        
        println("Reading Graph")
        readGraph()

        println("\nSimple Topological Sort")
        topologicalSortByDFS('A')
        println(visited.reversed().toTypedArray().contentToString())

        println("\nKahn Algorithm")
        kahnAlgorithm('A')
    }
}



Reading Graph
[A] -> [A ---> B][A ---> D]
[B] -> [B ---> C][B ---> D]
[C] -> [C ---> E][C ---> F]
[D] -> [D ---> C][D ---> E]
[E] -> [E ---> F]

Simple Topological Sort
[A, B, D, C, E, F]

Kahn Algorithm
Kahn Algo: [A, B, D, C, E, F]
