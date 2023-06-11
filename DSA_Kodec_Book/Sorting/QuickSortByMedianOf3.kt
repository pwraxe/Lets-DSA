/***
Logic : Before Sending List to lomuto partition 
check lowIndexElement, middleIndexElement, highIndexElement, 
swap in a such way, all three are sorted, (check sorted for --> low, middle, high) ex. 1 ..... 5 .....9
once done swap middleIndexElement with lastIndexElement, this converts balance list
We cant say lastIndexElement is max among remaining item, we swap only first, middle, and last index, 
there could be max or min value in middle of  5 to 9 and 1 to 5 respectivly
*/

fun main() {
   val input = mutableListOf(9,1,7,5,4,9,6,8,2,1,3)
   println("Quick Sort by Median of Three: ${quickSortByMedianOfThree(input,0,input.size-1).toList()}")
}


fun quickSortByMedianOfThree(list: MutableList<Int>, low: Int, high: Int) : List<Int> {
    if(low < high) {
        val pivotIndex = medianOfThree(list, low, high)
        list[pivotIndex] = list[high].also { list[high] = list[pivotIndex] }
        val pivotIndexByPartition = lomutoPartition(list, low, high)
        quickSortByMedianOfThree(list, low,pivotIndexByPartition-1)
        quickSortByMedianOfThree(list,pivotIndexByPartition+1, high)
    }
    
    return list.toList()
}

fun medianOfThree(list: MutableList<Int>, low: Int, high: Int) : Int {
    val middleIndex = (low + high) / 2
    if(list[low] > list[middleIndex]) {
        //Swap low and middle Index
        list[low] = list[middleIndex].also { list[middleIndex] = list[low] }
    }
    
    if(list[middleIndex] > list[high]) {
        //Swap middleIndex and high
		list[middleIndex] = list[high].also { list[high] = list[middleIndex] }
    }
    
    if(list[low] > list[high]) {
        //swap first and last index
		list[low] = list[high].also { list[high] = list[low] }
    }
    
    return middleIndex
}


fun lomutoPartition(list: MutableList<Int>, low: Int, high: Int) : Int {
	val pivot = list[high]
    var i = low 
    for(j in low until high) {
        if(list[j] <= pivot) {
            list[j] = list[i].also{ list[i] = list[j] }
            i++
        }
    }
    list[i] = list[high].also { list[high] = list[i] }
    return i
}
