import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val list = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    println("Index : ${list.expSearch(200)}")
}

/**
 * -> Exponential Search is Same as Jumped Search
 * -> In Exponential Search the stepSize would be 1,2,4,8,16,32,64,... i.e (2.pow(n))
 * -> if index value is grater than element, do binarySearch instead of linear search
 * **/
fun <T : Comparable<T>> List<T>.expSearch(element : T) : Int {

    var prevIndex = 0
    var currentIndex = 0
    var stepSize = 1

    do {

        prevIndex = currentIndex
        currentIndex = stepSize

        if(element in this[prevIndex] .. this[currentIndex]) {
            //do Binary Search here

            var startIndex = prevIndex
            var endIndex = currentIndex

            while (startIndex <= endIndex) {

                val midIndex = (startIndex + endIndex) / 2
                val midIndexValue = this[midIndex]

                if(midIndexValue > element) endIndex = midIndex - 1
                else if(midIndexValue < element) startIndex = midIndex + 1
                else return midIndex
            }
        }
        stepSize *= 2
        //Control step size if beyond array size
        if(stepSize > this.size) stepSize = this.size-1

        //check currentIndex and prevIndex is end of array
        if( prevIndex == currentIndex ) return -1

    }while (stepSize <= this.size)

    return -1

}
