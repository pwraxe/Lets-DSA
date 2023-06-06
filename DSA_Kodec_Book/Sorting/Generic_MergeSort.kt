/**
 * Merge Sort for
 * - Integer
 * - String
 * - Character
 * **/

fun main() {

    val input1 = listOf<Int>(8,5,2,1,4,7,9,6,3,0) //Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    println("Merge Sort Int : ${divide(input1).toTypedArray().contentToString()}") 

    val input2 = listOf<String>("Hello","Work","Gym","World","Time","Space") //Output : [Gym, Hello, Space, Time, Work, World]
    println("Merge Sort String : ${divide(input2).toTypedArray().contentToString()}")

    val input3 = listOf<Char>('a','k','s','h','a','y') //[a, a, h, k, s, y]
    println("Merge Sort Char : ${divide(input3).toTypedArray().contentToString()}")


}

fun <T: Comparable<T>> divide(element: List<T>): List<T> {
    if(element.size < 2) return element

    val middleIndex = element.size/2
    val leftList = element.subList(0, middleIndex)
    val rightList = element.subList(middleIndex,element.size)
    return conquer(divide(leftList), divide(rightList))
}

fun <T: Comparable<T>> conquer(leftList:List<T>, rightList:List<T>) : List<T> {
    var leftIndex = 0
    var rightIndex = 0
    val list = mutableListOf<T>()

    while (leftIndex < leftList.size && rightIndex < rightList.size){
        if(leftList[leftIndex] < rightList[rightIndex]) {
            list.add(leftList[leftIndex])
            leftIndex++
        } else {
            list.add(rightList[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < leftList.size){
        list.add(leftList[leftIndex])
        leftIndex++
    }

    while (rightIndex < rightList.size) {
        list.add(rightList[rightIndex])
        rightIndex++
    }

    return list
}
