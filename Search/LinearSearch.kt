
//Linear Search, Old Approch
fun main() {
    val list = arrayListOf("A","B","C","D","E","F")
    println(list.linearSearch("C"))
    println(list.searchInSortedList("E"))
}

//Here, in Addition to the equality check, we also check which is grater, so type T should impl Comparable interface
fun <T: Comparable<T>> Collection<T>.searchInSortedList(element: T) : Int {
    for ((index, value) in this.withIndex()) {
        if(value == element) return index
        else {
            if(value > element) return -1
        }
    }
    return -1
}

fun <T> Collection<T>.linearSearch(element: T) : Int {
    for ((index,value) in this.withIndex()) {
        if(element == value) return index
    }
    return -1
}
//Time Complexity : O(n)
