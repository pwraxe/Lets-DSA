fun main() {
    val list = listOf(1,2,3,4,5,6,7,8,9)
    val index = binarySearch(3,list)
    println("Index : $index | Value : ${list[index]}")
}

fun binarySearch(key: Int, list: List<Int>) : Int {

    var startIndex = 0
    var endIndex = list.size-1

    while (startIndex < endIndex) {
        val middleIndex = (startIndex + endIndex) / 2
        if(key > list[middleIndex]) startIndex = middleIndex+1
        else if(key < list[middleIndex]) endIndex = middleIndex-1
        else return middleIndex
    }
    return -1
}
//------------------------------------------------------------------------------
fun main() {
    //val list = arrayListOf("A","B","C","D","E","F","G","H","I","J","K","L")
    val list = arrayListOf(1,2,3,4,5,6,7,8,9,10,11,12)
    println("Index : ${list.binarySearch(10)}")
    println("Index - ${binSearch(list,6)} \n")


    //Revision
    val comp = "1.c(1) : ${1.compareTo(1)} \n" +    // 0
            "1.c(2) : ${1.compareTo(2)} \n" +       //-1
            /**
             * Ex. Internal Comparison
             * if(1 > 2) return 1
             * if(1 < 2) return -1
             * if(1 == 2) return 0
             * **/
            "2.c(1) : ${2.compareTo(1)} \n" +       // 2 > 1 => 1
            "2.c(2) : ${2.compareTo(2)} \n"         // 0

    println(comp)
}

//------------------------------------------------------------------------------
//Fourth Time
//Here I am comparing element with list element,
//based on comparison, will go foreword or backward
fun <T : Comparable<T>> List<T>.binSearch(element: T) : Int {

    var startIndex = 0
    var endIndex = this.size-1

    while (startIndex <= endIndex) {

        val midIndex = (startIndex + endIndex) / 2
        val midValue = this[midIndex]

        if (midValue > element) endIndex = midIndex - 1
        else if (midValue < element) startIndex = midIndex + 1
        else return midIndex
    }

    return -1
}

//------------------------------------------------------------------------------

//Third Time
//Best Case Scenario in The Worst Case Scenario     :   O(log n)
fun <T : Comparable<T>> List<T>.binSearch(element: T) : Int {

    var startIndex = 0
    var endIndex = this.size-1

    while (startIndex <= endIndex) {
        val midIndex = (startIndex + endIndex) / 2
        val valueAtIndex = this[midIndex]
        val compValue = valueAtIndex.compareTo(element)

        if(compValue < 0) startIndex = midIndex + 1
        else if(compValue > 0) endIndex = midIndex - 1
        else return midIndex
    }
    return -1
}

//------------------------------------------------------------------------------

//Second Time
fun binSearch(list: ArrayList<Int>, element: Int) : Int {

    var start = 0
    var end = list.size-1
    while (start <= end) {
        val midIndex = (start + end) / 2
        val valueAtIndex = list[midIndex]
        val comp = valueAtIndex.compareTo(element)
        if(comp > 0) end = midIndex - 1
        else if(comp < 0) start = midIndex + 1
        else return midIndex
    }
    return -1
}


//------------------------------------------------------------------------------


//First Time
fun <T : Comparable<T>> List<T>.binarySearch(element:T) : Int {
    var start = 0
    var end = this.size-1

    while (start <= end) {
        val mid = (start + end) / 2
        val midValue = this[mid]
        val comp = midValue.compareTo(element)
        if(comp < 0) start = mid+1
        else if (comp > 0) end = mid - 1
        else return mid
    }
    return -1
}

