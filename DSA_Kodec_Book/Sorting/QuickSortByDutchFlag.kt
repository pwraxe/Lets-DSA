fun main() {
   val input = mutableListOf(9,9,2,9,5,1,1,2,1,2,5,5)
   println("Quick Sort by Dutch Flag : ${quickSortByDutchFlag(input,0,input.size-1).toList()}")
}

fun quickSortByDutchFlag(list: MutableList<Int>, low: Int, high: Int) : List<Int>{
    if(low < high) {
        val middleIndex = dutchFlagPartition(list, low, high)
        quickSortByDutchFlag(list, low, middleIndex.first-1)
        quickSortByDutchFlag(list, middleIndex.second+1, high)
    }
    return list.toList()
}


fun dutchFlagPartition(list: MutableList<Int>, low: Int, high: Int) : Pair<Int, Int> {
    val pivot = list[high]
    var smallerIndex = low
    var largerIndex = high
    var equalIndex = low
    while(equalIndex <= largerIndex) {
        
        if(list[equalIndex] < pivot) {
        
            list[smallerIndex] = list[equalIndex].also { list[equalIndex] = list[smallerIndex] }    
            smallerIndex++
            equalIndex++
        
        } else if(list[equalIndex] == pivot) {
            equalIndex++
        } else {
            list[equalIndex] = list[largerIndex].also { list[largerIndex] = list[equalIndex] }
            largerIndex--
        }
    }
    
    return Pair(smallerIndex, largerIndex)
}
