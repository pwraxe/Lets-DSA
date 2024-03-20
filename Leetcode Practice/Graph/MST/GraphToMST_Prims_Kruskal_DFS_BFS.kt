import java.util.ArrayDeque
import java.util.PriorityQueue
import java.util.Stack

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

    private val mstGraph = mutableListOf<Edge>()
    private val allEdges = mutableListOf<Edge>()
    private val parents  = hashMapOf<Char, Char>()

    private fun find(vertex:Char): Char {
        if (vertex == parents[vertex]) return vertex
        parents[vertex] = find(parents[vertex]!!)
        return parents[vertex]!!
    }
    private fun union(src:Char, dest:Char) {
        parents[find(src)] = find(dest)
    }
    fun applyKruskalAlgorithm() {

        graph.keys.forEach {
            parents[it] = it
        }
        graph.forEach {
            allEdges.addAll(it.value)
        }
        allEdges
            .sortedBy {
                it.weight
            }.forEach {
                val srcParent = find(it.src)
                val destParent = find(it.dest)
                if (srcParent != destParent) {
                    mstGraph.add(it)
                    union(srcParent,destParent)
                }
            }
        mstGraph.forEach {
            println("(${it.src}) --${it.weight}--> (${it.dest})")
        }
    }
    fun applyPrimsAlgorithm(src: Char) {
        val visited = mutableListOf<Char>()
        val pq = PriorityQueue<Edge> { a,b -> a.weight - b.weight }
        val mstGraph = mutableListOf<Edge>()
        graph[src]?.forEach {
            pq.offer(it)
        }
        visited.add(src)

        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (edge.dest !in visited) {
                visited.add(edge.dest)
                mstGraph.add(edge)
            }
            graph[edge.dest]?.forEach {
                if (it.dest !in visited) {
                    pq.offer(it)
                }
            }
        }

        var weightSum = 0
        mstGraph.forEach {
            println("(${it.src}) --${it.weight}--> (${it.dest})")
            weightSum += it.weight
        }

        println("\nMST Weight: $weightSum")
    }

    fun bfs(src: Char) {
        val visited = mutableListOf<Char>()
        val queue = ArrayDeque<Char>()
        queue.offer(src)

        while (queue.isNotEmpty()) {
            val front = queue.poll()
            if (front !in visited) {
                visited.add(front)
            }

            graph[front]?.forEach {
                if (it.dest !in visited) {
                    queue.offer(it.dest)
                }
            }
        }

        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun dfs(src: Char) {
        val visited = mutableListOf<Char>()
        val stack = Stack<Char>()
        stack.push(src)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (top !in visited) {
                visited.add(top)
            }

            graph[top]?.forEach {
                if (it.dest !in visited) {
                    stack.push(it.dest)
                }
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    MstGraph().apply {

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

        println("\nPrims-Algo=====================")
        applyPrimsAlgorithm('A')
        bfs('A')
        dfs('A')

        println("\nKruskal Algo=====================")
        applyKruskalAlgorithm()
    }
}






//====================OUTPUT===================
Reading Graph ===========================
[A] -> A --2--> B, A --3--> G, 
[B] -> B --2--> A, B --3--> G, B --4--> C, 
[C] -> C --4--> B, C --5--> D, C --1--> F, 
[D] -> D --5--> C, D --2--> E, D --4--> F, 
[E] -> E --2--> D, 
[F] -> F --1--> C, F --4--> D, F --2--> G, 
[G] -> G --3--> A, G --3--> B, G --2--> F, 

Prims-Algo=====================
(A) --2--> (B)
(A) --3--> (G)
(G) --2--> (F)
(F) --1--> (C)
(F) --4--> (D)
(D) --2--> (E)

MST Weight: 14
BFS: [A, B, G, C, F, D, E]
DFS: [A, G, F, D, E, C, B]

Kruskal Algo=====================
(C) --1--> (F)
(A) --2--> (B)
(D) --2--> (E)
(F) --2--> (G)
(A) --3--> (G)
(D) --4--> (F)
