fun main() {
    val list = listOf<Int>(50,421,985,430,77,430,652,100)
    println("Radix: ${list.toMutableList().radixSort().toTypedArray().contentToString()}")
}

//Time Complexity : O(n*d)
    //n = size of array
    //d = digits of largest no
//Space Complexity : O(n+k)
    //n = no of element in input array
    //k = largest element among digits,th place
fun MutableList<Int>.radixSort(): MutableList<Int> {

    val base = 10
    var done = false
    var digits = 1

    while (!done) {
        done = true
        //Let's Create Bucket, which is Array of Array
        val bucket = arrayListOf<MutableList<Int>>()
        (0 until base).forEach {
            bucket.add(arrayListOf())
        }

        this.forEach { no ->
            val remainingPart = no/digits
            val currentDigits = remainingPart % base
            bucket[currentDigits].add(no)
            if(remainingPart > 0) {
                done = false
            }
        }

        digits *= base
        this.clear()
        this.addAll(bucket.flatten())
    }

    return this
}
