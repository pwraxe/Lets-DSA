import kotlin.math.min
import kotlin.math.sqrt

/**
* Time Complexity: O(√n)
* Space Complexity: O(1)
**/

fun main() {
    val list = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    println(list.jumpSearch(4))
    println(list.letsJumpOwnWay(8))
    println(list.jumpedSearch(16))
}


/***
 *
 * We can calculate, step size
 * Lets Calculate,
 * Suppose array size is  : n
 * total steps to skip is : m
 * linear search for found element in range is : m-1
 * Hence,
 *  f(n) = (n/m) + (m-1)
 *       = n + m*m - m
 *       = m*m + n
 *     m = sqrt(n)
 *
 *     skipStep = sqrt(arraySize)
 * **/

//Jumped Search, Tried My Own
fun <T : Comparable<T>> List<T>.jumpSearch(element: T) : Int {

    //ready prevIndex and currentIndex at beginning
    var prevIndex = 0
    var currentIndex = 0
    var stepSize = 4

    do {

        prevIndex = currentIndex
        currentIndex = stepSize

        //Check element is in range
        if(element in this[prevIndex] .. this[currentIndex]) break

        //Add more 4 steps
        stepSize += 4

        //Control stepSize if goes beyond given array size
        if(stepSize >= this.size) stepSize = this.size-1

        //check if prevIndex and current index at end (or same)
        if(prevIndex == currentIndex) break

    }while (stepSize <= this.size)

    //this checks if element in list
    for (index in prevIndex .. currentIndex) {
        if(this[index] == element) return index
    }

    //return -1 i.e No Element found in list
    return -1

    //Complexity : O(n*n)
    //two loops used in this code

}

//We are making sure, list is sorted
fun <T : Comparable<T>> List<T>.letsJumpOwnWay(element: T) : Int {

    var prevIndex = 0
    var currentIndex = 0
    var skipStep = sqrt((this.size-1).toDouble()).toInt()
    do {

        prevIndex = currentIndex
        currentIndex = skipStep

        if(element in this[prevIndex] .. this[currentIndex]) {
            for (index in prevIndex..currentIndex) {
                if(this[index] == element) {
                    return index
                }
            }
        }
        skipStep += skipStep

        if(skipStep >= this.size)  skipStep = this.size-1
        if(prevIndex == currentIndex) break

    }while (skipStep <= this.size)

    return -1

}

//FROM BOOK
fun <T : Comparable<T>> List<T>.jumpedSearch(element: T) : Int  {

    val size = this.size
    var stepsToSkip = sqrt((size-1).toDouble()).toInt()
    var prevIndex = 0

    while (this[min(stepsToSkip,size)-1] < element) {
        prevIndex = stepsToSkip
        stepsToSkip *= 2
        if(prevIndex >= size) return -1
    }

    while (this[prevIndex] < element) {
        prevIndex++
        if(prevIndex == min(stepsToSkip, size)) return -1
    }

    if (this[prevIndex] == element) {
        return prevIndex
    }

    return -1
}
