//Leetcode:   Two Sum II - Input array is sorted
//TC: O(n), as Array is sorted, given, n is size of array
//SC: O(1)

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.size-1
        
        while(start < end) {
            val sum = numbers[start] + numbers[end]
            
            when {
                target == sum -> return intArrayOf(start+1, end+1)
                target > sum -> start++
                else -> end--
            }
        }
        return intArrayOf()
    }
}


//----------------------------------------------------------------------------------

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
