import kotlin.collections.plus as plus1

fun main() {
    /** Source Code : List of array multiple of 10 to 500 **/
    val list = Array(51){ it * 10 }
    println(elementOnlyFromEvenIndex(list).contentToString())

    /** Source Code : Add 2 List of same type **/
    val list1 = arrayOf(1,2,3,4,5)
    val list2 = arrayOf(11,22,33,44,55)
    val result = list1.plus1(list2)
    println("Added List = ${result.contentToString()}")

    /**Source Code : convert wrapper typed array to a primitive array**/
    val wrappedInt = list.toIntArray()
    val wrappedDouble = arrayOf(1.1,2.2,3.3,4.4,5.5).toDoubleArray()
    println("WrappedInt : ${wrappedInt.contentToString()} | WrappedDouble : ${wrappedDouble.contentToString()}")
}

fun elementOnlyFromEvenIndex(list : Array<Int>): IntArray
{
    return list.filterIndexed { index, _ ->
        index %2 ==0
    }.toIntArray()
}
//OUTPUT : [0,10,20,30,...,480,490,500]

