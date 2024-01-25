class Solution {
     fun largestString(arr: Array<String>) {
         var largest = arr.first()
         for (i in 1 ..<arr.size) {
             if (largest.compareTo(arr[i]) < 0) {
                 largest = arr[i]
             }
         }
         println("Largest: $largest")
     }
}

fun main() {
    Solution().apply {
        largestString(arrayOf("apple","applets","banana","mango"))
    }
}

//mango
