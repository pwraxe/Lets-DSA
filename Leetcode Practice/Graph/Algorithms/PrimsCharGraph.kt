import java.util.PriorityQueue

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

    fun applyPrimsAlgorithm(src: Char) {
        val priorityQueue = PriorityQueue<Edge> { a,b -> a.weight - b.weight }
        val visited = mutableSetOf<Char>()
        val primsGraph = mutableSetOf<Edge>()

        graph[src]?.forEach {
            priorityQueue.offer(it)
        }
        visited.add(src)
        while (priorityQueue.isNotEmpty()) {
            val edge = priorityQueue.poll()
            if (edge.dest !in visited) {
                visited.add(edge.dest)
                primsGraph.add(edge)
            }

            graph[edge.dest]?.forEach {
                if (it.dest !in visited) {
                    priorityQueue.offer(it)
                }
            }
        }

        var weightSum = 0
        primsGraph.forEach {
            println("[${it.src}] --${it.weight}--> [${it.dest}]")
            weightSum += it.weight
        }

        println("\nMST of Prims Weight: $weightSum")
    }
}

fun main() {
    PrimsCharGraph().apply {
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

        println("\nApplying Prims's Algorithm")
        applyPrimsAlgorithm('A')
    }
}

//======================OUTPUT==============================
[A] --> (A) --2--> (B)(A) --3--> (G)
[B] --> (B) --2--> (A)(B) --3--> (G)(B) --4--> (C)
[C] --> (C) --4--> (B)(C) --5--> (D)(C) --1--> (F)
[D] --> (D) --5--> (C)(D) --2--> (E)(D) --4--> (F)
[E] --> (E) --2--> (D)
[F] --> (F) --1--> (C)(F) --4--> (D)(F) --2--> (G)
[G] --> (G) --3--> (A)(G) --3--> (B)(G) --2--> (F)

Applying Prims's Algorithm
[A] --2--> [B]
[A] --3--> [G]
[G] --2--> [F]
[F] --1--> [C]
[F] --4--> [D]
[D] --2--> [E]

MST of Prims Weight: 14
