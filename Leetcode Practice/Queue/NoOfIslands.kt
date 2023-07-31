//No of Islands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rowSize = grid.size
        val colSize = grid[0].size
        var noOfIslands = 0

        for(row in 0 until rowSize) {
            for(col in 0 until colSize) {
                if(grid[row][col] == '1') {
                    //At least island found, hence
                    noOfIslands++
                    doBFSIn4Direction(row, col, grid)
                }		
            }
        }
        return noOfIslands
    }

    private fun doBFSIn4Direction(rowIndex: Int, colIndex: Int, grid: Array<CharArray>) {

        val startBoundryofMatrix = (rowIndex >= 0 && colIndex >= 0)
        val endBoundryOfMatrix = (rowIndex < grid.size && colIndex < grid[0].size)
        if(startBoundryofMatrix && endBoundryOfMatrix && grid[rowIndex][colIndex] == '1' ) {
            //Update value at give row to avoid repeatation on same index, lets say 'x'
            grid[rowIndex][colIndex] = 'x'

            //Now, we have to Traverse in all 4 direction (Next, Bottom, Left, Top)

            //Direction 1 :  Next position of Element
                    //Suppose we are at [1][1] position in matrix so next position will be [1][2], so 
            doBFSIn4Direction(rowIndex = rowIndex, colIndex = colIndex+1, grid = grid)

            //Direction 2 : Bottom position of Element
            //Supppose we are at [1][1] position in matrix, so bottom position will be [2][1], so
            doBFSIn4Direction(rowIndex = rowIndex+1, colIndex = colIndex, grid = grid)

            //Direction 3 : Left Position of Element
            //Suppose we are at [1][1] position in matrix, so left position will be [1][0], so
            doBFSIn4Direction(rowIndex = rowIndex, colIndex = colIndex-1, grid = grid)

            //Direction 4 : Top Postion of Element
            //Suppose we are at [1][1] position in matrix, so top position will be [0][1]
            doBFSIn4Direction(rowIndex = rowIndex-1, colIndex = colIndex, grid = grid)
        }
    }
}
