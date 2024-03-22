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

    fun applyBellmanFordAlgorithm(src: Char) {
        val allEdges = mutableSetOf<Edge>()
        val bellGraph = hashMapOf<Char,Pair<Int,Char>>().also { map ->
            graph.keys.forEach {
                map[it] = Pair(Int.MAX_VALUE,'.')
            }
            map[src] = Pair(0,'.')
        }

        graph.values.forEach {
            allEdges.addAll(it)
        }
        for (i in graph.keys.size downTo 0) {
            var isChange = false
            allEdges.forEach {
                if (bellGraph[it.src]!!.first + it.weight < bellGraph[it.dest]!!.first) {
                    bellGraph[it.dest] = Pair(bellGraph[it.src]!!.first + it.weight,it.src)
                    isChange = true
                }
            }
            if (!isChange) break
        }

        bellGraph.forEach {
            println("[${it.value.second}] --(${it.value.first})--> [${it.key}]")
        }
    }
}

fun main() {
    PrimsCharGraph().apply {
        addEdge('A','B',2)
        addEdge('A','G',3)

        addEdge('B','G',-2)
        addEdge('B','C',3)

        addEdge('C','D',-2)


        addEdge('D','E',-1)
        addEdge('D','F',3)

        addEdge('E','E',0)

        addEdge('F','C',3)

        addEdge('G','F',-2)

        readGraph()

        println("\nApplying Bellman's Algorithm")
        applyBellmanFordAlgorithm('A')

    }
}



//=================OUTPUT======================
[A] --> (A) --2--> (B)(A) --3--> (G)
[B] --> (B) ---2--> (G)(B) --3--> (C)
[C] --> (C) ---2--> (D)
[D] --> (D) ---1--> (E)(D) --3--> (F)
[E] --> (E) --0--> (E)
[F] --> (F) --3--> (C)
[G] --> (G) ---2--> (F)

Applying Bellman's Algorithm
[.] --(0)--> [A]
[A] --(2)--> [B]
[F] --(1)--> [C]
[C] --(-1)--> [D]
[D] --(-2)--> [E]
[G] --(-2)--> [F]
[B] --(0)--> [G]
