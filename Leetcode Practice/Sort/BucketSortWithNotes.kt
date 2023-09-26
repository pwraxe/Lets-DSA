/**
Note:
1. Create Buckets with size of given 'k', every bucket contains mutableListOf<Any>(), Like Array of array
2. Insert elements in relevant bucket, by using this formula --> Math.floor(k*nums[index]/nums.max()).toInt()
3. Sort Each Bucket items
4. read each sorted bucket item, and save 

**/

import kotlin.math.floor

class Learning {
    fun bucketSort(nums:IntArray, k:Int): IntArray {
        val buckets = MutableList(k+1){ mutableListOf<Int>()}

        for(index in nums.indices) {
            val toBucket = floor(k*nums[index].div(nums.max().toDouble())).toInt()
            buckets[toBucket].add(nums[index])
        }

        buckets.forEach {
            if(it.isNotEmpty()) it.sort()
        }

        return buckets.flatten().toIntArray()
    }
}
fun main() {
    Learning().apply {
        println(bucketSort(intArrayOf(22,50,32,28,41,12),5).toTypedArray().contentToString())
    }
}
