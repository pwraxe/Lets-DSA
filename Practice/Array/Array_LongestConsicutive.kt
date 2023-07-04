/**
 * Topic: Array
 * Problem: Longest Consecutive Sequence
 * Level: Easy
 * TimeComplexity: O(n*n)
 *
 * **/
class LeetcodeSolution {

    //Brute force Approach
    fun longestConsecutive(list: IntArray) : Int {
        var result = 0
        list.forEach {
            var currentNum = it
            while(list.contains(currentNum)) {
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
