//Way 1: By Swapping In-Place
//TC: O(n), 
//SC: O(n), used call-stack
//O(1) if not consider call-stack
class Solution {
    fun reversed(list: IntArray): IntArray {
        return doRev(list, 0,list.size-1)
    }

    private fun doRev(list: IntArray, startIndex:Int, endIndex:Int): IntArray {
        if(startIndex == list.size/2)
            return list

        list[startIndex] = list[endIndex].also { list[endIndex] = list[startIndex] }
        return doRev(list,startIndex+1, endIndex-1)
    }
}
fun main() {
    Solution().apply {
        val list = reversed(intArrayOf(1,2,3,4,5,6,7,8,9))
        println(list.toTypedArray().contentToString())
    }
}
//-------------------------------------------------------------------------------------------

//Way-2: By Return top of the call-stack element and updating the new list 
//TC: O(n)
//SC: O(n) + O(n)
//call-stack space + extra list for storing rev-list
class Solution {
    fun reversed(list: IntArray): IntArray {
        return doRev(list, 0,IntArray(list.size))
    }

    private fun doRev(list: IntArray, index:Int, output:IntArray): IntArray {
        if(index == list.size-1) {
            output[(list.size-1)-index] = list[index]
            return output
        }
 
        doRev(list,index+1, output)
        output[(list.size-1)-index] = list[index]
        return output
    }
}
fun main() {
    Solution().apply {
        println(reversed(intArrayOf(1,2,3,4,5,6,7,8,9)).toTypedArray().contentToString())
    }
}
