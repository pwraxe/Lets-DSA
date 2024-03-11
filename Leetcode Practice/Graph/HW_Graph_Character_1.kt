import java.util.ArrayDeque
import java.util.Stack

/*
* Self-Homework Problem-1
* -> Graph of Capital Character
* -> This is limited character and sequencial character problem, (Look Array size and try to understand)
*/

class Graph (n:Int) {
    private val graph = Array(n) { mutableSetOf<Char>() }

    fun addEdge(src:Char, dest:Char) {
        graph[src - 'A'].add(dest)
    }

    fun readGraph() {
        graph.forEachIndexed { index, set ->
            val char = (index + 65).toChar()
            println("[$char] -> ${set.toTypedArray().contentToString()}")
        }
    }

    fun dfs(src: Char) {
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s - 'A'].forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }

        println("DFS: ${visited.toTypedArray().contentToString()}")
    }

    fun bfs(src: Char) {
        val queue = ArrayDeque<Char>()
        val visited = mutableSetOf<Char>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.poll()
            visited.add(s)
            graph[s-'A'].forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }

        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph(5).apply {
        addEdge('A','B')
        addEdge('A','C')

        addEdge('B','A')
        addEdge('B','C')
        addEdge('B','D')
        addEdge('B','E')

        addEdge('C','A')
        addEdge('C','B')
        addEdge('C','D')

        addEdge('D','C')
        addEdge('D','B')
        addEdge('D','E')

        addEdge('E','B')
        addEdge('E','D')

        readGraph()
        dfs('A')
        bfs('A')
    }
}
