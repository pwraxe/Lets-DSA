/**
 * Topic: Array
 * Leetcode Problem 128: Longest Consecutive Sequence
 * Leetcode Level: Easy / Accepted
 * Time Complexity: O(n*n*n)
 * **/

//Brute force Approach 
class LeetcodeSolution {

    //Overall Time Complexity : O(n*n*n) || O(n3)
    fun longestConsecutive(list: IntArray) : Int {
        var result = 0

        //forEach execute n times
        list.forEach {      //---------------> n times
            var currentNum = it

            //while loop executes n times until next no found in list, 
            //contains -- checks the number in entire array which takes n times
            //Time Complexity : O(n*n)
            while(list.contains(currentNum)) { //----while n times and contains n times --> n2
                currentNum++
            }
            result = Math.max(result, currentNum-it)
        }
        return result
    }
}

fun main() {

    val list1 = intArrayOf(0,3,7,2,5,8,4,6,0,1) //9
    val list2 = intArrayOf(1,2,3,6,7,8,9,10,11,12,13,14) //9

    val result = LeetcodeSolution().longestConsecutive(list1)
    println("Longest Consecutive : $result")
}

//-------------------------------------------------------------------------------------------------------------------------------------------

//Approch 2
/**
 * Topic: Array
 * Leetcode Problem 128: Longest Consecutive Sequence
 * Level: Easy
 * TimeComplexity: O(n log n)
 *
 * **/
class Solution {

    //Approach two 
    fun longestConsecutive(nums: IntArray): Int {
        //Sort : O(log_n)
        nums.sort()

        var maxLength = 1
        var sequenceLenth = 1

        //TimeComplexity: O(n)
        for(i in 1 until nums.size) {
            
            //Check current and previous value
            if(nums[i] == nums[i-1]+1) {
                sequenceLenth++
            } 
            //Checks prev value is same as currentValue
            else if(nums[i] == nums[i-1]) {
                continue
            } else {
                //Reset sequence Length
                sequenceLenth = 1
            }
            //get max value
            maxLength = Math.max(maxLength, sequenceLenth)
        }
        return maxLength
    }
}
