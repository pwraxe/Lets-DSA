class Assignment {

    //Question-1: Merge Sort on String, Without Space
    fun mergeSortOnString(list: Array<String>, start: Int, end: Int) {
        if (start < end) {
            val mid = start + (end - start) / 2
            mergeSortOnString(list, start, mid)
            mergeSortOnString(list, mid+1, end)
            combineString(list, start, mid, end)
        }
    }
    private fun combineString(list:Array<String>, start: Int, mid: Int, end: Int) {
        var i = start
        var j = mid+1
        var k = 0
        val temp = Array<String>(end - start+1) { "" }

        while (i <= mid && j <= end) {
            temp[k++] = if (list[i] < list[j]) {
                list[i++]
            } else list[j++]
        }

        while (i <= mid) {
            temp[k++] = list[i++]
        }

        while (j <= end) {
            temp[k++] = list[j++]
        }

        var indx = start
        var index = 0
        while (index < temp.size) {
            list[indx++] = temp[index++]
        }
    }

    //Question-2: The Majority of Element
    fun majorityElement(list: IntArray): Int {
        val hashMap = hashMapOf<Int,Int>()
        list.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        hashMap.forEach {
            if (it.value > list.size/2) return it.key
        }
        return -1
    }

    //Question-3: Inversion Count
    fun getInversionCountByNative(list: IntArray): Int {
        var count = 0
        for (i in list.indices) {
            for (j in i+1 ..< list.size) {
                if (list[i] > list[j]) count++
            }
        }
        return count
    }
    fun getInversionCountByMergeSort(list: IntArray, start: Int, end: Int): Int {
        var count = 0
        if (start < end) {
            val mid = start + (end - start) / 2
            count = getInversionCountByMergeSort(list, start, mid)
            count += getInversionCountByMergeSort(list, mid+1, end)
            count += mergeSort(list, start, mid+1, end)
        }
        return count
    }
    fun mergeSort(list: IntArray, start: Int, mid:Int, end: Int): Int {
        var i = start
        var j = mid
        var count = 0
        val temp = IntArray(end - start + 1)
        var k = 0
        while (i < mid && j <= end) {
            if (list[i] <= list[j]) {
                temp[k++] = list[i++]

            } else {
                temp[k++] = list[j++]
                count += (mid - i)
            }
        }

        while (i < mid) temp[k++] = list[i++]
        while (j <= end) temp[k++] = list[j++]
        return count
    }

}

fun main() {
    Assignment().apply {
        val list1 = arrayOf("sun", "earth", "mars", "mercury")
        mergeSortOnString(list1,0,list1.size-1)
        println(list1.contentToString())

//        val list2 = intArrayOf(3,2,3)
        val list2 = intArrayOf(2,2,1,1,1,2,2)
        println(majorityElement(list2))

        val list3 = intArrayOf(8, 4, 2, 1)
        println(getInversionCountByNative(list3))
        println("Inv Count By MS: ${getInversionCountByMergeSort(list3,0,list3.size-1)}")

        val list4 = intArrayOf(1, 20, 6, 4, 5)
        println("Inv Count By MS: ${getInversionCountByMergeSort(list4,0,list4.size-1)}")
    }
}

[earth, mars, mercury, sun]
2
6
Inv Count By MS: 6
Inv Count By MS: 5
