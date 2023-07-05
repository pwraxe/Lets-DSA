class Solution {
    fun duplicateZeros(arr: IntArray): Unit {
        
        val list = mutableListOf<Int>()
        arr.forEach {
            list.add(it)
            if(it == 0) {
                list.add(0)
            }
        }
        
        for(i in 0 until arr.size) {
            arr[i] = list[i]
        }
    }
}
