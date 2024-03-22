import java.util.ArrayDeque

data class Edge(val src: Int, val dest:Int, val weight: Int)
class BellmanGraph {
     private val graph = hashMapOf<Int,MutableSet<Edge>>()
    fun addEdge(src: Int, dest: Int, weight: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest, weight)) }
    }

    fun readGraph() {
        graph.forEach {
            print("[${it.key}] --> ")
            it.value.forEach {
                print("[${it.src}] --(${it.weight})--> [${it.dest}], ")
            }
            println()
        }
    }

    fun applyBellmanFordAlgorithm(src: Int) {
        val allEdge = mutableSetOf<Edge>()
        graph.values.forEach {
            allEdge.addAll(it)
        }
        val bellmanGraph = hashMapOf<Int,Pair<Int,Int>>().also {map ->
            graph.keys.forEach {
                map[it] = Pair(Int.MAX_VALUE,-1)
            }
            map[src] = Pair(0,0)
        }

        for (i in graph.keys.size downTo 0) {
            var isChange = false
            allEdge.forEach {
                if (bellmanGraph[it.src]!!.first + it.weight < bellmanGraph[it.dest]!!.first) {
                    bellmanGraph[it.dest] = Pair(bellmanGraph[it.src]!!.first + it.weight,it.src)
                    isChange = true
                }
            }
            if (!isChange) break
        }

        bellmanGraph.forEach {
            //println("[${it.value.second}] --${it.value.first}--> [${it.key}]")
            println("[${it.key}] = ${it.value.first}")
        }
    }

    fun applyBellmanFordBySPFA(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        val bellMan = IntArray(graph.keys.size) { Int.MAX_VALUE }
        queue.offer(src)
        bellMan[src] = 0

        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            graph[vertex]?.forEach {

                if (bellMan[it.src] + it.weight < bellMan[it.dest]) {
                    bellMan[it.dest] = bellMan[it.src] + it.weight
                    if (it.dest !in queue) queue.offer(it.dest)
                }
            }
        }

        println(bellMan.toTypedArray().contentToString())
    }
}

fun main() {
    BellmanGraph().apply {

        addEdge(0,1,100)
        addEdge(0,2,500)
        addEdge(0,3,200)

        addEdge(1,2,100)

        addEdge(2,3,100)

        addEdge(3,1,-150)

        readGraph()

        println("Bellman Ford By Optimization")
        applyBellmanFordAlgorithm(0)

        println("Bellman Ford By SPFA (Shortest Path Faster Algorithm)")
        applyBellmanFordBySPFA(0)
    }
}


[0] --> [0] --(100)--> [1], [0] --(500)--> [2], [0] --(200)--> [3], 
[1] --> [1] --(100)--> [2], 
[2] --> [2] --(100)--> [3], 
[3] --> [3] --(-150)--> [1], 
Bellman Ford By Optimization
[0] = 0
[1] = 50
[2] = 150
[3] = 200
Bellman Ford By SPFA (Shortest Path Faster Algorithm)
[0, 50, 150, 200]
