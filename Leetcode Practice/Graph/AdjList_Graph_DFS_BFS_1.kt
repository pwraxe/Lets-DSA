/*
* - Creation of Graph using Adjacency List
* - Traverse using DFS
* - Traverse using BFS
*/

//I can say, this is a strict graph, 
//Strict mean, I have allowed the creation node/vertex between 0 to n+1, which causes limitations, in the graph,
//This is why we consider vertex data as an index for the `graph` array.


import java.util.ArrayDeque
import java.util.Stack

class Graph (n: Int) {

    private val graph = Array(n+1) { mutableSetOf<Int>() }

    fun addEdge(src: Int, dest: Int) {
        graph[src].add(dest)
    }

    fun dfs(src: Int) {
        val stack = Stack<Int>()
        val visited = mutableSetOf<Int>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s].forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }

        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
    fun bfs(src:Int) {
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.pop()
            visited.add(s)
            graph[s].forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun readGraph() {

        graph.forEachIndexed { index, set ->
            if (set.isNotEmpty()) {
                println("[$index] -> ${set.toTypedArray().contentToString()}")
            }
        }
    }
}

fun main() {
    Graph(5).apply {
        addEdge(1,2)
        addEdge(1,3)

        addEdge(2,1)
        addEdge(2,3)
        addEdge(2,4)
        addEdge(2,5)

        addEdge(3,1)
        addEdge(3,2)
        addEdge(3,4)

        addEdge(4,3)
        addEdge(4,2)
        addEdge(4,5)

        addEdge(5,2)
        addEdge(5,4)

        readGraph()
        dfs(1)
        bfs(1)
    }
}


[1] -> [2, 3]
[2] -> [1, 3, 4, 5]
[3] -> [1, 2, 4]
[4] -> [3, 2, 5]
[5] -> [2, 4]
DFS: [1, 3, 4, 5, 2]
BFS: [1, 2, 3, 4, 5]
