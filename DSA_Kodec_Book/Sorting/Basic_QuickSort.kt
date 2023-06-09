fun main() {
    val input = intArrayOf(9,7,6,4,3,1,2,8,6,4,5)
    println(input.toList().quickSort())
}

//Time Complexity: O(n*log_n)
//Space Complexity : O(log_n)
fun <T: Comparable<T>> List<T>.quickSort() : List<T> {
    
    //Base code
    if(this.size < 2) return this
  
    //Middle element as Pivot Element
    val pivot = this[size/2]
    
    //Filter all elements which is less than pivot element
    val smallThanPivot = filter { it < pivot }
    
    //Filter all elements which is more than pivot element
    val graterThanPivot = filter { it > pivot }
    
    //Filter elements which is equal to pivot
    val equalThanPivot = filter { it == pivot }

    //Join them by using recursion
    return smallThanPivot.quickSort() + equalThanPivot + graterThanPivot.quickSort()
}
