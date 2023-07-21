//Leetcode:   Two Sum II - Input array is sorted
//TC: O(n2)
//SC: O(1)

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        
        while(i < numbers.size-1) {
            var j = i+1
            while(j <= numbers.size-1) {
                val sum = numbers[i] + numbers[j]
                if(sum == target) return intArrayOf(i+1, j+1)
                j++ 
            }
            i++
        }
        return intArrayOf()
    }
}

//--------------------------------------------------------
