class Solution {
    fun countingSort(arr: IntArray): IntArray {
        val k = arr.max()
        val counts = IntArray(k+1) { 0 }

        //update number occurance frequency in count list
        for (num in arr) {
            counts[num] +=1
        }

        //add element from count from 0 till index
        var startIndex = 0
        for(index in 0 until counts.size) {
            val count = counts[index]
            counts[index] = startIndex
            startIndex += count
        }
        println("Count1 $startIndex : ${counts.contentToString()}")

        //Update sort list by getting index from counts and update counts index by 1
        val sorted = IntArray(arr.size) { 0 }
        for (item in arr) {
            sorted[counts[item]] = item
            counts[item] += 1
        }

        //optional, 
        // your list is sorted in sorted array, just updating to original array
        for (index in 0 until arr.size) {
            arr[index] = sorted[index]
        }

        //you can return arr or sorted, both are same
        return arr
    }
}

fun main() {
    Solution().apply {
        println(countingSort(intArrayOf(3,1,5,2,4,2,1,3,4,5)).contentToString())
    }
}
