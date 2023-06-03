//Problem: is List contains only odd numbers?
fun main() {
    val list1 = listOf(1,2,3,4,5,6,7,9)
    println("is List Contains only Odd Numbers? : ${isListContainsOddNo(list1)}")
    
    val list2 = listOf(1,3,5,7,9)
    println("is List Contains only Odd Numbers? : ${isListContainsOddNo(list2)}")
}

//Method 1
fun isListContainsOddNo(list: List<Int>) : Boolean {
    list.forEach {
        if(it % 2 == 0) return false
    }
    return true
}

//Method 2
fun isListContainsOddNo(list: List<Int>) : Boolean {
    //returns true if all element is even
    val isAllEven = list.all { it % 2 == 0 }
    
    //return true if all element is odd
    val isAllOdd = list.all { it % 2 == 1 }
    
 	return isAllOdd
}
