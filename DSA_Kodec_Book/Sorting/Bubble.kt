fun main() {
    println("Sorted : ${bubbleSort(intArrayOf(8,2,5,4,1)).toTypedArray().contentToString()}")
}
//Time Complexity : O(n*n)
//Space Complexity : O(1)
fun bubbleSort(elements: IntArray): IntArray {
    //Sorts Elements from start or 0th index
    for (i in elements.indices) {
        for (j in (i + 1) until elements.size) {
            if (elements[i] > elements[j]) {
                elements[i] = elements[j].also { elements[j] = elements[i] } //Swap
            }
        }
    }
    return elements
}
