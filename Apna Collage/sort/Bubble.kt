//outer loop is just a total turn or iteration we have to take for sorting
//inner loop each time check next value for smaller if it is then swap, in each outer iteration

//we went from 0 until size - 1  coz we already know at first iteration biggest value will go at end


class Solution {
  
    fun bubbleSort(n:IntArray): IntArray {
        for (i in 0..<n.size-1) {
            for (j in 0 ..< n.size-1-i) {
                if (n[j] > n[j+1]) {
                  //Swap
                    n[j] = n[j+1].also { n[j+1] = n[j] }
                }
            }
        }
        return n
    }
}
fun main() {
    Solution().apply {
        val n = bubbleSort(intArrayOf(5,4,1,3,2))
        println(n.toTypedArray().contentToString())
    }
}
