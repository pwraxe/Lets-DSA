data class Edge(val src:Int, val dest: Int, val weight:Int)
class Graph {
    private val graph = hashMapOf<Int,MutableSet<Edge>>()

    fun addEdge(src:Int, dest: Int, weight: Int = 0) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also {
            it.add(Edge(src, dest, weight))
        }
    }

    fun readGraph() {
        graph.forEach { (key, value) ->
            value.forEach {
                print("${it.src} --${it.weight}--> ${it.dest}, ")
            }
            println()
        }
        println("======================================================================")
        graph.forEach {(key, value) ->
            println("$key --> ${value.toTypedArray().contentToString()}")
        }
    }

    fun dfs(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it.dest)) stack.push(it.dest)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
    fun bfs(src: Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.poll()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it.dest)) queue.offer(it.dest)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge(1,2, 4)

        addEdge(2,3,9)
        addEdge(2,4,7)

        addEdge(3,1,6)
        addEdge(3,5,8)

        addEdge(4,3,5)
        addEdge(4,5,7)

        addEdge(5,2,3)
        addEdge(5,6,11)

        addEdge(6,4,16)

        readGraph()
        println("=====================================")
        dfs(1)
        bfs(1)
    }
}


1 --4--> 2, 
2 --9--> 3, 2 --7--> 4, 
3 --6--> 1, 3 --8--> 5, 
4 --5--> 3, 4 --7--> 5, 
5 --3--> 2, 5 --11--> 6, 
6 --16--> 4, 
======================================================================
1 --> [Edge(src=1, dest=2, weight=4)]
2 --> [Edge(src=2, dest=3, weight=9), Edge(src=2, dest=4, weight=7)]
3 --> [Edge(src=3, dest=1, weight=6), Edge(src=3, dest=5, weight=8)]
4 --> [Edge(src=4, dest=3, weight=5), Edge(src=4, dest=5, weight=7)]
5 --> [Edge(src=5, dest=2, weight=3), Edge(src=5, dest=6, weight=11)]
6 --> [Edge(src=6, dest=4, weight=16)]
=====================================
DFS: [1, 2, 4, 5, 6, 3]
BFS: [1, 2, 3, 4, 5, 6]
