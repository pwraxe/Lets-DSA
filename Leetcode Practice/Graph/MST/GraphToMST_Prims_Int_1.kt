import java.util.PriorityQueue

data class Edge(val src:Int, val dest:Int, val weight: Int)

class MstGraph {

    private val graph = hashMapOf<Int,MutableList<Edge>>()

    fun addEdge(src: Int, dest: Int, weight: Int) {
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

    fun applyPrimsAlgorithm(src: Int) {
        val visited = mutableSetOf<Int>()
        val priorityQueue = PriorityQueue<Edge> { a,b -> a.weight - b.weight }
        val mstGraph = mutableSetOf<Edge>()
        graph[src]?.forEach {
            priorityQueue.offer(it)
        }
        visited.add(src)
        while (priorityQueue.isNotEmpty()) {
            val edge = priorityQueue.poll()
            if (edge.dest !in visited) {
                mstGraph.add(edge)
                visited.add(edge.dest)
            }

            graph[edge.dest]?.forEach {
                if (it.dest !in visited) priorityQueue.offer(it)
            }
        }

        var weightedSum = 0
        mstGraph.forEach {
            println("(${it.src}) --${it.weight}--> (${it.dest})")
            weightedSum += it.weight
        }

        println("\nWeighted Sum: $weightedSum")
    }
}

fun main() {
    MstGraph().apply {
        addEdge(1,2,2)
        addEdge(1,7,3)

        addEdge(2,1,2)
        addEdge(2,7,3)
        addEdge(2,3,4)

        addEdge(3,2,4)
        addEdge(3,4,5)
        addEdge(3,6,1)

        addEdge(4,3,5)
        addEdge(4,5,2)
        addEdge(4,6,4)

        addEdge(5,4,2)

        addEdge(6,3,1)
        addEdge(6,4,4)
        addEdge(6,7,2)

        addEdge(7,1,3)
        addEdge(7,2,3)
        addEdge(7,6,2)

        readGraph()
        println("=====================")
        applyPrimsAlgorithm(1)
    }
}


[1] -> 2, 7, 
[2] -> 1, 7, 3, 
[3] -> 2, 4, 6, 
[4] -> 3, 5, 6, 
[5] -> 4, 
[6] -> 3, 4, 7, 
[7] -> 1, 2, 6, 
=====================
(1) --2--> (2)
(1) --3--> (7)
(7) --2--> (6)
(6) --1--> (3)
(6) --4--> (4)
(4) --2--> (5)

Weighted Sum: 14
