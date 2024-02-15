import kotlin.math.max
import kotlin.math.min

class Solution {

    fun waterWithMaxContainer(heights: IntArray): Int {
        var left = 0
        var right = heights.lastIndex
        var maxVol = 0
        while (left < right) {
            val height = min(heights[left], heights[right])
            val width = right - left
            maxVol = max(maxVol, height * width)
            if (heights[left] < heights[right]) {
                left++
            }else {
                right--
            }
        }
        return maxVol
    }
    fun getMaxWater(list: IntArray): Int {
        var maxVolumn = 0
        for (i in list.indices) {
            for (j in i+1 ..< list.size) {
                val height = min(list[i],list[j])
                val with = j - i
                maxVolumn = max(maxVolumn, height * with)
            }
        }

        return maxVolumn
    }
}

fun main() {
    Solution().apply {
        val heights = intArrayOf(1,8,6,2,5,4,8,3,7)
        println(getMaxWater(heights))
        println(waterWithMaxContainer(heights))
    }
}

//49
//49
