//1. add coins to sum till amount
fun main() {
    val amount = 18
    val list: IntArray = getCoins(listOf(5,2,1),amount)
    println(list.toTypedArray().contentToString())
}

fun getCoins(coins: List<Int>, amount: Int): IntArray {
    val result = mutableListOf<Int>()
    var sum = 0
    var index = 0
    while (sum != amount) {
        if (sum + coins[index] <= amount) {
            result.add(coins[index])
            sum += coins[index]
        } else {
            index++
        }
    }
    return result.toIntArray()
}

//Amount = Output
// 33 = [5, 5, 5, 5, 5, 5, 2, 1]
// 32 = [5, 5, 5, 5, 5, 5, 2]
// 39 = [5, 5, 5, 5, 5, 5, 5, 2, 2]
// 24 = [5, 5, 5, 5, 2, 2]
// 18 = [5, 5, 5, 2, 1]
