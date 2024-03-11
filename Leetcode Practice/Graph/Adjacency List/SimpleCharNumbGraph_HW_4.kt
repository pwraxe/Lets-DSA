import java.util.ArrayDeque
import java.util.Stack

/**
 * Self-Homework Problem-4_1
 * -> Graph of Single Numbers
**/

// Graph Vertex with Single number as a character, that's why Array size is 10 
/*
Considered constrains
 -> Vertex should be Character,
 -> Vertex data contains only Number character
*/

class Graph {
    private val graph = Array(10) { mutableSetOf<Char>() }

    fun addEdge(src:Char, dest:Char) {
        graph[src - '0'].add(dest)
    }

    fun readGraph() {
        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                val char = (index + 48).toChar()
                println("[$char] -> ${set.toTypedArray().contentToString()}")
            }
        }
    }

    fun dfs(src:Char) {
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()

        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s - '0'].forEach {
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
            graph[s - '0'].forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }

}

fun main() {
    Graph().apply {
        addEdge('1','2')
        addEdge('1','3')

        addEdge('2','1')
        addEdge('2','3')
        addEdge('2','4')
        addEdge('2','5')

        addEdge('3','1')
        addEdge('3','2')
        addEdge('3','4')

        addEdge('4','3')
        addEdge('4','2')
        addEdge('4','5')

        addEdge('5','2')
        addEdge('5','4')

        readGraph()
        dfs('1')
        bfs('1')
    }
}

[1] -> [2, 3]
[2] -> [1, 3, 4, 5]
[3] -> [1, 2, 4]
[4] -> [3, 2, 5]
[5] -> [2, 4]
DFS: [1, 3, 4, 5, 2]
BFS: [1, 2, 3, 4, 5]

