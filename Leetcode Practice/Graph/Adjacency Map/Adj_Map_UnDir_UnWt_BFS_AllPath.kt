import java.util.ArrayDeque

//Build Graph, BFS Traverse, All Paths

class Graph {

    private val graph = hashMapOf<Char, MutableList<Char>>()
    fun addEdge(src: Char, dest: Char) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(dest) }
    }

    fun readGraph(){
        graph.forEach { key, value ->
            println("[$key] -> ${value.toTypedArray().contentToString()}")
        }
    }
    fun bfs(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val front = queue.poll()
            visited.add(front)
            graph[front]?.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }

        println("BFS: ${visited.toTypedArray().contentToString()}")
    }

    fun getAllPaths(src: Char, dest: Char) {
        val allPaths = mutableListOf<List<Char>>()
        val visited = mutableSetOf<Char>()
        val queue = ArrayDeque<MutableSet<Char>>()
        queue.offer(mutableSetOf<Char>().also { it.add(src) })

        while (queue.isNotEmpty()) {
            val currentPath = queue.poll()
            val lastNode = currentPath.last()
            visited.add(lastNode)

            if (lastNode == dest) {
                allPaths.add(currentPath.toList())
            }

            graph[currentPath.last()]?.forEach { char ->
                if (!currentPath.contains(char)) {
                    currentPath.add(char)
                    queue.offer(mutableSetOf<Char>().also { it.addAll(currentPath) })
                    currentPath.remove(char)
                }
            }
        }
        println("All Paths are:")

        allPaths.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
}

fun main() {
    Graph().apply {
        addEdge('A','B')
        addEdge('A','E')

        addEdge('B','A')
        addEdge('B','C')
        addEdge('B','E')

        addEdge('C','B')
        addEdge('C','D')
        addEdge('C','F')

        addEdge('D','C')
        addEdge('D','F')

        addEdge('E','A')
        addEdge('E','B')
        addEdge('E','F')

        addEdge('F','C')
        addEdge('F','E')
        addEdge('F','D')

        readGraph()
        bfs('A')

        getAllPaths('A','D')
    }
}

//Output

[A] -> [B, E]
[B] -> [A, C, E]
[C] -> [B, D, F]
[D] -> [C, F]
[E] -> [A, B, F]
[F] -> [C, E, D]
BFS: [A, B, E, C, F, D]
All Paths are:
[A, B, C, D]
[A, E, F, D]
[A, B, C, F, D]
[A, B, E, F, D]
[A, E, B, C, D]
[A, E, F, C, D]
[A, B, E, F, C, D]
[A, E, B, C, F, D]
