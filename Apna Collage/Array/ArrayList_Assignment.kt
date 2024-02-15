class Assignment2 {

    //Question-1
    fun isMonotonicArray1(list: IntArray): Boolean {
        println(isMonotonicArray2(list))
        println("=========================")
        //check for increasing
        var isMonotonic = true
        for (index in 0 ..< list.size-1) {
            if (list[index] > list[index+1]) {
                isMonotonic = false
                break
            }
        }

        if (isMonotonic) return true

        //check for decreasing
        for (index in 0..<list.size-1) {
            if (list[index] < list[index+1]) {
                return false
            }
        }
        return true
    }
    private fun isInc(nums: IntArray): Boolean {
        var index = 1
        while(index < nums.size) {
            if(nums[index-1] > nums[index]) return false
            index++
        }
        return true
    }
    private fun isDec(nums: IntArray) : Boolean {
        var index = 1
        while(index < nums.size) {
            if(nums[index-1] < nums[index]) return false
            index++
        }
        return true
    }
    private fun isMonotonicArray2(list: IntArray): Boolean {
        return isInc(list) || isDec(list)
    }
    //==========================================================================

    //Question-2
    fun findLonely(nums: IntArray): List<Int> {
        if(nums.size == 1) return nums.toList()

        val frequency = IntArray(nums.max()+1)
        nums.forEach {
            frequency[it]++
        }

        val result = mutableListOf<Int>()
        for (index in frequency.indices) {
            if (frequency[index] == 1) {
                //case 1: first index
                if (index == 0 && frequency[index+1] == 0) {
                    result.add(index)
                }

                //case 2: Middle Index
                if (index in 1..< frequency.lastIndex-1 && frequency[index+1] == 0 && frequency[index-1] == 0) {
                    result.add(index)
                }

                //Case 3: Last Index
                if (index == frequency.lastIndex && frequency[index-1] == 0) {
                    result.add(index)
                }
            }
        }
        return result
    }
    //==========================================================================

    //Question-3
    fun mostFrequent(numbs: IntArray, key: Int): Int {
        val followings = mutableListOf<Int>()

        for (index in 0..<numbs.size-1) {
            if (numbs[index] == key) {
                followings.add(numbs[index+1])
            }
        }
        val res = followings.groupingBy { it }.eachCount().maxBy { it.value }

        return res.key
    }

    //==========================================================================

    //Question-4
    //Wont Solved until i understood problem: Leetcode: 932

}

fun main() {
    Assignment2().apply {
        println(isMonotonicArray1(intArrayOf(1,2,2,3)))
        println(isMonotonicArray1(intArrayOf(6,5,4,4)))
        println(isMonotonicArray1(intArrayOf(1,3,2)))

        println(findLonely(intArrayOf(10,6,5,8)).toTypedArray().contentToString())
        println(findLonely(intArrayOf(1,3,5,3)).toTypedArray().contentToString())

        println("-----------------")
        println(mostFrequent(intArrayOf(1,100,200,1,100),1))
        println(mostFrequent(intArrayOf(2,2,2,2,3),2))
    }
}



// true
// =========================
// true
// true
// =========================
// true
// false
// =========================
// false
// [8, 10]
// [1, 5]
// -----------------
// 100
// 2
