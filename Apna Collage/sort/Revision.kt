class Solution {
    private fun mergeSort(left: IntArray,right:IntArray): IntArray {
        val res = IntArray(left.size + right.size)
        var i = 0
        var j = 0
        var k = 0
        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                res[k++] = left[i++]
            } else {
                res[k++] = right[j++]
            }
        }

        while (i < left.size) {
            res[k++] = left[i++]
        }
        while (j < right.size) {
            res[k++] = right[j++]
        }

        return res

    }
    fun merge(nums:IntArray): IntArray {

        if (nums.size <= 1) return nums

        val mid = nums.size/2
        val left = nums.copyOfRange(0,mid)
        val right = nums.copyOfRange(mid,nums.size)

        return mergeSort(merge(left),merge(right))

    }

    private fun partitionIndex(nums: IntArray,low:Int,high:Int) : Int {
        val pivotIndex = high
        var i = low-1
        for (j in low ..< high) {
            if (nums[j] <= nums[pivotIndex]) {
                i++
                nums[i] = nums[j].also { nums[j] = nums[i] }
            }
        }
        i++
        nums[i] = nums[pivotIndex].also { nums[pivotIndex] = nums[i] }
        return i
    }
    fun quickSort(nums: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pivotIndex = partitionIndex(nums, low, high)
            quickSort(nums, low, pivotIndex-1)
            quickSort(nums, pivotIndex+1, high)
        }
    }

    fun searchInSortedRoatatedArray(nums: IntArray, start:Int, end:Int, target:Int): Int {
        if (start > end) return -1
        val mid = start + (end - start)/2

        if (nums[mid] == target) return mid

        return if (nums[mid] < target) {
            if (target in nums[start] .. nums[mid]) {
                searchInSortedRoatatedArray(nums, start, mid, target)
            } else {
                searchInSortedRoatatedArray(nums, mid+1, end, target)
            }
        } else {
            if (target in nums[mid] .. nums[end]) {
                searchInSortedRoatatedArray(nums, mid+1, end, target)
            } else {
                searchInSortedRoatatedArray(nums, start, mid, target)
            }
        }
    }
}

fun main() {
    Solution().apply {
        val list0 = intArrayOf(6,3,9,5,2,8)
        val list = intArrayOf(9,2,7,4,1,8,3,5,6)
        quickSort(list,0,list.size-1)
        println(list.toTypedArray().contentToString())

        println(searchInSortedRoatatedArray(list,0,list.size-1,5))
    }
}



[1, 2, 3, 4, 5, 6, 7, 8, 9]
4
