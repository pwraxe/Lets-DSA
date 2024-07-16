//Bubble Sort ASC
//Bubble Sort DESC
//Selection Sort ASC
//Selection Sort DESC

class Solution {

    fun bubbleSortASC(list: IntArray) {

        repeat(list.size-1) {
            for (j in 0 ..< list.size-1) {
                if (list[j] > list[j+1]) {
                    list[j] = list[j+1].also { list[j+1] = list[j] }
                }
            }
        }
        println(list.toTypedArray().contentToString())
    }
    fun bubbleSortDESC(list: IntArray) {

        repeat(list.size-1) {
            for (j in 0 ..< list.size-1) {
                if (list[j] < list[j+1]) {
                    list[j] = list[j+1].also { list[j+1] = list[j] }
                }
            }
        }
        println(list.toTypedArray().contentToString())
    }

    fun selectionSortASC(list: IntArray) {

        for (i in list.indices) {
            var minIndex = i
            for (j in i+1 ..< list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }
            list[i] = list[minIndex].also { list[minIndex] = list[i] }
        }

        println(list.toTypedArray().contentToString())
    }
    fun selectionSortDESC(list: IntArray) {

        for (i in list.indices) {
            var minIndex = i
            for (j in i+1 ..< list.size) {
                if (list[j] > list[minIndex]) {
                    minIndex = j
                }
            }
            list[i] = list[minIndex].also { list[minIndex] = list[i] }
        }

        println(list.toTypedArray().contentToString())
    }
}

fun main() {

    Solution().apply {
        val list = intArrayOf(5,1,7,2,4,3,9,6,8,1,2)
        bubbleSortASC(list)
        bubbleSortDESC(list)
        println("========================================")
        selectionSortASC(list)
        selectionSortDESC(list)
        println("========================================")

    }
}


[1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9]
[9, 8, 7, 6, 5, 4, 3, 2, 2, 1, 1]
========================================
[1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9]
[9, 8, 7, 6, 5, 4, 3, 2, 2, 1, 1]
