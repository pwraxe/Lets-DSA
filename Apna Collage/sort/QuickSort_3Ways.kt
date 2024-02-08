//Quick Sort by Taking:
    // First as Pivot
    // Last as Pivot
    // Mid as Pivot

class Solution {

    fun quickSortByFirstAsPivot(list:IntArray, low: Int, high: Int) {
        if (low < high) {
            val partitionIndex = getPartitionOfFirstAsPivot(list, low, high)

            //Left SubArray
            quickSortByFirstAsPivot(list, low, partitionIndex-1)

            //Right SubArray
            quickSortByFirstAsPivot(list, partitionIndex+1, high)
        }
    }
    private fun getPartitionOfFirstAsPivot(list: IntArray, low: Int, high: Int): Int {
        val pivot = list[low]
        var i = high + 1
        for (j in high downTo low+1) {
            if (list[j] >= pivot) {
                i--
                list[i] = list[j].also { list[j] = list[i] }
            }
        }

        //swapp(list[low], list[i-1])
        list[low] = list[i-1].also { list[i-1] = list[low] }
        return i-1
    }

    fun quickSortByLastAsPivot(list: IntArray, low: Int, high: Int) {
        if (low < high) {
            val partitionIndex = getPartitionOfLastAsPivot(list, low, high)

            //Left SubArray
            quickSortByLastAsPivot(list, low, partitionIndex-1)

            //Right SubArray
            quickSortByLastAsPivot(list, partitionIndex+1, high)
        }
    }
    private fun getPartitionOfLastAsPivot(list: IntArray, low: Int, high: Int): Int {
        val pivot = list[high]
        var i = low - 1
        for (j in low .. high-1) {
            if (list[j] <= pivot) {
                i++
                list[i] = list[j].also { list[j] = list[i] }
            }
        }

        list[i+1] = list[high].also { list[high] = list[i+1] }
        return i+1
    }

    fun quickSortByMidAsPivot(list: IntArray, low: Int, high: Int) {

        if (low < high) {
            val partitionIndex = getPartitionMidAsPivot(list, low, high)
            quickSortByMidAsPivot(list, low, partitionIndex-1)
            quickSortByMidAsPivot(list, partitionIndex, high)
        }


    }
    private fun getPartitionMidAsPivot(list: IntArray, low: Int, high: Int): Int {
        val mid = low + (high - low) / 2
        val pivot = list[mid]
        var i = low
        var j = high

        while (i <= j) {
            while (list[i] < pivot) i++
            while (list[j] > pivot) j--
            if (i <= j) {
                list[i] = list[j].also { list[j] = list[i] }
                i++
                j--
            }
        }
        return i
    }
}

fun main() {
    Solution().apply {
        val list1 = intArrayOf(7,1,6,9,8,3,4,5,2,0)
        quickSortByFirstAsPivot(list1,0,list1.size-1)
        println(list1.toTypedArray().contentToString())

        val list2 = intArrayOf(7,1,6,9,8,3,4,5,2,0)
        quickSortByLastAsPivot(list2,0,list2.size-1)
        println(list2.toTypedArray().contentToString())

        val list3 = intArrayOf(7,1,6,9,8,3,4,5,2,0)
        quickSortByMidAsPivot(list3,0,list3.size-1)
        println(list3.toTypedArray().contentToString())
    }
}
