class Solution {
    private fun asSelection(list: IntArray, row: Int, col: Int, maxIndex: Int) : IntArray {
        if (row == 0) return list

        if(col < row) {
            if (list[col] > list[maxIndex]) {
                asSelection(list, row, col+1, col)
            } else {
                asSelection(list, row, col+1, maxIndex)
            }
        } else {
           list[row-1] = list[maxIndex].also { list[maxIndex] = list[row-1] }
           asSelection(list, row-1,0,0)
        }
        return list
    }
    fun selection(list: IntArray): IntArray {
        return asSelection(list,list.size,0,0)
    }
}

fun main() {
    Solution().apply {
        println(selection(intArrayOf(8,4,3,1,2,9,6,7,5)).toTypedArray().contentToString())
    }
}
