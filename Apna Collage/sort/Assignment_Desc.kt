class Solution {
    fun bubbleSort(n: IntArray) {
        for (i in 0..<n.size) {
            for (j in 0..<n.size-1-i) {
                if (n[j] < n[j+1]) {
                    n[j] = n[j+1].also { n[j+1] = n[j] }
                }
            }
        }

        println("Bubble Sort: ${n.toTypedArray().contentToString()}")
    }

    fun selectionSortWay1(n: IntArray) {
        var minValueIndex = 0
        var start = 0
        var index = 0

        while (start < n.size) {
            minValueIndex = start
            index = start
            while (index < n.size) {
                if (n[minValueIndex] < n[index]) {
                    minValueIndex = index
                }
                index++
            }
            n[start] = n[minValueIndex].also { n[minValueIndex] = n[start] }
            start++
        }
        println("Selection Sort Way 1: ${n.toTypedArray().contentToString()}")
    }
    fun selectionSortWay2(n: IntArray) {
        var minIndex = 0
        for (i in 0 ..< n.size) {
            minIndex = i
            for (j in i+1 ..<n.size) {
                if (n[minIndex] < n[j]) {
                    minIndex = j
                }
            }
            n[i] = n[minIndex].also { n[minIndex] = n[i] }
        }

        println("Selection Sort Way 2: ${n.toTypedArray().contentToString()}")
    }

    fun insertionSort(n: IntArray) {
        for (i in 1 ..< n.size) {
            val current = n[i]
            var prev = i - 1

            while (prev >= 0 && n[prev] < current) {
                n[prev+1] = n[prev]
                prev--
            }
            n[prev+1] = current
        }
        println("Insertion Sort: ${n.toTypedArray().contentToString()}")
    }

    fun countingSort(n: IntArray) {
        val freq = IntArray(n.max() + 1)
        n.forEach {
            freq[it]++
        }
        var k = 0
        for (index in freq.size-1 downTo 0) {
            while (freq[index] > 0) {
                n[k++] = index
                freq[index]--
            }
        }
        println("Counting Sort: ${n.toTypedArray().contentToString()}")
    }
}
fun main() {
    Solution().apply {
        val list = intArrayOf(3,6,2,1,8,7,4,5,3,1)
        bubbleSort(list)
        selectionSortWay1(list)
        selectionSortWay2(list)
        insertionSort(list)
        countingSort(list)
    }
}

// Bubble Sort: [8, 7, 6, 5, 4, 3, 3, 2, 1, 1]
// Selection Sort Way 1: [8, 7, 6, 5, 4, 3, 3, 2, 1, 1]
// Selection Sort Way 2: [8, 7, 6, 5, 4, 3, 3, 2, 1, 1]
// Insertion Sort: [8, 7, 6, 5, 4, 3, 3, 2, 1, 1]
// Counting Sort: [8, 7, 6, 5, 4, 3, 3, 2, 1, 1]
