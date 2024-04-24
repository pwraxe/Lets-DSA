import java.util.ArrayDeque
import java.util.Stack

data class Edge(val src: Int, val dest: Int, val weight: Int = 0)
class Graph (private val vertices: Int){
    private val graph = Array(vertices) { mutableListOf<Edge>() }

    fun addEdge(src: Int, dest: Int, weight: Int) {
        graph[src].add(Edge(src, dest, weight))
    }
    fun readGraph() {
        println("Reading Whole Graph")
        graph.forEach {
            print("${it[0].src} --> ")
            it.forEach {
                print("${it.dest}, ")
            }
            println()
        }
    }
    fun getNeighbors(vertex: Int) {
        graph[vertex].forEach {
            println("${it.src} --${it.weight}--> ${it.dest}")
        }
    }

    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        val visited = hashSetOf<Int>()

        queue.offer(start)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            visited.add(vertex)
            graph[vertex].forEach {
                if (it.dest !in visited) queue.offer(it.dest)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun dfs(start: Int) {
        val stack = Stack<Int>()
        val visited = hashSetOf<Int>()
        stack.push(start)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            visited.add(top)
            graph[top].forEach {
                if (it.dest !in visited) stack.push(it.dest)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }

    fun hashPath(src: Int, dest: Int, visited: HashSet<Int>): Boolean {
        if (visited.size == vertices) return false
        if (src == dest) return true
        visited.add(src)
        graph[src].forEach {
            if (it.dest !in visited && hashPath(it.dest, dest,visited)) {
                return true
            }

        }
        return false
    }

}
fun main() {

    Graph(5).apply {
        addEdge(0,1,5)

        addEdge(1,0,5)
        addEdge(1,2,1)
        addEdge(1,3,3)

        addEdge(2,1, 1)
        addEdge(2,3, 1)
        addEdge(2,4, 2)

        addEdge(3,1,3)
        addEdge(3,2,1)

        addEdge(4,2,2)

        readGraph()

        println("Neighbors: ")
        getNeighbors(2)
        println()
        bfs(0)
        dfs(0)
        println("0 --> 3? = ${hashPath(0,3, hashSetOf())}")
        println("0 --> 4? = ${hashPath(0,4, hashSetOf())}")
        println("0 --> 5? = ${hashPath(0,5, hashSetOf())}")
        println("4 --> 0? = ${hashPath(4,0, hashSetOf())}")
    }
}


//==============
Reading Whole Graph
0 --> 1, 
1 --> 0, 2, 3, 
2 --> 1, 3, 4, 
3 --> 1, 2, 
4 --> 2, 
Neighbors: 
2 --1--> 1
2 --1--> 3
2 --2--> 4

BFS: [0, 1, 2, 3, 4]
DFS: [0, 1, 2, 3, 4]
0 --> 3? = true
0 --> 4? = true
0 --> 5? = false
4 --> 0? = true
