//Find Non-Reapeating Element from list
//TC: O(n) --> Going end of loop
//SC: O(1) --> No Extra space using 
fun main() {

    val list = listOf(1,1,2,3,3,4,4,5,5)

    var index = 0
    var element = list[0]
    while (index < list.size-1) {
        element = element xor list[index+1]
        index++
    }
    println(element)
}
