import java.util.ArrayDeque
import java.util.Stack

/*
* Self-Homework Problem-2
* -> Graph of Small Characters,
* -> You can create Vertex of any small character
*/

class Graph {
    private val graph = Array(26) { mutableSetOf<Char>() }

    fun addEdge(src:Char, dest:Char) {
        graph[src - 'a'].add(dest)
    }

    fun readGraph() {
        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                val char = (index + 97).toChar()
                println("[$char] -> ${set.toTypedArray().contentToString()}")
            }
        }
    }

    fun dfs(src: Char) {
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s - 'a'].forEach {
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
            graph[s-'a'].forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }

        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge('u','x')
        addEdge('u','p')

        addEdge('x','u')
        addEdge('x','p')
        addEdge('x','i')
        addEdge('x','z')

        addEdge('p','a')
        addEdge('p','x')
        addEdge('p','z')

        addEdge('a','x')
        addEdge('a','z')
        addEdge('a','i')

        addEdge('z','p')
        addEdge('z','x')
        addEdge('z','a')
        addEdge('z','i')

        addEdge('i','a')
        addEdge('i','z')

        readGraph()
        println()
        dfs('u')
        bfs('u')
    }
}



[a] -> [x, z, i]
[i] -> [a, z]
[p] -> [a, x, z]
[u] -> [x, p]
[x] -> [u, p, i, z]
[z] -> [p, x, a, i]

DFS: [u, p, z, i, a, x]
BFS: [u, x, p, i, z, a]
