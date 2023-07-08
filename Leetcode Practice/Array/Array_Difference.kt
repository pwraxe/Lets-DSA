//Leetcode: Height Checker
//TC: O(n), loop used
//SC: O(n), extra memory took
class Solution {
    fun heightChecker(heights: IntArray): Int {
        var expected = heights.sorted().toIntArray()
        
        var diff = 0
        for(index in 0 until expected.size) {
            if(heights[index] != expected[index]) {
                diff++
            }
        }
        return diff
    }
}
