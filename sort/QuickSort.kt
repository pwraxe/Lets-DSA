/**
 * * Quick Sort is Same As Merge Sort
 * * Quick Sort Uses Divide and Conquer Technique
 * * It Sorts Faster in Less Memory
 * * Complexity of Quick Sort is O(n log n) / O(n*n) in worst case
 * * It uses any element as pivot element to partition elements
 * * you can take first, last, middle or any random element as pivot element
 *
 * **/


fun main() {
    val list = intArrayOf(7,3,8,4,2,9,1,5)
    sortList(list,0,list.size-1)
}
private fun sortList(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)
        sortList(arr, low, partitionIndex - 1)
        sortList(arr, partitionIndex + 1, high)
    }
}

private fun partition(arr: IntArray, low: Int, high: Int): Int {
    /**Taking Last Element as Pivot element**/
    val pivot = arr[high]

    var i = low - 1

    for (j in low until high) {

        //if any element is Less than pivot, it supposes to move / swap
        if (arr[j] <= pivot) {
            i++

            //Swap
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp

            //OR Alternative Method for Sorting
            //arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    /**Swaps the pivot to its original index**/
    val temp = arr[high]
    arr[high] = arr[i + 1]
    arr[i+1] = temp
    
    /**Alternative Method for Swapping**/
    //arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    
    return i + 1;
}
