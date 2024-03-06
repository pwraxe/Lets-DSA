class QuickFind(n:Int) {
    private val network = IntArray(n)
    init {
        repeat(n) { network[it] = it }
    }

    //O(1)
    private fun findParentOf(x:Int): Int {
        return network[x]
    }
    //O(n)
    fun union(parent:Int, child:Int) {
        val mParent = findParentOf(parent)
        val mChild = findParentOf(child)
        if (parent != child) {
            for (i in network.indices) {
                if (network[i] == mChild) {
                    network[i] = mParent
                }
            }
        }
    }
}
class QuickUnion(n:Int) {
    private val network = IntArray(n)
    init {
        repeat(n) { network[it] = it }
    }

    //O(n)
    private fun findParentOf(child:Int): Int {
        if (child == network[child]) return child
        network[child] = findParentOf(network[child])
        return network[child]
    }
    //O(1)
    fun union(parent: Int, child: Int) {
        val mParent = findParentOf(parent)
        val mChild = findParentOf(child)
        if (mParent != mChild) {
            network[mChild] = mParent
        }
    }
}

class QuickByRank(n:Int) {
    private val network = IntArray(n)
    private val rank = IntArray(n)
    init {
        repeat(n) {
            network[it] = it
            rank[it] = it
        }
    }
    private fun findParentOf(x:Int): Int {
        var i = x
        while (i != network[i]) i = network[i]
        return i
    }
    fun union(parent:Int, child:Int) {
        val mParent = findParentOf(parent)
        val mChild = findParentOf(child)
        if (mParent != mChild) {
            when {
                rank[mParent] > rank[mChild] -> {
                    network[mParent] = mChild
                }
                rank[mParent] < rank[mChild] -> {
                    network[mChild] = mParent
                }
                else -> {
                    network[mParent] = mChild
                    rank[mParent] += 1
                }
            }
        }
    }
}
