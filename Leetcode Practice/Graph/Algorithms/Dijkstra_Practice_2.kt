import java.util.ArrayDeque

data class Edge(val src:Char, val dest: Char, val weight:Int = 0)
class PrimsCharGraph {
    private val graph = hashMapOf<Char, MutableSet<Edge>>()

    fun addEdge(src: Char, dest: Char,weight: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest, weight)) }
    }

    fun readGraph() {
        graph.forEach {
            print("[${it.key}] --> ")
            it.value.forEach {
                print("(${it.src}) --${it.weight}--> (${it.dest})")
            }
            println()
        }
    }

    fun applyDijkstraAlgorithm(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        val dijTable = hashMapOf<Char,Pair<Int,Char>>().also { table ->
            graph.forEach {
                table[it.key] = Pair(Int.MAX_VALUE,'.')
            }
            table[src] = Pair(0,'.')
        }

        queue.offer(src)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            if (vertex !in visited) visited.add(vertex)
            graph[vertex]?.forEach {
                if (dijTable[it.src]!!.first + it.weight < dijTable[it.dest]!!.first) {
                    dijTable[it.dest] = Pair(dijTable[it.src]!!.first + it.weight, it.src)
                    queue.offer(it.dest)
                }
            }
        }

        dijTable.forEach {
            println("[${it.value.second}] --${it.value.first}--> [${it.key}]")
        }
    }
}

fun main() {
    PrimsCharGraph().apply {
        addEdge('A','B',2)
        addEdge('A','G',3)

        addEdge('B','G',2)
        addEdge('B','C',3)

        addEdge('C','D',2)


        addEdge('D','E',1)
        addEdge('D','F',3)

        addEdge('E','E',0)

        addEdge('F','C',3)
        
        addEdge('G','F',2)

        readGraph()

        println("\nApplying Dijkstra's Algorithm")
        applyDijkstraAlgorithm('A')
    }
}



[A] --> (A) --2--> (B)(A) --3--> (G)
[B] --> (B) --2--> (G)(B) --3--> (C)
[C] --> (C) --2--> (D)
[D] --> (D) --1--> (E)(D) --3--> (F)
[E] --> (E) --0--> (E)
[F] --> (F) --3--> (C)
[G] --> (G) --2--> (F)

Applying Dijkstra's Algorithm
[.] --0--> [A]
[A] --2--> [B]
[B] --5--> [C]
[C] --7--> [D]
[D] --8--> [E]
[G] --5--> [F]
[A] --3--> [G]
