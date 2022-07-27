fun main() {

    val test = "this is my simple string"
    var capitalisedSentence = ""
    for (word in test.split(" ")) {
        capitalisedSentence += "${word[0].uppercase()}${word.substring(1)} "
    }
    println(capitalisedSentence)
}

========================================================================================================================
fun main() {

    val list = arrayListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    //Solution 1
    val filteredOdds = list.filter { it % 2 == 1 }
    println(filteredOdds)

    //Solution 2
    val getOdds = getOdds(list)
    println(getOdds)

    val getOddByHelper = getOddsFromNestedFunction(list)
    println(getOddByHelper)
}

//nested function
private fun getOddsFromNestedFunction(list: List<Int>) : List<Int> {

    val oddsList = mutableListOf<Int>()

    //Define Method
    fun helper(list: List<Int>) {
        if(list.isEmpty()) return

        if(list.first() % 2 == 1) {
            oddsList.add(list.first())
        }
        helper(list.drop(1))
    }

    //Call helper method for first time
    helper(list)


    return oddsList

}

private fun getOdds (list: List<Int>): List<Int> {

    if(list.isEmpty()) return list

    return  if(list.first() % 2 == 1) {
        mutableListOf(list.first()) +  getOdds(list.drop(1))
    } else getOdds(list.drop(1))
}
========================================================================================================================
fun main() {
    println(isInRange(5..10,4..12)) //true
    println(isInRange(5..10,6..20)) //false

    println(isFirstRangeInSecond(1..10,5..8)) // true
    println(isFirstRangeInSecond(5..10,3..18)) // false
}

fun isInRange(range1: IntRange, range2: IntRange) : Boolean = range1.first >= range2.first && range1.last <= range2.last
fun isFirstRangeInSecond(range1: IntRange,range2: IntRange) = range1.first <= range2.first && range1.last >= range2.last
========================================================================================================================

fun main() {

    val addUpTO = 3

    //Solution 1 :
    println((0..addUpTO).sum())
    //============================================================

    //Solution 2 :
    val sum = (0..addUpTO).fold(0) {init, ope -> init+ope }
    println(sum)
    //============================================================

    //Solution 3 :
    println(getSumOfNum(addUpTO))
    //============================================================

    //Solution 4 :
    println(addUpTO*(addUpTO+1)/2) //O(1)
    //============================================================

    //Solution 5 :  //Time Complexity : O(n+1)
    var count = 0
    repeat(addUpTO+1) {
        count += it
    }
    println(count)
    //============================================================
    //Solution 6 : //Time Complexity : O(n)
    var count2 = 0
    (0..addUpTO).forEach {
        count2 += it
    }
    println(count2)
}

//Time Complexity : O(n)
private fun getSumOfNum (num: Int): Int {
    if(num == 0) return 0
    return num + getSumOfNum(num-1)
}

========================================================================================================================
fun main() {

    val list = listOf("A","a","K","k","S","s","H","h")
    val key = "H"

    //Solution : 1
    println("Index of $key = ${getIndexOf(key,list)}")

    //Solution : 2
    var index = -1
    for (i in 0..list.size) {  //Time Complexity : O(n)
        if(list[i] == key) {
            index = i
            break
        }
    }
    println("Index of $key is $index")

}
private fun getIndexOf(string: String,list: List<String>) : Int {

    if(list.isEmpty()) return -1

    list.forEachIndexed { index, s ->
        if(s == string) return index
    }

    return -1
}
========================================================================================================================
fun main() {
    val list = arrayListOf<Int>()
    val from = 4

    //Solution : 1
    println((from downTo 0).toList())

    //Solution 2 :
    //Time Complexity : O(n+1)
    for (i in from downTo 0) {
        list.add(i)
    }
    println(list)

    //Solution : 3
    println(getReverseList(from))
}

private fun getReverseList(from : Int) : List<Int> {

    fun helper (n : Int): MutableList<Int> {
        if(n == 0) return mutableListOf(0)

        return mutableListOf(n).also {
            it.addAll(getReverseList(n-1))
        }
    }
    helper(from)
    return helper(from).toList()
}
========================================================================================================================
