class Solution {
    fun bubbleSort(numbs:IntArray) {
        println("Bubble Sort: ")
        for (i in 0 .. numbs.size-2) {
            for (j in i+1 ..< numbs.size) {
                if (numbs[i] > numbs[j]) {
                    numbs[i] = numbs[j].also { numbs[j] = numbs[i] }
                }
            }
        }
        println(numbs.toTypedArray().contentToString())
    }
    fun selectionSort(numbs: IntArray) {
        println("Selection Sort: ")
        for (i in numbs.indices) {
            var minIndex = i

            for (j in i+1 ..< numbs.size) {
                if (numbs[minIndex] > numbs[j]) {
                    minIndex = j
                }
            }
            numbs[minIndex] = numbs[i].also { numbs[i] = numbs[minIndex] }
        }
        println(numbs.toTypedArray().contentToString())
    }
    fun insertionSort(numbs: IntArray) {
        println("Insertion Sort: ")
        for (i in 1 ..< numbs.size-1) {
            var j = i-1
            val key = numbs[i]
            while (j > 0 && numbs[j] > key) {
                numbs[j+1] = numbs[j]
                j--
            }
            numbs[j+1] = key
        }
        println(numbs.toTypedArray().contentToString())
    }
    fun countingSort(numbs: IntArray) {
        println("Counting Sort:")
        val count = IntArray(numbs.max()+1)
        numbs.forEach {
            count[it]++
        }

        var c = 1
        var n = 0
        while (c < count.size) {
            if (count[c] != 0) {
                numbs[n] = c
                count[c]--
                n++
            } else {
                c++
            }
        }
        println(numbs.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        val numbs = intArrayOf(5,4,1,3,2)
        bubbleSort(numbs)
        println()
        selectionSort(numbs)
        println()
        insertionSort(numbs)
        println()
        countingSort(numbs)
    }
}


Bubble Sort: 
[1, 2, 3, 4, 5]

Selection Sort: 
[1, 2, 3, 4, 5]

Insertion Sort: 
[1, 2, 3, 4, 5]

Counting Sort:
[1, 2, 3, 4, 5]
