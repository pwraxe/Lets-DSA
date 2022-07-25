fun main() {
    val charArray = charArrayOf('a','k','s','h','a','y')
    println(charArray)  //printing without d.quotes
    /**
     * When we print char array in string (in Double quotes) then prints =-> [C@59e84876
     * Where,
     * [C -> '[' -> Indicates Array && C indicates Character, Hence '[C' -> is Character Array
     * 59e84876 --> (~) Any hex values indicates stored location (~)
     * */
    println("$charArray | ${String(charArray)} |")

}
------------------------------------------------------
//String to Character Array
fun main() {
    //Method 1 :
    val test = "Hello This is Developer"
    println(test.toCharArray().contentToString())

    //Method 2 :
    val toCharArray = test.toCharArray()
    for (ch in toCharArray) {
        print("$ch ")
    }
    println()

    //Method 3 :
    for (index in test.indices) {
        print("${test.get(index)} ") //OR
        print("${test[index]} ")
    }
}
------------------------------------------------------
//Find Avg in array element
fun main() {
    val array = intArrayOf(2,5,8,5,4,7,8,5,6,9)
    var sum = 0
    for (element in array) {
        sum += element
    }
    val avg = sum.toDouble().div(array.size)
    println(avg)
}
------------------------------------------------------
//Concatenate Array
fun main() {
    val array1 = intArrayOf(10,30,50)
    val array2 = intArrayOf(20,40,60)
    val array3 = array1 + array2
    println(array3.contentToString())
}
------------------------------------------------------
//sort array in swipe method Ascending  Order
fun main() {

    //Method 1 :
    val array1 = intArrayOf(5,10,78,100,54,23,20)
    array1.sort()
    println(array1.contentToString())

    //Method 2 :
    var temp = 0
    val array2 = intArrayOf(14,52,87,10,3,65,72,98,12)
    /**
     * Analysis of Complexity
     * -> Both for() loop run 'n' times
     * -> outer for loop runs 'n' times
     * -> inner for loop runs 'n' times
     * -> so f(n) = O(n*n)
     * */

    for (i in array2.indices) {
        for (j in i+1 until array2.size) {

            if(array2[i] > array2[j]) {
                temp = array2[i]
                array2[i] = array2[j]
                array2[j] = temp
            }
        }
    }
    println(array2.contentToString())
}

------------------------------------------------------
//sort array in swipe method in Descending  Order
fun main() {

    //Method 1 :
    val array1 = intArrayOf(5,10,78,100,54,23,20)
    array1.sortDescending()
    println(array1.contentToString())

    //Method 2 :
    var temp = 0
    val array2 = intArrayOf(14,52,87,10,3,65,72,98,12)
    /**
     * Analysis of Complexity
     * -> Both for() loop run 'n' times
     * -> outer for loop runs 'n' times
     * -> inner for loop runs 'n' times
     * -> so f(n) = O(n*n)
     * */

    for (i in array2.indices) {
        for (j in i+1 until array2.size) {

            if(array2[i] < array2[j]) {
                temp = array2[i]
                array2[i] = array2[j]
                array2[j] = temp
            }
        }
    }
    println(array2.contentToString())
}

------------------------------------------------------
fun main() {
    val array = intArrayOf(1,8,3,6,1,9,7,5,1,0)

    //For Ascending Order
    for (i in array.indices) {
        for (j in i+1 until array.size) {

            if(array[i] > array[j]) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }

    //For Descending Order
    for (i in array.indices) {
        for (j in i+1 until array.size) {

            if(array[i] < array[j]) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }

    println(array.contentToString())
}
------------------------------------------------------
//Find Smallest and Largest Element in Array
fun main() {
    val array = intArrayOf(1,8,3,6,1,9,7,5,1,0)
    var max = 0
    var min = 0
    for (element in array) {
        if(element > max)
            max = element

        if(element < min) {
            min = element
        }
    }
    println("$min .. $max")
}
------------------------------------------------------
//Check Element founds in array or not
fun main() {
    val array = intArrayOf(1,8,3,6,1,9,7,5,1,0)
    val key = 50
    var isKeyContains = false

    for (element in array) {
        if(element == key) isKeyContains = true
    }
    println(if(isKeyContains) "Yes $key Found in Array" else "No $key Not found")
}
------------------------------------------------------

