//Note for you Akshay:
//In video he took starting point (3,3) to  (1,1)
//But here for visual understanfing on matrix, you took (0,0) to (2,2) 
//it will become easy to move left or right by adding 1 to row or col
//rest is same
//u should thank to kunal


class Solution {
    val pathList = mutableListOf<String>()
    fun getMazePath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (currentRow < lastRow) {
            //Down-word Direction
            getMazePath(currentRow+1,currentCol, lastRow, lastCol, path + 'D')
        }

        if (currentCol < lastCol) {
            //Right-word Direction
            getMazePath(currentRow,currentCol + 1, lastRow, lastCol, path + 'R')
        }
    }
}

fun main() {
    Solution().apply {
        getMazePath(0,0,2,2,"")
        println(pathList.toTypedArray().contentToString())
    }
}
