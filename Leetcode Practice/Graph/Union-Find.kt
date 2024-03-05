class QuickFind(n:Int) {

    private val root = IntArray(n)
    init { repeat(n) { root[it] = it } }

    fun isConnected(x:Int, y:Int): Boolean = find(x) == find(y)
    fun find(x:Int): Int = root[x]
    fun union(x:Int, y:Int) {
        val rx = find(x)
        val ry = find(y)

        if (rx != ry) {
            for (i in root.indices) {
                if (root[i] == ry) {
                    root[i] = rx
                }
            }
        }
    }
}
class QuickUnion(n:Int) {
    private val root = IntArray(n)
    init { repeat(n) { root[it] = it } }

    fun find(x:Int): Int {
        var i = x
        while (i != root[i]) {
            i = root[i]
        }
        return i
    }
    fun union(x:Int, y:Int) {
        val rx = find(x)
        val ry = find(y)
        if (rx != ry) {
            root[ry] = rx
        }
    }
    fun isConnected(x:Int, y:Int):Boolean = find(x) == find(y)
}
class QuickUnionByRank(n:Int) {
    private val root = IntArray(n)
    private val rank = IntArray(n)
    init {
        repeat(n) {
            root[it] = it
            rank[it] = it
        }
    }

    fun find(x:Int): Int {
        var i = x
        while (i != root[i]) {
            i = root[i]
        }
        return i
    }
    fun union(x:Int, y:Int) {
        val rx = find(x)
        val ry = find(y)
        if (rx != ry) {
            when {
                rank[rx] > rank[ry] -> root[ry] = rx
                rank[rx] < rank[ry] -> root[rx] = ry
                else -> {
                    root[ry] = rx
                    rank[rx] += 1
                }
            }
        }
    }
    fun isConnected(x:Int, y:Int):Boolean = find(x) == find(y)
    fun read() {
        println("Root: ${root.toTypedArray().contentToString()}")
        println("Rank: ${rank.toTypedArray().contentToString()}")
    }
}
class QuickUnionOpt(n:Int) {
    private val root = IntArray(n)
    init { repeat(n) { root[it] = it } }

    fun find(x:Int): Int {
        if (x == root[x]) return x
        root[x] = find(root[x])
        return root[x]
    }
    fun union(x:Int, y:Int) {
        val rx = find(x)
        val ry = find(y)
        if (rx != ry) {
            root[ry] = rx
        }
    }
    fun isConnected(x:Int, y:Int):Boolean = find(x) == find(y)
}
fun main() {
    QuickFind(10).apply {
        union(0,1)
        union(2,3)
        union(4,5)
        union(6,7)
        union(8,9)
        println(isConnected(1,1))
        println(isConnected(2,5))
        println("Root: ${find(5)} | ${find(9)}")
        union(0,3)
        println(isConnected(1,2))
    }
    println("=========================")
    QuickUnion(10).apply {
        union(0,1)
        union(2,3)
        union(4,5)
        union(6,7)
        union(8,9)
        println(isConnected(1,1))
        println(isConnected(2,5))
        println("Root: ${find(5)} | ${find(9)}")
        union(0,3)
        println(isConnected(1,2))
    }
    println("=========================")
    QuickUnionByRank(10).apply {
        union(0,1)
        union(2,3)
        union(4,5)
        union(6,7)
        union(8,9)
        println(isConnected(1,1))
        println(isConnected(2,5))
        println("Root: ${find(5)} | ${find(9)}")
        read()
        union(0,3)
        read()
        println(isConnected(1,2))
    }
    println("=========================")
    QuickUnionOpt(10).apply {
        union(0,1)
        union(2,3)
        union(4,5)
        union(6,7)
        union(8,9)
        println(isConnected(1,1))
        println(isConnected(2,5))
        println("Root: ${find(5)} | ${find(9)}")
        union(0,3)
        println(isConnected(1,2))
    }
}


true
false
Root: 4 | 8
true
=========================
true
false
Root: 4 | 8
true
=========================
true
false
Root: 5 | 9
Root: [1, 1, 3, 3, 5, 5, 7, 7, 9, 9]
Rank: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Root: [1, 3, 3, 3, 5, 5, 7, 7, 9, 9]
Rank: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
true
=========================
true
false
Root: 4 | 8
true
