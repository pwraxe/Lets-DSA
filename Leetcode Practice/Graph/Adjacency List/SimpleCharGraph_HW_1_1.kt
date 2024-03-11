import java.util.ArrayDeque
import java.util.Stack

/*
* Self-Homework Problem-1.1
* -> Graph of Capital Characters with array size 26,
* -> No Restriction of Capital letter/Character, you can generate Vertex with Any Capital Letter
*/

//Considered Constrains
//Vertex data (src or destination) should be capital letter, and only Alphabets

class Graph {
    private val graph = Array(26) { mutableSetOf<Char>() }

    fun addEdge(src:Char, dest:Char) {
        graph[src - 'A'].add(dest)
    }

    fun readGraph() {
        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                val char = (index + 65).toChar()
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
    Graph().apply {
        addEdge('U','X')
        addEdge('U','P')

        addEdge('X','U')
        addEdge('X','P')
        addEdge('X','A')
        addEdge('X','Z')

        addEdge('P','U')
        addEdge('P','X')
        addEdge('P','Z')

        addEdge('A','X')
        addEdge('A','Z')
        addEdge('A','I')

        addEdge('Z','P')
        addEdge('Z','X')
        addEdge('Z','A')
        addEdge('Z','I')

        addEdge('I','A')
        addEdge('I','Z')

        readGraph()
        println()
        dfs('U')
        bfs('U')
    }
}



[A] -> [X, Z, I]
[I] -> [A, Z]
[P] -> [U, X, Z]
[U] -> [X, P]
[X] -> [U, P, A, Z]
[Z] -> [P, X, A, I]

DFS: [U, P, Z, I, A, X]
BFS: [U, X, P, A, Z, I]
