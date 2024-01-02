//add previous and next index value
//add to result if addition is even else subtract value from result
//return max result
//Trying to achive via Greedy, Fail, 
//This imaginary problem will solve by DP :(
fun main() {
    val list = listOf(5,2,7,4,9,1,8,3)
    println(list.sorted().toTypedArray().contentToString())
    println(getAddition(list))
}
fun getAddition(list: List<Int>) : Int {
    var result = 0
    for (index in 1 until list.size-1) {
        //Greedy's Local Decision
        val prevSum = list[index] + list[index-1]
        if (prevSum % 2 == 0) result += prevSum else result -= prevSum

        val nextSum = list[index] + list[index+1]
        if (nextSum % 2 == 0) result += nextSum else result -= nextSum
    }
    return result
}
