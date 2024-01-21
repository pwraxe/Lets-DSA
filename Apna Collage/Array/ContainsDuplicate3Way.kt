class Solution {

    //Using Map
    fun isDuplicateWay1(numbs:IntArray): Boolean {
        val hashMap = hashMapOf<Int, Int>()
        numbs.forEach {
            val count = hashMap.getOrDefault(it, 0)
            if (count == 1) return true
            hashMap[it] = hashMap.getOrDefault(it,0) + 1
        }
        return false
    }

    //using auxiliary array
    fun isDuplicateWay2(numbs:IntArray): Boolean {
        val list = IntArray(numbs.max()+1)
        numbs.forEach {
            if (list[it] > 0) return true
            list[it]++
        }
        return false
    }

    //By Sorting
    fun isDuplicateWay3(numbs:IntArray): Boolean {
        numbs.sort()
        for (index in 1 ..<numbs.size) {
            if (numbs[index-1] == numbs[index]) return true
        }
        return false
    }
}
fun main() {
    Solution().apply {
//        val list = intArrayOf(1,2,3,1) //true
//        println(isDuplicateWay1(list))
//        println(isDuplicateWay2(list))
//        println(isDuplicateWay3(list))

//        val list = intArrayOf(1,2,3,4) //false
//        println(isDuplicateWay1(list))
//        println(isDuplicateWay2(list))
//        println(isDuplicateWay3(list))

        val list = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2) //true
        println(isDuplicateWay1(list))
        println(isDuplicateWay2(list))
        println(isDuplicateWay3(list))

    }
}
