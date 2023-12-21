//By Traversing Right , Down , Cross (Diagonally)

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

        if (currentRow < lastRow && currentCol < lastCol) {
            getMazePath(currentRow+1, currentCol+1, lastRow, lastCol, path + 'C')
        }
    }
}

fun main() {
    Solution().apply {
        getMazePath(0,0,2,2,"")
        println(pathList.toTypedArray().contentToString())
    }
}

//Output: [DDRR, DRDR, DRRD, DRC, DCR, RDDR, RDRD, RDC, RRDD, RCD, CDR, CRD, CC]
