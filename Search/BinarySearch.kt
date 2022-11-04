
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

