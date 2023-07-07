//Leetcode Problem:   Replace Elements with Greatest Element on Right Side

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var gratest = -1
        for(i in arr.size-1 downTo 0) {
            val temp = arr[i]
            arr[i] = gratest
        
            if(temp > gratest) {
                gratest = temp
            }
        }
        
        return arr
    }
}
