import java.util.PriorityQueue

data class Edge(val src:Char, val dest: Char, val weight:Int = 0)
class KruskalCharGraph {
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
    
    fun applyKruskalAlgorithm(src: Char) {
        val allEdges = mutableSetOf<Edge>()
        val kruskalGraph = mutableSetOf<Edge>()
        val parents = hashMapOf<Char,Char>()

        fun find(src: Char): Char {
            if (src == parents[src]) return src
            parents[src] = find(parents[src]!!)
            return parents[src]!!
        }
        fun union(src: Char, dest: Char) {
            parents[dest] = src
        }

        graph.keys.forEach { parents[it] = it }
        graph.values.forEach { allEdges.addAll(it) }
        allEdges
            .sortedBy { it.weight }
            .forEach {
                val srcParent = find(it.src)
                val destParent = find(it.dest)
                if (srcParent != destParent) {
                    kruskalGraph.add(it)
                    union(srcParent,destParent)
                }
            }

        var sum = 0
        kruskalGraph.forEach {
            println("[${it.src}] --${it.weight}--> [${it.dest}]")
            sum += it.weight
        }
        println("\nWeight Sum: $sum")
    }
    fun applyKruskalAlgorithm2(src: Char) {
        val kruskalGraph = mutableSetOf<Edge>()
        val priorityQueue = PriorityQueue<Edge>  { a, b -> a.weight - b.weight }
        val parents = hashMapOf<Char,Char>().also { map ->
            graph.keys.forEach { map[it] = it }
        }
        var vertices = graph.keys.size-1

        fun find(src: Char): Char {
            if (src == parents[src]) return src
            parents[src] = find(parents[src]!!)
            return parents[src]!!
        }
        fun union(src: Char,dest: Char) {
            parents[dest] = src
        }
        graph.values.forEach {
            priorityQueue.addAll(it)
        }

        while (vertices > 0 && priorityQueue.isNotEmpty()) {
            val edge = priorityQueue.poll()
            val srcParent = find(edge.src)
            val destParent = find(edge.dest)
            if (srcParent != destParent) {
                union(srcParent,destParent)
                kruskalGraph.add(edge)
                vertices--
            }
        }

        var sum = 0
        kruskalGraph.forEach {
            println("[${it.src}] --${it.weight}--> [${it.dest}]")
            sum += it.weight
        }
        println("\nWeight Sum: $sum")

        println("\nUnused Edges: (Following ${priorityQueue.size} Edges/Iteration we saved by checking adding V-1 Vertices)")
        while (priorityQueue.isNotEmpty()) {
            val unUsedEdge = priorityQueue.poll()
            println("[${unUsedEdge.src}] --${unUsedEdge.weight}--> [${unUsedEdge.dest}]")
        }
    }
}

fun main() {
    KruskalCharGraph().apply {
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

        println("\nApplying Kruskal's Algorithm")
        applyKruskalAlgorithm('A')

        println("\nApplying Kruskal's Algorithm Way 2")
        applyKruskalAlgorithm2('A')
    }
}


//====================OUTPUT===========================
[A] --> (A) --2--> (B)(A) --3--> (G)
[B] --> (B) --2--> (A)(B) --3--> (G)(B) --4--> (C)
[C] --> (C) --4--> (B)(C) --5--> (D)(C) --1--> (F)
[D] --> (D) --5--> (C)(D) --2--> (E)(D) --4--> (F)
[E] --> (E) --2--> (D)
[F] --> (F) --1--> (C)(F) --4--> (D)(F) --2--> (G)
[G] --> (G) --3--> (A)(G) --3--> (B)(G) --2--> (F)

Applying Kruskal's Algorithm
[C] --1--> [F]
[A] --2--> [B]
[D] --2--> [E]
[F] --2--> [G]
[A] --3--> [G]
[D] --4--> [F]

Weight Sum: 14

Applying Kruskal's Algorithm Way 2
[C] --1--> [F]
[A] --2--> [B]
[G] --2--> [F]
[D] --2--> [E]
[G] --3--> [B]
[F] --4--> [D]

Weight Sum: 14

Unused Edges: (Following 5 Edges/Iteration we saved by checking adding V-1 Vertices)
[B] --4--> [C]
[D] --4--> [F]
[C] --4--> [B]
[D] --5--> [C]
[C] --5--> [D]
