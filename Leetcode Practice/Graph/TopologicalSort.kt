import java.util.*

data class Edge(val src:Char, val dest:Char)
class Graph {
    private val graph = hashMapOf<Char,MutableSet<Edge>>()
    fun addEdge(src: Char, dest: Char) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(Edge(src, dest)) }
    }

    fun readGraph() {
        graph.forEach {
            print("[${it.key}] -> ")
            it.value.forEach {
                print("[${it.src} ---> ${it.dest}]")
            }
            println()
        }
    }

    val visited = mutableSetOf<Char>()
    fun topologicalSortByDFS(src: Char) {
        val edge = graph[src]
        if (edge?.size == 1 && edge.first().src == edge.first().dest) {
            if (src !in visited) visited.add(src)
            return
        }

        if (src in visited) return
        graph[src]?.forEach {
            topologicalSortByDFS(it.dest)
        }
        if (src !in visited) visited.add(src)
    }
}

fun main() {
    Graph().apply {
        addEdge('A','B')
        addEdge('A','D')

        addEdge('B','C')
        addEdge('B','D')

        addEdge('C','E')
        addEdge('C','F')

        addEdge('D','C')
        addEdge('D','E')

        addEdge('E','F')

        //addEdge('F','F')

        readGraph()

        topologicalSortByDFS('A')
        println(visited.reversed().toTypedArray().contentToString())
    }

    println("=======================")

    Graph().apply {

        addEdge('1','3')
        addEdge('1','6')

        addEdge('2','4')

        addEdge('3','5')

        addEdge('4','4')

        addEdge('5','2')
        addEdge('5','4')

        addEdge('6','2')

        readGraph()
        topologicalSortByDFS('1')
        println(visited.reversed().toTypedArray().contentToString())
    }
}


[A] -> [A ---> B][A ---> D]
[B] -> [B ---> C][B ---> D]
[C] -> [C ---> E][C ---> F]
[D] -> [D ---> C][D ---> E]
[E] -> [E ---> F]
[A, B, D, C, E, F]
=======================
[1] -> [1 ---> 3][1 ---> 6]
[2] -> [2 ---> 4]
[3] -> [3 ---> 5]
[4] -> [4 ---> 4]
[5] -> [5 ---> 2][5 ---> 4]
[6] -> [6 ---> 2]
[1, 6, 3, 5, 2, 4]
