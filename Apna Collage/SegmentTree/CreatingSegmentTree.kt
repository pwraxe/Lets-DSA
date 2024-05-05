class SegmentTree {

    private lateinit var tree: IntArray
    private fun buildSegmentTree(list: IntArray, index: Int, start: Int, end: Int): Int {
        if (start == end) {
            tree[index] = list[start]
            return list[start]
        }
        val mid = (start+end)/2

        //==========WAY-1=========================================
        /**
        buildSegmentTree(list, 2 * index + 1, start, mid)
        buildSegmentTree(list, 2 * index + 2, mid+1, end)
        val leftIndex = 2 * index + 1
        val rightIndex = 2 * index + 2
        tree[index] = tree[leftIndex] + tree[rightIndex]
        return tree[index]
        **/
        //==========WAY-2=========================================

        val left = buildSegmentTree(list, 2 * index + 1, start, mid)
        val right = buildSegmentTree(list, 2 * index + 2, mid+1, end)
        tree[index] = left+right
        return tree[index]
    }

    fun getSegmentTree(list: IntArray) {
        tree = IntArray(list.size*4)
        buildSegmentTree(list,0,0,list.size-1)
        println(tree.toTypedArray().contentToString())
    }

}

fun main() {
    SegmentTree().apply {
        getSegmentTree(list = intArrayOf(1,2,3,4,5,6,7,8))
    }
}



[36, 10, 26, 3, 7, 11, 15, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
