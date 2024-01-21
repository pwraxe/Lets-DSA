//triplet of different index add them if sum == 0 then add to list,
//condition: list should be non-duplicate
class Solution {
    fun tripletsOfZero(n:IntArray):List<IntArray> {
        val map = hashMapOf<IntArray, Int>()
        for (i in n.indices) {
            for (j in i+1 ..< n.size) {
                for (k in j+1 ..< n.size) {
                    if (n[i] + n[j] + n[k] == 0) {
                        val arr = intArrayOf(n[i],n[j],n[k]).sortedArray()
                        map[arr] = 0
                    }
                }
            }
        }
        return map.keys.toSet().toList()
    }
}

fun main() {
    Solution().apply {
        tripletsOfZero(intArrayOf(-1, 0,  1, 2, -1, -4)).forEach {
            println(it.toTypedArray().contentToString())
        }
    }
}
