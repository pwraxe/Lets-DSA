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

//============================================== Other Optimal
class Solution {
    fun duplicateZeros(arr: IntArray): Unit {
       var i = 0
        while (i < arr.size) {
            if (arr[i] == 0) {
                var j = arr.size - 1
                while (j > i) {
                    arr[j] = arr[j - 1]
                    j--
                }
                if (i < arr.size - 1) {
                    arr[i + 1] = 0
                    i++
                }
            }
            i++
        }
    }
}
