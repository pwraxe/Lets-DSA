
//Target: Using Adjacency Hashmap, Create a Simple Graph, Read it, BFS, DFS
//String as a Key (StringGraph)


class StringGraph {
    private val graph = hashMapOf<String, MutableSet<String>>()

    fun addEdge(src:String, dest:String) {
        graph[src] = graph.getOrDefault(src, mutableSetOf()).also { it.add(dest) }
    }

    fun readGraph() {
        println(graph)
        graph.forEach { (key, value) ->
            println("$key -> ${value.toTypedArray().contentToString()}")
        }
    }

    fun bfs(src: String) {
        val queue = ArrayDeque<String>()
        val visited = mutableSetOf<String>()
        queue.offer(src)
        while (queue.isNotEmpty()) {
            val s = queue.poll()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) queue.offer(it)
            }
        }
        println("BFS: ${visited.toTypedArray().contentToString()}")
    }
    fun dfs(src: String) {
        val stack = Stack<String>()
        val visited = mutableSetOf<String>()
        stack.push(src)
        while (stack.isNotEmpty()) {
            val s = stack.pop()
            visited.add(s)
            graph[s]?.forEach {
                if (!visited.contains(it)) stack.push(it)
            }
        }
        println("DFS: ${visited.toTypedArray().contentToString()}")
    }
}

fun main() {
    StringGraph().apply {
        addEdge("My Car","Lesson")
        addEdge("My Car","My Hometown way")

        addEdge("Lesson","My Car")
        addEdge("Lesson","My Hometown way")
        addEdge("Lesson","!@#$%")
        addEdge("Lesson","Aa0@Bb1#Cc2&")

        addEdge("My Hometown way","My Car")
        addEdge("My Hometown way","Lesson")
        addEdge("My Hometown way","!@#$%")

        addEdge("!@#$%","My Hometown way")
        addEdge("!@#$%","Lesson")
        addEdge("!@#$%","Aa0@Bb1#Cc2&")

        addEdge("Aa0@Bb1#Cc2&","Lesson")
        addEdge("Aa0@Bb1#Cc2&","!@#$%")

        readGraph()

        bfs("My Car")
        dfs("My Car")
    }
}

{My Hometown way=[My Car, Lesson, !@#$%], Aa0@Bb1#Cc2&=[Lesson, !@#$%], !@#$%=[My Hometown way, Lesson, Aa0@Bb1#Cc2&], My Car=[Lesson, My Hometown way], Lesson=[My Car, My Hometown way, !@#$%, Aa0@Bb1#Cc2&]}
My Hometown way -> [My Car, Lesson, !@#$%]
Aa0@Bb1#Cc2& -> [Lesson, !@#$%]
!@#$% -> [My Hometown way, Lesson, Aa0@Bb1#Cc2&]
My Car -> [Lesson, My Hometown way]
Lesson -> [My Car, My Hometown way, !@#$%, Aa0@Bb1#Cc2&]
BFS: [My Car, Lesson, My Hometown way, !@#$%, Aa0@Bb1#Cc2&]
DFS: [My Car, My Hometown way, !@#$%, Aa0@Bb1#Cc2&, Lesson]
