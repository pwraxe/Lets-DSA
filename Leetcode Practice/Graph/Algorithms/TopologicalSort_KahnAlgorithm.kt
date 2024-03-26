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
    fun topologicalSort(src: Char) {
        if (graph[src] == null) {
            visited.add(src)
            return
        }

        if (src in visited) return
        graph[src]?.forEach {
            if (it.dest !in visited) topologicalSort(it.dest)
        }
        visited.add(src)
    }
    fun kahnAlgorithm(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        val inDegrees = hashMapOf<Char,Int>()
        graph.values.forEach {
            for ((from, dest) in it) {
                inDegrees[dest] = inDegrees.getOrDefault(dest,0) + 1
            }
        }
        inDegrees[src] = 0

        inDegrees.forEach {
            if (it.value == 0) queue.offer(it.key)
        }

        while (queue.isNotEmpty()) {
            val char = queue.poll()
            visited.add(char)
            graph[char]?.forEach {
                //1] Read Dest Degree
                val degree = inDegrees[it.dest] ?: 0

                //2] Reduce by 1, Update
                inDegrees[it.dest] = degree-1

                //3] Add in queue if degree is 0
                if (degree-1 == 0) queue.offer(it.dest)
            }
        }

        println("Kahn's Algorithm: ${visited.toTypedArray().contentToString()}")

    }

    //====================================================================================
    val visited2 = mutableSetOf<Char>()
    fun topologicalSort2(src: Char) {
        val edge = graph[src]
        if (edge?.size == 1 && edge.first().src == edge.first().dest) {
            if (src !in visited) visited.add(src)
            return
        }

        if (src in visited) return
        graph[src]?.forEach {
            topologicalSort2(it.dest)
        }
        if (src !in visited) visited.add(src)
    }
    fun kahnAlgorithm2(src: Char) {

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

        println("Kahn Algo2: ${result.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {

        addEdge('A','B')
        addEdge('A','E')

        addEdge('B','C')
        addEdge('B','E')

        addEdge('C','D')
        addEdge('E','F')

        addEdge('F','C')
        addEdge('F','D')

        println("Reading Graph")
        readGraph()

        println("=================================")

        println("\nTopological Sort: ")
        topologicalSort('A')

        println(visited.reversed().toTypedArray().contentToString())
        kahnAlgorithm('A')

        println("=================================")

        println("\nTopological Sort2: ")
        topologicalSort2('A')
        println(visited.reversed().toTypedArray().contentToString())
        kahnAlgorithm2('A')
    }
}



Reading Graph
[A] -> [A ---> B][A ---> E]
[B] -> [B ---> C][B ---> E]
[C] -> [C ---> D]
[E] -> [E ---> F]
[F] -> [F ---> C][F ---> D]
=================================

Topological Sort: 
[A, B, E, F, C, D]
Kahn's Algorithm: [A, B, E, F, C, D]
=================================

Topological Sort2: 
[A, B, E, F, C, D]
Kahn Algo2: [A, B, E, F, C, D]
