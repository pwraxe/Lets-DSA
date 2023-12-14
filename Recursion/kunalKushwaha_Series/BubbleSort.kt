class Solution {
    private fun toBubbleSort(list: IntArray, row: Int, col: Int): IntArray {
        if(row == 0) return list
        
        if(col < row) {
            if(list[col] > list[col+1]) {
                list[col] = list[col+1].also { list[col+1] = list[col] }
                toBubbleSort(list, row, col+1)
            } else {
                toBubbleSort(list, row-1, 0)
            }
        }
        return list
    }
    fun bubbleSort(list: IntArray): IntArray {
        return toBubbleSort(list, list.size, 0)
    }
}
