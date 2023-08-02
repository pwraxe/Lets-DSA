//Problem is Same as no of islands
//Only diff. that insted of searching 1 we need to search old value 
class Solution {
    
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if(image[sr][sc] == color) return image
        return doFilling(image, sr, sc, image[sr][sc], color)
    }
    
    private fun doFilling(image: Array<IntArray>, sr: Int, sc: Int, oldColor: Int, newColor: Int) : Array<IntArray> {
 
        val start = sr < 0 || sc < 0
        val end = sr >= image.size || sc >= image[0].size
        
        if(start || end || image[sr][sc] != oldColor) return image
        
        image[sr][sc] = newColor
        doFilling(image, sr,   sc+1, oldColor, newColor)
        doFilling(image, sr+1, sc, oldColor, newColor)
        doFilling(image, sr,   sc-1,oldColor, newColor)
        doFilling(image, sr-1, sc,oldColor, newColor)
        
        return image
        
    }
}
