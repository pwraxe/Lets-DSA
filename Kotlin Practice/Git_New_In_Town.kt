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
    fun main() {

    var list = intArrayOf()
    val upTo = 3

    //Solution 1 :
    println(fromToFrom(upTo)) //[0, 1, 2, 3, 2, 1, 0]
}

private fun fromToFrom(n: Int) :List<Int> {
    return (0..n) + (n-1 downTo 0)
}

========================================================================================================================
fun main() {

    val stations = listOf<String>("A","B","C")
    val preText = "Train is calling at"

    when(stations.size) {
        0 -> {
            println("No Stations Define")
        }
        1 -> {
            println("$preText ${stations[0]}")
        }
        2 -> {
            println("$preText ${stations[0]} and ${stations[1]}")
        }
        else -> {
            val last = stations.last()
            var names = ""
            for (index in 0 until stations.size-1) {
                names += "${stations[index]}, "
            }

            println("$preText ${names.substring(0,names.length-2)} and $last")  //Train is calling at A, B and C
        }
    }
}
******************************************* ALT SOLUTION / BETTER than ABOVE *******************************************
fun main() {

    val stations = listOf<String>("A","B","C","D")
    val preText = "Train is calling at"

    if(stations.size == 1) {
        println("$preText ${stations[0]}" )
    } else {
        val lastStation = stations.takeLast(1).joinToString { it }
        val followingStation = stations.dropLast(1).joinToString { it }
        println("$preText $followingStation and $lastStation")
    }
}
========================================================================================================================
fun main() {

    val pairTo = 1
    val pairs = mutableListOf<Pair<Int,Int>>()

    //Solution 1 :
    //O(n*n)
    (0..pairTo).forEach { i ->
        (0..pairTo).forEach { j ->
            pairs.add(Pair(i,j))
        }
    }
    println(pairs) //[(0, 0), (0, 1), (1, 0), (1, 1)]

    //Solution 2 :
    val list = (0..pairTo).map { i ->
        (0..pairTo).map { j ->
            i to j
        }
    }.flatten()

    println(list)  //[(0, 0), (0, 1), (1, 0), (1, 1)]
}
========================================================================================================================
fun main() {
    val list = listOf(1,2,3,2,1,4,2,5,2,6,3,5,2,1,4,5,2)
    //Solution 1 :
    println(list.toSet().size)

    //Solution 2 : USing Map
    val map = HashMap<Int,Int>()
    list.forEach {
        val value = map.getOrDefault(it,0)
        value.inc()
        map[it] = value
    }
    println("Map Count = ${map.size}")

    //Solution 3 :
    //groupBy is grouping of same element in array
    //{1=[1, 1, 1], 2=[2, 2, 2, 2, 2, 2], 3=[3, 3], 4=[4, 4], 5=[5, 5, 5], 6=[6]}
    val grp = list.groupBy { it }
    println(grp.size)
}
========================================================================================================================
fun main() {
    val num = 5
    //Solution 1 :
    println((num downTo 1).toList())

    //Solution 2 : Using Recursion
    println(getReverse(num))

}

private fun getReverse(num : Int) : List <Int> {

    return when (num)  {
        0 -> emptyList()
        else -> {
            listOf(num) + getReverse(num - 1)
        }
    }
}
========================================================================================================================
fun main() {
    val num = 5
    val step = 1
    //Solution 1 :
    println((num downTo 1 step step).toList())

    //Solution 2 : Using Recursion
    println(getReverse(num))

}

private fun getReverse(num : Int) : List <Int> {
    fun getNum (num : Int) : List<Int> {
        return when {
            num <= 0 -> { emptyList<Int>() }
            else -> {
                listOf(num) + getNum(num-2)
            }
        }
    }
    return getNum(num)
}
========================================================================================================================
fun main() {
    val power = 3
    val times = 3
    println(getPower(power,times))
}
private fun getPower(power: Int, times: Int) : Int{
    return if (times <= 1) power * times
    else power * getPower(power, times-1)
 }
========================================================================================================================
fun main() {
    val fact = 5
    println(getFact(fact))
}
private fun getFact(num : Int) : Int {
    return if(num == 1) return num else num * getFact(num-1)
}
========================================================================================================================
fun main() {
    val list = listOf(3,2,5)
    println(getProduct(list))
    println(usingRecursion(list))
}
private fun getProduct(list: List<Int>) : Int {
    return list.reduce { acc, i -> acc * i }
}
private fun usingRecursion(list: List<Int>) : Int {
    return if(list.size <= 1) list.first() else {
        list.first() * usingRecursion(list.drop(1))
    }
}
========================================================================================================================
fun main() {
    val list = listOf("science","math","work","static","india")

    //Solution 1 :
    val list2 = list.map {
        it[0].uppercase()+it.substring(1,it.length)
    }
    println(list2)

    //Solution 2 : capitalize is Deprecated
    println(list.map { it.capitalize()} )

    //Solution 3 : Becoz capitalize Deprecated
    println(list.map { it.replaceFirstChar { it.uppercase() } } )

    println(getCapitalisedList(list))
}

//Using Recursion
private fun getCapitalisedList (list: List<String>) : List<String> {
    return if(list.isEmpty()) listOf<String>() else {
        listOf(list.first().capitalize()) + getCapitalisedList(list.drop(1))
    }
}
========================================================================================================================
fun main() {
    val test = "Hello_there_i_am_android_dev"
    println(getConcatString(test).decapitalize())
}

//Using Recursion
private fun getConcatString(test: String) : String {

    val list = test.split("_")

    fun toConcat(list: List<String>) : String {
        return when (list.size) {
            0 -> ""
            1 -> list.first().capitalize()
            else -> {
                list.first().capitalize() + toConcat(list.drop(1))
            }
        }
    }
    return toConcat(list)
}
========================================================================================================================
fun main() {
    val test = "This is android developer stuff"

    //Solution 1 :
    var longWord = ""
    test.split(" ").forEach {
        if(longWord.length < it.length) {
            longWord = it
        }
    }
    println(longWord) //developer

    //Solution 2 :
    val text = test.split(" ").maxByOrNull { it.length }
    println(text) //developer
}
========================================================================================================================
