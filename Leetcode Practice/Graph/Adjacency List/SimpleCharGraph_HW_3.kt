import java.util.ArrayDeque
import java.util.Stack

/*
* Self-Homework Problem-3
* -> Graph of Any ASCII Characters
* -> We are considering characters in ASCII table that's why Array size is 127 + 1
*
*/

class Graph {
    private val graph = Array(128) { mutableSetOf<Char>() }

    fun addEdge(src:Char, dest:Char) {
        graph[src.code].add(dest)
    }

    fun readGraph() {
        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                val char = index.toChar()
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
            graph[s.code].forEach {
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
            graph[s.code].forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }

        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    Graph().apply {
        addEdge('x','$')
        addEdge('x','#')

        addEdge('$','x')
        addEdge('$','.')
        addEdge('$','A')

        addEdge('#','x')
        addEdge('#','.')

        addEdge('A','$')
        addEdge('A','.')
        addEdge('A','1')

        addEdge('.','#')
        addEdge('.','$')
        addEdge('.','A')
        addEdge('.','a')

        addEdge('1','A')
        addEdge('1','.')

        readGraph()
        println()
        dfs('x')
        bfs('x')
    }
}


[#] -> [x, .]
[$] -> [x, ., A]
[.] -> [#, $, A, a]
[1] -> [A, .]
[A] -> [$, ., 1]
[x] -> [$, #]

DFS: [x, #, ., a, A, 1, $]
BFS: [x, $, #, ., A, a, 1]
