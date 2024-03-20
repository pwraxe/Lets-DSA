import java.util.ArrayDeque

data class Edge(val src:Char, val dest: Char, val weight: Int)

class MstGraph {

    private val graph = hashMapOf<Char,MutableList<Edge>>()
    fun addEdge(src:Char, dest: Char, weight:Int) {
        graph[src] = graph.getOrDefault(src, mutableListOf()).also { it.add(Edge(src, dest, weight)) }
    }
    fun readGraph() {
        println("Reading Graph ===========================")
        graph.forEach { (k,v) ->
            print("[$k] -> ")
            v.forEach {
                print("${it.src} --${it.weight}--> ${it.dest}, ")
            }
            println()
        }
    }

    fun applyDijkstraAlgorithm(src: Char): HashMap<Char, Pair<Int, Char?>> {
        val queue = ArrayDeque<Char>()
        val visited = mutableListOf<Char>()
        val dijGraph = hashMapOf<Char, Pair<Int,Char?>>().also {
            it[src] = Pair(0,null)
            graph.keys.forEach { char ->
                it[char] = it.getOrDefault(char,Pair(Int.MAX_VALUE,null))
            }
        }

        queue.offer(src)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            if (vertex !in visited) visited.add(vertex)

            val currentPair = dijGraph[vertex]!!
            graph[vertex]?.forEach {
                val destPair = dijGraph[it.dest]!!
                if (destPair.first == Int.MAX_VALUE) {
                    dijGraph[it.dest] = Pair(currentPair.first + it.weight, it.src)
                    queue.offer(it.dest)
                } else {
                    if (currentPair.first + it.weight < destPair.first) {
                        dijGraph[it.dest] = Pair(currentPair.first + it.weight, it.src)
                        queue.offer(it.dest)
                    }
                }
            }
        }

        var weightSum = 0
        println("Dij Graph: ")
        dijGraph.forEach {
            println("[${it.key}] --${it.value.first}--> ${it.value.second}")
            weightSum += it.value.first
        }

        println("\nWeight Sum: $weightSum")
        return dijGraph
    }

    fun findDistanceAndPath(dijGraph: HashMap<Char, Pair<Int, Char?>>, src: Char, dest: Char) {
        println("Shortest Path Sum from $src to $dest : ${dijGraph[dest]?.first}")

        val list = mutableListOf<Char?>()
        var pair = dijGraph[dest]
        list.add(dest)
        while (pair?.second != null) {
            list.add(pair.second)
            pair = dijGraph[pair.second]
        }

        println(list.reversed().joinToString(" -> "))
    }


}

fun main() {
    MstGraph().apply {

        addEdge('1','2',9)
        addEdge('1','3',4)

        addEdge('2','1',9)
        addEdge('2','3',2)
        addEdge('2','5',3)
        addEdge('2','4',7)

        addEdge('3','1',4)
        addEdge('3','2',2)
        addEdge('3','4',1)
        addEdge('3','5',6)

        addEdge('4','2',7)
        addEdge('4','3',1)
        addEdge('4','5',4)
        addEdge('4','6',8)

        addEdge('5','2',3)
        addEdge('5','3',6)
        addEdge('5','4',4)
        addEdge('5','6',2)

        addEdge('6','4',8)
        addEdge('6','5',2)

        readGraph()

        val dijGraph = applyDijkstraAlgorithm('1')
        findDistanceAndPath(dijGraph,'1','6')
    }
}


Reading Graph ===========================
[1] -> 1 --9--> 2, 1 --4--> 3, 
[2] -> 2 --9--> 1, 2 --2--> 3, 2 --3--> 5, 2 --7--> 4, 
[3] -> 3 --4--> 1, 3 --2--> 2, 3 --1--> 4, 3 --6--> 5, 
[4] -> 4 --7--> 2, 4 --1--> 3, 4 --4--> 5, 4 --8--> 6, 
[5] -> 5 --3--> 2, 5 --6--> 3, 5 --4--> 4, 5 --2--> 6, 
[6] -> 6 --8--> 4, 6 --2--> 5, 
Dij Graph: 
[1] --0--> null
[2] --6--> 3
[3] --4--> 1
[4] --5--> 3
[5] --9--> 4
[6] --11--> 5

Weight Sum: 35
Shortest Path Sum from 1 to 6 : 11
1 -> 3 -> 4 -> 5 -> 6
