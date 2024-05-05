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

    private fun getSegmentSum(i:Int, si:Int, sj:Int, qi: Int, qj: Int): Int {

        return if (qj <= si || qi >= sj) { //Non-Overlapped
            0
        } else if (si >= qi && sj <= qj) { //Complete Overlapped
            tree[i]
        } else { //Partial Overlapped
            val mid = (si+sj)/2
            val left = getSegmentSum(2*i+1, si, mid, qi, qj)
            val right = getSegmentSum(2*i+2, mid+1, sj, qi, qj)
            left+right
        }

    }
    fun getSum(list: IntArray, qi: Int, qj: Int) {
        println("Sum: ${getSegmentSum(0,0,list.lastIndex,qi, qj)}")
    }

    private fun updateSegTree(i:Int, si:Int, sj: Int, diff:Int,index: Int,) {
        if (index <= si || index >= sj) return

        tree[i] += diff

        val mid = (si + sj) / 2
        updateSegTree(2 * index + 1, si, mid, diff, index)
        updateSegTree(2 * index + 2, mid+1, sj, diff, index)

    }
    fun update(list: IntArray, index: Int, newValue: Int) {
        val diff = newValue - list[index]
        updateSegTree(0,0,list.size-1,diff,index)
    }
}

fun main() {
    SegmentTree().apply {
        val list = intArrayOf(1,2,3,4,5,6,7,8)
        getSegmentTree(list)
        getSum(list,2,5)
        update(list,2,2)
        getSum(list,2,5)
    }
}



[36, 10, 26, 3, 7, 11, 15, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Sum: 18
Sum: 17
