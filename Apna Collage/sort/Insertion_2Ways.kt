class Solution {
  
    fun mergeSortWay1(n: IntArray): IntArray {
         for (i in 1 ..< n.size) {
             val key = n[i]
             var j = i-1
             while (j >= 0 && n[j] > key) {
                 n[j+1] = n[j]
                 j--
             }
             n[j+1] = key
         }
         return n
     }
    
    fun mergeSortWay2(n: IntArray): IntArray {

        for (i in 1 until n.size) {
            val picked = n[i]
            var prev = i-1
            while (prev >= 0 && picked < n[prev]) {
                n[prev+1] = n[prev]
                prev--
            }
            n[prev+1] = picked
        }
        return n
    }
}
fun main() {
    Solution().apply {
        val list = intArrayOf(12, 31, 25, 8, 32, 17)
//        val list = intArrayOf(5,4,1,3,2,5,4,1,2,3)
        println(mergeSortWay2(list).toTypedArray().contentToString())
    }
}
