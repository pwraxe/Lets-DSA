//1: Bubble Sort //DONE
//2: Selection Sort
//3: Insertion Sort

fun main() {
    val input1 = listOf<Char>('a','k','s','h','a','y') //Output : [a, a, h, k, s, y]
    val input2 = listOf<Int>(8,2,1,9,4,3,6,7,5) //Output : [1,2,3,4,5,6,7,8,9]
    val input3 = listOf<String>("Hello","Work","Gym","World","Time","Space")  //Output : [Gym, Hello, Space, Time, Work, World]
    println("Bubble Sort : ${bubbleSort(input1).toTypedArray().contentToString()}")
    println("Selection Sort : ${selectionSort(input1).toTypedArray().contentToString()}")
    println("Insertion Sort : ${insertionSort(input1).toTypedArray().contentToString()}")
}

//Time Complexity : O(n*n)
//Space Complexity : O(1)
fun <T: Comparable<T>> bubbleSort(elements: List<T>) : List<T> {
    val list : MutableList<T> = elements.toMutableList()
    for (i in list.indices) {
        for (j in (i+1) until list.size) {
            if(list[i] > list[j]) {
                list[i] = list[j].also { list[j] = list[i] }
            }
        }
    }
    return list
}

//Time Complexity : O(n*n)
//Space Complexity : O(1)
fun <T: Comparable<T>> selectionSort(elements: List<T>) : List<T> {

    val list = elements.toMutableList()
    for (i in list.indices) {

        var minValueIndex = i

        for (j in (i+1) until list.size) {
            if(list[minValueIndex] > list[j]) minValueIndex = j
        }

        if(minValueIndex != i) {
            list[minValueIndex] = list[i].also { list[i] = list[minValueIndex] }
        }
    }
    return list
}

//Time Complexity : O(n)
//Space Complexity : O(1)
fun <T: Comparable<T>> insertionSort(elements: List<T>) : List<T> {

    val list = elements.toMutableList()
    for (i in 1 until list.size) {
        val key = list[i]
        var j = i-1
        while (j >= 0 && list[j] > key) {
            list[j+1] = list[j]
            j--
        }
        list[j+1] = key
    }

    return list
}
