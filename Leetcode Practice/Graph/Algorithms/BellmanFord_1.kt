data class Edge(val src: Int, val dest:Int, val weight: Int)

class BellmanGraph {
    private val graph = hashMapOf<Int,MutableSet<Edge>>()
    fun addEdge(src: Int, dest: Int, weight: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest, weight)) }
    }

    fun readGraph() {
        println("==========Reading Graph=========")
        graph.forEach {
            print("[${it.key}] -> ")
            it.value.forEach {
                print("(${it.src}) --${it.weight}--> (${it.dest}), ")
            }
            println()
        }
    }

    fun applyBellmanAlgorithm(src: Int) {
        val allEdges = mutableSetOf<Edge>()
        val bellManGraph = hashMapOf<Int,Int>().also { map ->
            graph.keys.forEach {
                map[it] = Int.MAX_VALUE
            }
            map[src] = 0
        }
        graph.values.forEach {
            allEdges.addAll(it)
        }

        val vertex = graph.keys.size
        for (i in vertex downTo 0) {
            var isChange = false

            allEdges.forEach {
                val currentNode = bellManGraph[it.src]!!
                val destNode = bellManGraph[it.dest]!!
                if (currentNode + it.weight < destNode) {
                    bellManGraph[it.dest] = currentNode + it.weight
                    isChange = true
                }
            }
            if (!isChange) break
        }

        bellManGraph.forEach {
            println("${it.key} | ${it.value}")
        }
    }
}

fun main() {
    BellmanGraph().apply {
        addEdge(1,2,6)
        addEdge(1,3,5)
        addEdge(1,4,5)

        addEdge(2,5,-1)

        addEdge(3,2,-2)
        addEdge(3,5,1)

        addEdge(4,3,-2)
        addEdge(4,6,-1)

        addEdge(5,7,3)

        addEdge(6,7,3)

        addEdge(7,7,0)

        readGraph()

        println("===============Bellman==============")
        applyBellmanAlgorithm(1)
    }

    println("========================================================")
    BellmanGraph().apply {
        addEdge(0,3,8)
        addEdge(0,2,5)
        addEdge(0,1,4)

        addEdge(1,2,-3)

        addEdge(2,4,4)

        addEdge(3,4,2)

        addEdge(4,3,1)
        
        readGraph()
        
        println()
        applyBellmanAlgorithm(0)
    }
}

==========Reading Graph=========
[1] -> (1) --6--> (2), (1) --5--> (3), (1) --5--> (4), 
[2] -> (2) ---1--> (5), 
[3] -> (3) ---2--> (2), (3) --1--> (5), 
[4] -> (4) ---2--> (3), (4) ---1--> (6), 
[5] -> (5) --3--> (7), 
[6] -> (6) --3--> (7), 
[7] -> (7) --0--> (7), 
===============Bellman==============
1 | 0
2 | 1
3 | 3
4 | 5
5 | 0
6 | 4
7 | 3
========================================================
==========Reading Graph=========
[0] -> (0) --8--> (3), (0) --5--> (2), (0) --4--> (1), 
[1] -> (1) ---3--> (2), 
[2] -> (2) --4--> (4), 
[3] -> (3) --2--> (4), 
[4] -> (4) --1--> (3), 

0 | 0
1 | 4
2 | 1
3 | 6
4 | 5
