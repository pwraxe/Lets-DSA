class Solution {
    fun divNum(list:IntArray) {

        val max = list.maxOrNull() ?: 0
        val min = list.minOrNull() ?: 0  /** Optional, can start from 1 or 2 or any based on requirement*/

        /**Find Frequency, how many times the number has occurred*/
        val freq = IntArray(max + 1)
        for (num in list) freq[num]++

        /** Find multiples by Sieve of Eratosthenes */
        val count = IntArray(max + 1)
        for (i in min .. max) {
            for (j in i .. max step i) {
                count[i] += freq[j]
            }
        }
        println(count.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().divNum(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
}

count = [0, 9, 4, 3, 2, 1, 1, 1, 1, 1]
index =  0  1  2  3  4  5  6  7  8  9
