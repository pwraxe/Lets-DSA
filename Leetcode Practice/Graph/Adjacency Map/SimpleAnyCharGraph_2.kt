//Target: Using Adjacency Hashmap, Create a Simple Graph, Read it, BFS, DFS
//Char as a Key, (CharGraph)

class CharGraph {
    private val graph = hashMapOf<Char, MutableSet<Char>>()

    fun addEdge(src:Char, dest:Char) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(dest) }
    }

    fun readGraph() {
        println(graph)
        graph.forEach { (key, value) ->
            println("$key -> ${value.toTypedArray().contentToString()}")
        }
    }

    fun bfs(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.poll()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun dfs(src: Char) {
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
}


fun main() {
    CharGraph().apply {
        addEdge('A','&')
        addEdge('A','4')

        addEdge('&','A')
        addEdge('&','4')
        addEdge('&','D')
        addEdge('&','8')

        addEdge('4','A')
        addEdge('4','&')
        addEdge('4','D')

        addEdge('D','4')
        addEdge('D','&')
        addEdge('D','8')

        addEdge('8','&')
        addEdge('8','D')

        readGraph()

        bfs('A')
        dfs('A')
    }
}

{A=[&, 4], 4=[A, &, D], D=[4, &, 8], &=[A, 4, D, 8], 8=[&, D]}
A -> [&, 4]
4 -> [A, &, D]
D -> [4, &, 8]
& -> [A, 4, D, 8]
8 -> [&, D]
BFS: [A, &, 4, D, 8]
DFS: [A, 4, D, 8, &]
