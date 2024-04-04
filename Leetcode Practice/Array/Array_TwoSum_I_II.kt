class Solution {

    fun twoSum_I(numbs: IntArray, target: Int): Pair<Int,Int> {
        val map = hashMapOf<Int,Int>()
        numbs.forEachIndexed { index, item ->
            map[item]?.let {
                return Pair(index, it)
            }
            map[target - item] = index
        }
        return 0 to 0
    }

    //return the pairs of list which adds upto target
    fun twoSum_II(numbs:IntArray, target:Int): List<Pair<Int,Int>> {
        val result = mutableListOf<Pair<Int,Int>>()
        var i = 0
        var j = numbs.lastIndex
        numbs.sort()
        while (i < j) {
            if (numbs[i]+numbs[j] > target) j--
            else if(numbs[i]+numbs[j] < target) i++
            else {
                while (i < j && numbs[i] == numbs[i+1]) i++
                while (j > i && numbs[j] == numbs[j-1]) j--
                result.add(Pair(numbs[i],numbs[j]))
                i++
                j--
            }
        }
        return result
    }
}

fun main() {
    Solution().apply {
        println("Two Sum - I")
        println(twoSum_I(intArrayOf(2,7,11,15),9))
        println("\nTwo Sum - II")
        twoSum_II(intArrayOf(-1,1,3,4,0,1,2,4,1,-2,-3,-1,0,3), 2).forEach {
            println(it)
        }
    }
}

//=========================================
Two Sum - I
(1, 0)

Two Sum - II
(-2, 4)
(-1, 3)
(0, 2)
(1, 1)
