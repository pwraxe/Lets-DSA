//Dijkstra Algorithm works on Directed, Positive weighted, Graph

import java.util.ArrayDeque

data class Edge(val src:Char, val dest: Char, val weight: Int)

class MstGraph {

    private val graph = hashMapOf<Char,MutableList<Edge>>()
    fun addEdge(src:Char, dest: Char, weight:Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest, weight)) }
    }
    fun readGraph() {
        println("Reading Graph ===========================")
        graph.forEach { (k,v) ->
            print("[$k] -> ")
            v.forEach {
                print("${it.src} --${it.weight}--> ${it.dest}, ")
            }
            println()
        }
    }
    
    fun applyDijkstraAlgorithm(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableListOf<Char>()
        val dijGraph = hashMapOf<Char, Pair<Int,Char?>>().also {
            it[src] = Pair(0,null)
            graph.keys.forEach { char ->
                it[char] = it.getOrDefault(char,Pair(Int.MAX_VALUE,null))
            }
        }

        queue.offer(src)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            if (vertex !in visited) visited.add(vertex)

            val currentPair = dijGraph[vertex]!!
            graph[vertex]?.forEach {
                val destPair = dijGraph[it.dest]!!
                if (destPair.first == Int.MAX_VALUE) {
                    dijGraph[it.dest] = Pair(currentPair.first + it.weight, it.src)
                    queue.offer(it.dest)
                } else {
                    if (currentPair.first + it.weight < destPair.first) {
                        dijGraph[it.dest] = Pair(currentPair.first + it.weight, it.src)
                        queue.offer(it.dest)
                    }
                }
            }
        }

        var weightSum = 0
        println("Dij Graph: ")
        dijGraph.forEach {
            println("[${it.key}] --${it.value.first}--> ${it.value.second}")
            weightSum += it.value.first
        }

        println("\nWeight Sum: $weightSum")
    }
}

fun main() {
    MstGraph().apply {

        addEdge('A','B',2)

        addEdge('B','C',4)
        addEdge('B','F',3)

        addEdge('C','D',8)

        addEdge('D','E',5)

        addEdge('E','C',6)

        addEdge('F','A',5)
        addEdge('F','E',1)

        readGraph()

        applyDijkstraAlgorithm('A')
    }
}


Reading Graph ===========================
[A] -> A --2--> B, 
[B] -> B --4--> C, B --3--> F, 
[C] -> C --8--> D, 
[D] -> D --5--> E, 
[E] -> E --6--> C, 
[F] -> F --5--> A, F --1--> E, 
Dij Graph: 
[A] --0--> null
[B] --2--> A
[C] --6--> B
[D] --14--> C
[E] --6--> F
[F] --5--> B

Weight Sum: 33
