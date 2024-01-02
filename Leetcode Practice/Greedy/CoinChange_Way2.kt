//2. reduce the amount to 0

fun main() {
    val amount = 18
    val list: IntArray = getCoins(intArrayOf(5,2,1),amount)
    println(list.toTypedArray().contentToString())
}

fun getCoins(coins: IntArray, money: Int): IntArray {
    var amount = money
    val result = mutableListOf<Int>()
    var index = 0
    while (amount != 0) {
        if (amount - coins[index] >= 0) {
            result.add(coins[index])
            amount -= coins[index]
        } else {
            index++
        }
    }
    return result.toIntArray()
}
