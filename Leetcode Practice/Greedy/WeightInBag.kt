//Conceptial
class Solution {
    fun getWeight(total: Double, weights: DoubleArray) {
        var sum = 0.0
        var index = 0
        val result = mutableListOf<Double>()
        while (sum < total) {
            if (sum + weights[index] <= total) {
                sum += weights[index]
                result.add(weights[index])
            } else {
                index++
            }
        }
        println(result.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        getWeight(55.5, doubleArrayOf(25.0, 20.0, 10.0, 5.0, 2.5, 2.0, 1.0, 0.5))
    }
}
