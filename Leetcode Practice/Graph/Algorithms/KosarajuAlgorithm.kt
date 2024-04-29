//Kosaraju Algorithm
//-> It use to find Strongly Connected Components
//-> Steps
//-> 1. Perform Topological Sort on the original Graph (save data in stack)
//-> 2. Reverse Graph Edges and Clone to new Graph
//-> 3. Perform DFS on Reverse Graph until stack empty


import java.util.*
import kotlin.collections.HashMap

data class Edge(val src: Int, val dest: Int)
class Graph {
    private val graph = hashMapOf<Int,MutableList<Edge>>()
    fun addEdge(src: Int, dest: Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest)) }
    }

    //======================================================================================================

    private fun dfsOnReversedGraph(revGraph: HashMap<Int,MutableList<Edge>>, src:Int, visited: BooleanArray) {
        visited[src] = true
        print("$src ")
        revGraph[src]?.forEach {
            if (!visited[it.dest]) {
                dfsOnReversedGraph(revGraph, it.dest, visited)
            }
        }
    }
    private fun topologicalSort(visited: BooleanArray, current: Int, stack: Stack<Int>) {
        visited[current] = true
        graph[current]?.forEach {
            if (!visited[it.dest]) {
                topologicalSort(visited, it.dest, stack)
            }
        }
        stack.push(current)
    }

    fun kosarajuAlgorithm() {
        
        //Step 1: Topological Sort, Using Stack to save TopSort Data
        val stack = Stack<Int>()
        val visited = BooleanArray(graph.size+1)
        for (i in 1 .. 9) {
            if (!visited[i]) {
                topologicalSort(visited,i,stack)
            }
        }

        //Step 2: Transpose Graph
        val revGraph = hashMapOf<Int,MutableList<Edge>>()
        graph.values.forEach { list ->
            list.forEach {
                revGraph[it.dest] = revGraph.getOrDefault(it.dest, mutableListOf()).also {
                    l -> l.add(Edge(it.dest,it.src))
                }
            }
        }

        //Reset Visited Values
        visited.fill(false)

        //Step 3: Perform DFS on Reverse Graph until stack empty
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (!visited[top]) {
                dfsOnReversedGraph(revGraph,top,visited)
                println()
            }
        }
    }
}

fun main() {
    Graph().apply {
        addEdge(1,2)

        addEdge(2,3)
        addEdge(2,5)

        addEdge(3,4)
        addEdge(3,5)

        addEdge(4,1)

        addEdge(5,6)

        addEdge(6,7)
        addEdge(7,8)
        addEdge(8,9)
        addEdge(9,6)

        kosarajuAlgorithm()
    }
}

//====================
1 4 3 2 
5 
6 9 8 7 
