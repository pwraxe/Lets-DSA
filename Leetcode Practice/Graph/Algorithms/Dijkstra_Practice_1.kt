import java.util.ArrayDeque

data class Edge(val src:Char, val dest:Char, val weight: Int)

class Graph {

    private val MAX = 1000
    private val graph = hashMapOf<Char,MutableSet<Edge>>()
    fun addEdge(src: Char, dest: Char, weight: Int) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest, weight)) }
    }

    fun  readGraph() {
        graph.forEach {
            print("[${it.key}] -> ")
            it.value.forEach {
                print("[${it.src} --${it.weight}--> ${it.dest}], ")
            }
            println()
        }
    }

    fun applyDijkstraAlgorithm(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        val dijkstraGraph = hashMapOf<Char,Pair<Int,Char>>().also { map ->
            graph.keys.forEach {
                map[it] = map.getOrDefault(it, Pair(Int.MAX_VALUE,'.'))
            }
            map[src] = Pair(0,'.')
        }

        queue.offer(src)
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            if (front !in visited) visited.add(front)
            val currentPair = dijkstraGraph[front]!!
            graph[front]?.forEach {

                val destPair = dijkstraGraph[it.dest]!!

                if (currentPair.first + it.weight < destPair.first) {
                    dijkstraGraph[it.dest] = Pair(currentPair.first + it.weight,it.src)
                    queue.offer(it.dest)
                }
            }
        }

        dijkstraGraph.forEach { key, value ->
            println("[$key] --${value.first}--> ${value.second}")
        }
    }
}

fun main() {
    Graph().apply {
        addEdge('A','B',2)

        addEdge('B','G',1)
        addEdge('B','C',1)

        addEdge('C','A',1)
        addEdge('C','E',2)

        addEdge('D','C',3)

        addEdge('E','H',1)
        addEdge('E','F',2)

        addEdge('F','D',4)

        addEdge('G','I',2)
        addEdge('G','E',3)

        addEdge('H','G',2)

        addEdge('I','B',3)

        readGraph()

        println("\nDijkstra Graph: ")
        applyDijkstraAlgorithm('A')

    }
}


[A] -> [A --2--> B], 
[B] -> [B --1--> G], [B --1--> C], 
[C] -> [C --1--> A], [C --2--> E], 
[D] -> [D --3--> C], 
[E] -> [E --1--> H], [E --2--> F], 
[F] -> [F --4--> D], 
[G] -> [G --2--> I], [G --3--> E], 
[H] -> [H --2--> G], 
[I] -> [I --3--> B], 

Dijkstra Graph: 
[A] --0--> .
[B] --2--> A
[C] --3--> B
[D] --11--> F
[E] --5--> C
[F] --7--> E
[G] --3--> B
[H] --6--> E
[I] --5--> G
