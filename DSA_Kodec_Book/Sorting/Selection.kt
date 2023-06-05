fun main() {
   println("Selection Sorted : ${selectionSort(intArrayOf(8,2,5,4,1)).toTypedArray().contentToString()}")
}

//Time Complexity: O(n*n)
//Space Complexity: O(1)
fun selectionSort(list: IntArray) : IntArray {
    for(i in list.indices) {
        var minValueIndex = i
        for(j in (i+1) until list.size) {
            if(list[minValueIndex] > list[j]) minValueIndex = j
        }
        
        if(minValueIndex != i) {
            list[i] = list[minValueIndex].also { list[minValueIndex] = list[i] }
        }
    }
    return list
}
