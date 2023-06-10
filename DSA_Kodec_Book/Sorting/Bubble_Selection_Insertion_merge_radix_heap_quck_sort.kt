/**
 * Bubble Sort
 * Selection Sort
 * Insertion Sort
 * Merge Sort
 * Radix Sort
 * Heap Sort
 * Quick Sort Native
 * **/
fun main() {
	val input = listOf(9,1,7,3,6,4,2,8,5)
    
    println("Bubble : ${bubble(input).toTypedArray().contentToString()}")
    println("Selection : ${selectionSort(input).toTypedArray().contentToString()}")
    println("Insertion : ${insertionSort(input).toTypedArray().contentToString()}")
    println("Merge : ${merge(input).toTypedArray().contentToString()}")   
    
    Heap<Int>().apply {
        input.forEach {
            insert(it)
        }
        
        heapifyToMax()
        println("Heap Sort : ${getSortedElements()}")
    }
    
    println("Quick : ${quick(input).toTypedArray().contentToString()}") 
    
}

//Time Complexity : O(n log_n)
//Space Complexity : O(log_n)
fun <T: Comparable<T>> quick(elements: List<T>) : List<T> {
    
    if(elements.size < 2) return elements
    
    val midIndex = elements.size/2
    val pivotElement = elements[midIndex]
    val lessThanPivot = elements.filter { it < pivotElement }
    val moreThanPivot = elements.filter { it > pivotElement }
    
    return quick(lessThanPivot) + pivotElement + quick(moreThanPivot)
}

//Time Complexity : 
    //For insertion : O(1)
    //For heapofy : O(n log_n)
//Space Complexity : O(1)
class Heap<T: Comparable<T>> {
    private val elements = mutableListOf<T>()
    private val removedValue = mutableListOf<T>()
    
    private val count:Int
    	get() = elements.size
    
    private val isEmpty: Boolean
    	get() = count == 0
    
    private fun leftChildIndex(index: Int) : Int = (2 * index) + 1
    private fun rightChildIndex(index: Int) : Int = (2 * index) + 2
    private fun parentIndex(index: Int) : Int = (index - 1) / 2
    
    fun insert(item: T) {
        elements.add(item)
        toMaxHeap(count-1)
    }
    private fun toMaxHeap(index: Int) {
        var currentIndex = index
        var parentIndex = parentIndex(currentIndex)
        
        if(elements[currentIndex] > elements[parentIndex]) {
            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
        }
        
        if(currentIndex != parentIndex) {
            toMaxHeap(parentIndex)
        }
    }
    
    fun remove(): T? {
        
        if(!isEmpty) {
            
            val lastIndex = count-1
            elements[0] = elements[lastIndex].also { elements[lastIndex] = elements[0]}
            val item = elements.removeAt(lastIndex)
            removedValue.add(item)
            toMaxAfterRemove(0)
            return item
        }
        
        return null
    }
    
    private fun toMaxAfterRemove(index: Int) {
        var currentIndex = index
        var parentIndex = currentIndex
        var leftChildIndex = leftChildIndex(currentIndex)
        var rightChildIndex = rightChildIndex(currentIndex)
        
        if(leftChildIndex < count && elements[leftChildIndex] > elements[currentIndex]) {
            currentIndex = leftChildIndex
        }
        if(rightChildIndex < count && elements[rightChildIndex] > elements[currentIndex]) {
            currentIndex = rightChildIndex
        }
        
        if(currentIndex != parentIndex) {
            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            toMaxAfterRemove(currentIndex)
        }
    }
    
    fun heapifyToMax() {
        if(!isEmpty) {
            remove()
            heapifyToMax()
        }
    }
    
    fun getSortedElements() : List<T> {
      	removedValue.reverse()
        return removedValue
    } 
}
 

 // Time Complexity : O(nd)
 //Space Complexity : O(n+d)
fun radixSort(list: List<Int>) :List<Int> {
    
    var elements = list.toMutableList()
    var base = 10
    var digits = 1
    var isDone = false
    
    while(!isDone) {
        //Step 1 : Initialization
        val buckets = mutableListOf<MutableList<Int>>().apply {
            (0 until base).forEach {
            	this.add(mutableListOf())    
            }
        }
        
        //Step 2 : Rotation
        elements.forEach {
            val division = it / digits
            val bucketIndex = division % base
            buckets[bucketIndex].add(it)
        	if(division > 0) isDone = false
        }
        
        //Step 3 : Updation
    	digits *= base
        elements.clear()
        elements.addAll(buckets.flatten())
    }
    
    return elements
}

//Time Complexity : O(n)
//Space Complexity : O(n)
fun <T: Comparable<T>> merge(elements: List<T>) : List<T> {
    if(elements.size < 2) return elements
    val midIndex = elements.size/2
    val leftList = elements.subList(0, midIndex)
    val rightList = elements.subList(midIndex,elements.size)
    
    return conquer(merge(leftList), merge(rightList))
}
fun <T: Comparable<T>> conquer(leftList: List<T>, rightList: List<T>) : List<T> {
    
    var leftIndex = 0
    var rightIndex = 0
    val list = mutableListOf<T>()
    
    while(leftIndex < leftList.size && rightIndex < rightList.size) {
        if(leftList[leftIndex] < rightList[rightIndex]) {
            list.add(leftList[leftIndex])
            leftIndex++
        } else {
            list.add(rightList[rightIndex])
            rightIndex++
        }
    }
    
    while(leftIndex < leftList.size) {
        list.add(leftList[leftIndex])
        leftIndex++
    }
    
    while(rightIndex < rightList.size) {
        list.add(rightList[rightIndex])
        rightIndex++
    }
    
    return list
}



//Time Complexity : O(n)
//Space Complexity : O(1)
fun <T: Comparable<T>> insertionSort(elements: List<T>) : List<T> {
	val list = elements.toMutableList()
    for(i in list.indices) {
        val key = list[i]
        var j = i-1
        
        while(j >= 0 && list[j] > key) {
            list[j+1] = list[j]
            j--
        }
        list[j+1] = key
    }
    return list
}


//Time Complexity : O(n*n)
//Space Complexity : O(1)
fun <T: Comparable<T>> selectionSort(elements: List<T>) : List<T> {
    val list = elements.toMutableList()
    for(i in list.indices) {
        var minValueIndex = i
        for(j in (i+1) until list.size) {
            if(list[minValueIndex] > list[j]) minValueIndex = j
        }
        
        if(minValueIndex != i) {
            list[minValueIndex] = list[i].also { list[i] = list[minValueIndex]}
        }
    }
    return list
}

//Time Complexity : O(n*n)
//Space Complexity : O(1)
fun <T: Comparable<T>> bubble(elements: List<T>) : List<T> {
    
    val list = elements.toMutableList()
    
    for(i in list.indices) {
        for(j in (i+1) until list.size) {
            if(list[i] > list[j]) list[i] = list[j].also{ list[j] = list[i] }
        }
    }
    return list
}
