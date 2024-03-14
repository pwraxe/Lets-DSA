import java.util.ArrayDeque
import java.util.Queue
import java.util.Stack

//Build Graph, BFS Traverse
class Graph {

    private val graph = hashMapOf<Char, MutableList<Char>>()
    fun addEdge(src: Char, dest: Char) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(dest) }
    }

    fun readGraph() {
        println("Reading Graph Data: ")
        graph.forEach { key, value ->
            println("[$key] -> ${value.toTypedArray().contentToString()}")
        }
        println()
    }
    fun bfs_ByIteration(src: Char) {

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

        println("BFS By Iteration: ${visited.toTypedArray().contentToString()}")
    }
    fun bfs_ByRecursion(visited: MutableSet<Char>, queue: Queue<Char>) {
        if (queue.isEmpty()) {
            println("BFS By Recursion: ${visited.toTypedArray().contentToString()}")
            return
        }
        val front = queue.poll()
        visited.add(front)

        graph[front]?.forEach {
            if (it !in visited) {
                queue.offer(it)
            }
        }
        bfs_ByRecursion(visited, queue)
    }
    fun bfs_allPaths_Iteration(src: Char, dest: Char) {
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
        println("\nAll Paths by BFS by Iteration are:")
        allPaths.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
    fun bfs_allPaths_Recursion(dest: Char, visited: MutableSet<Char>, queue: Queue<MutableList<Char>>) {
        if (queue.isEmpty()) return

        val path = queue.poll()
        visited.add(path.last())
        if (path.last() == dest) {
            println("Path: ${path.toTypedArray().contentToString()} | Visited: ${visited.toTypedArray().contentToString()}")
        }
        graph[path.last()]?.forEach {
            if (it !in path) {
                path.add(it)
                queue.offer(path.toMutableList())
                path.remove(it)
            }
        }
        bfs_allPaths_Recursion(dest, visited, queue)
    }

    //=========================================================================================================

    fun dfs_byIteration(src: Char) {
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()
        stack.push(src)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top]?.forEach {
                if (it !in visited) { stack.push(it) }
            }
        }
        println("DFS By Iteration: ${visited.toTypedArray().contentToString()}")
    }

    val dfsVisited = mutableSetOf<Char>()
    fun dfs_byRecursion(src: Char){
        dfsVisited.add(src)
        graph[src]?.forEach {
            if (it !in dfsVisited) dfs_byRecursion(it)
        }
    }
    fun dfs_allPathsIteration(src: Char, dest: Char) {
        val stack = Stack<MutableList<Char>>()
        val visited = mutableSetOf<Char>()
        val allPaths = mutableListOf<List<Char>>()
        stack.push(mutableListOf<Char>().also { it.add(src) })

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top.last())
            if (top.last() == dest) {
                allPaths.add(top.toList())
            }
            graph[top.last()]?.forEach {
                if (it !in top) {
                    top.add(it)
                    stack.push(top.toMutableList())
                    top.remove(it)
                }
            }
        }

        println("\nAll Paths are by DFS Iteration: ")
        allPaths.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
    fun dfs_allPathsRecursion(src: Char, dest: Char,
                              visited:MutableSet<Char>,
                              currentPath: MutableSet<Char>) {
        if (src == dest) {
            println(currentPath.toTypedArray().contentToString())
            return
        }

        graph[src]?.forEach {
            if (it !in visited) {
                visited.add(src)
                currentPath.add(it)
                dfs_allPathsRecursion(it,dest,visited, currentPath)
                currentPath.remove(it)
                visited.remove(src)
            }
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
        bfs_ByIteration('A')
        bfs_ByRecursion(mutableSetOf(),ArrayDeque<Char>().also { it.add('A') })
        bfs_allPaths_Iteration('A','D')

        println("\nAll Path By BFS Recursion")
        bfs_allPaths_Recursion(
            dest = 'D', visited = mutableSetOf('A'),
            queue = ArrayDeque<MutableList<Char>>().also { it.offer(mutableListOf('A')) })


        println("\n==================================================================================")

        dfs_byIteration('A')
        dfs_byRecursion('A')
        println("DFS By Recursion: ${dfsVisited.toTypedArray().contentToString()}")
        dfs_allPathsIteration('A','D')
        println("\nDFS All Path By Recursion: ")
        dfs_allPathsRecursion('A','D', mutableSetOf(), mutableSetOf('A'))
    }
}

Reading Graph Data: 
[A] -> [B, E]
[B] -> [A, C, E]
[C] -> [B, D, F]
[D] -> [C, F]
[E] -> [A, B, F]
[F] -> [C, E, D]

BFS By Iteration: [A, B, E, C, F, D]
BFS By Recursion: [A, B, E, C, F, D]

All Paths by BFS by Iteration are:
[A, B, C, D]
[A, E, F, D]
[A, B, C, F, D]
[A, B, E, F, D]
[A, E, B, C, D]
[A, E, F, C, D]
[A, B, E, F, C, D]
[A, E, B, C, F, D]

All Path By BFS Recursion
Path: [A, B, C, D] | Visited: [A, B, E, C, F, D]
Path: [A, E, F, D] | Visited: [A, B, E, C, F, D]
Path: [A, B, C, F, D] | Visited: [A, B, E, C, F, D]
Path: [A, B, E, F, D] | Visited: [A, B, E, C, F, D]
Path: [A, E, B, C, D] | Visited: [A, B, E, C, F, D]
Path: [A, E, F, C, D] | Visited: [A, B, E, C, F, D]
Path: [A, B, E, F, C, D] | Visited: [A, B, E, C, F, D]
Path: [A, E, B, C, F, D] | Visited: [A, B, E, C, F, D]

==================================================================================
DFS By Iteration: [A, E, F, D, C, B]
DFS By Recursion: [A, B, C, D, F, E]

All Paths are by DFS Iteration: 
[A, E, F, D]
[A, E, F, C, D]
[A, E, B, C, F, D]
[A, E, B, C, D]
[A, B, E, F, D]
[A, B, E, F, C, D]
[A, B, C, F, D]
[A, B, C, D]

DFS All Path By Recursion: 
[A, B, C, D]
[A, B, C, F, D]
[A, B, E, F, C, D]
[A, B, E, F, D]
[A, E, B, C, D]
[A, E, B, C, F, D]
[A, E, F, C, D]
[A, E, F, D]
