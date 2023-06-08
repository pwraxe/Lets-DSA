fun main() {
    val input = mutableListOf<Int>(500, 1345, 13, 459, 44, 999)
    println("RadixSort : ${radixSort(input).toTypedArray().contentToString()}")
}

fun radixSort(elements: MutableList<Int>) : List<Int> {

    /**
     *
     * Lets Devide Radix Sort in 3 functionality
     *
     * 1. Initialisation
     * 2. Rotation
     * 3. Updation
     *
     * **/


    val base = 10
    var digit = 1
    var isDone = false

    while (!isDone) {
        isDone = true

        //1. Initialisation
        val bucket = mutableListOf<MutableList<Int>>().apply {
            (0 until base).forEach {
                this.add(mutableListOf())
            }
        }

        //2. Rotation
        elements.forEach {
            val division = it / digit
            val bucketIndex = division % base
            bucket[bucketIndex].add(it)
            //try to stop loop
            if(division > 0) isDone = false
        }

        //3. Updation
        digit *= base
        elements.clear()
        elements.addAll(bucket.flatten())
    }

    return elements

}
