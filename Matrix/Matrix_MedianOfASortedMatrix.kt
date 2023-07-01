fun main() {

    val matrix = arrayOf(
        intArrayOf(10, 20, 30, 40),
        intArrayOf(15, 25, 35, 45),
        intArrayOf(27, 29, 37, 48),
        intArrayOf(32, 33, 39, 50)
    )
    val med = findMedian(matrix, matrix.size, matrix[0].size)
    println("Med : $med")
}

fun findMedian(matrix: Array<IntArray>, row: Int, column: Int) : Int {

    //totalElements = 16
    val totalElements = row * column

    //midIndex = 8
    val midIndex = totalElements / 2

    //startElement = 10
    var startElement = matrix[0][0]

    //endElement = 50
    var endElement = matrix[row-1][column-1]

    //while(10 <= 50)
    while (startElement <= endElement) {

        //Based on startElement and endElement range becomes --> (10 .. 50)
        //find midElement by given range
        //midElementFromRange = (10+50) / 2 = 60/2 = 30
        val midElementFromRange = startElement + (endElement - startElement) / 2

        //find total elements which is smaller or equal than 30 which is now 7
        val smallerElements = findSmallerElements(matrix, midElementFromRange)

        //smallerElements = 7
        //midIndex = totalElements/2 = 16/2 = 8
        //if(7 <= 8)
        if(smallerElements <= midIndex) {
            //startElement = 31
            startElement = midElementFromRange+1
        } else {
            //endElement = 29
            endElement = midElementFromRange - 1
        }
    }
    return startElement
}

fun findSmallerElements(matrix: Array<IntArray>, midIndexElement: Int): Int {

    var smallerElementsCount = 0
    matrix.forEach {
        var startIndex = 0
        var endIndex= it.size - 1
        while (startIndex <= endIndex) {
            val midIndex = startIndex + (endIndex - startIndex) / 2
            if(it[midIndex] <= midIndexElement) {
                startIndex = midIndex+1
            } else {
                endIndex = midIndex-1
            }
            smallerElementsCount += startIndex
        }
    }
    return smallerElementsCount
}

