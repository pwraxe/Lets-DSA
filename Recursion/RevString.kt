//Reverse a String
fun main() {
    
    //Method 1 | TC: O(n) | SC: O(n)
    val list = "Akshay".toCharArray()
    var rev = ""
    for(index in list.size-1 downTo 0) {
        rev += list[index]
    }
    println(rev)
	
    //Method 2 | TC: O(n) | SC: O(n)
    var start = 0
    var end = list.size-1
    while(start < end) {
        list[start] = list[end].also { list[end] = list[start] }
        start++
        end--
    }
    
    println(list)
    
    //Method 3 | TC: O(n) | SC: O(1)
    val revS = rev("Akshay")
    println("Rev: $revS")
}


fun rev(s:String) : String {
    if(s.length == 0) return s
    return rev(s.substring(1)) + s[0]
}
