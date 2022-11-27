fun main() {
    val list = intArrayOf(8,3,2,6,20,14,5,8,11,1).bubbleSort()
    println(list.contentToString())
}

/**
* Complexity : O(n*m)
* WhereAs, n is outer loop,
*          m is inner loop
*
***/

fun IntArray.bubbleSort() : IntArray {

    /**
     * There are two for loop which runs/exe 'n' times
     * Logic of Bubble Sort :
     * outer loop 'i' will go end of list
     * inner loop will go before no of steps i increase
     * when inner loop completes 1 element get sorted, and it will be the biggest element at the end
     * all sorting based on j and j+1 it swaps if next element(j+1) is smaller than prev.(j)
     * As 'i' increase,size of j decrease
     * **/
  
    val len = size
    for (i in 0 until (len-1)) {
        for (j in 0 until (len-i-1)) {
            if (this[j] > this[j+1]) {
                val temp = this[j]
                this[j] = this[j+1]
                this[j+1] = temp
            }
        }
    }
    return this
}
