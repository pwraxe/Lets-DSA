class Solution {
    fun reversed(list: CharArray): CharArray {
        return doRev(list,0, list.size-1)
    }

    private fun doRev(list: CharArray, startIndex:Int, endIndex:Int): CharArray {

        if(startIndex == list.size/2) {
            return list
        }

        list[startIndex] = list[endIndex].also { list[endIndex] = list[startIndex] }
        doRev(list,startIndex+1, endIndex-1)
        return list
    }
}
fun main() {
    Solution().apply {
        println(reversed("Akshay Pawar".toCharArray()))
    }
}
