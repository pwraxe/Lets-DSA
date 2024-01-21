class ArraySum {
    fun printSubArray(n:IntArray) {
        for (s in n.indices) {
            for (i in n.indices) {
                if (s <= i) {
                    for (j in s .. i) {
                        print("${n[j]} ")
                    }
                    println()
                }
            }
        }
    }
    fun getSubArraySum(n:IntArray) {
        for (s in n.indices) {
            for (i in n.indices) {
                var sum = 0
                for (j in s .. i) {
                    sum += n[j]
                }
                if (sum != 0) println(sum)
            }

        }
    }
    fun getMaxSubArraySum(n:IntArray) {
        var maxSum = 0
        for (s in n.indices) {
            for (i in n.indices) {
                var sum = 0
                for (j in s .. i) {
                    sum += n[j]
                }
                maxSum = Math.max(maxSum, sum)
            }
        }
        println(maxSum)
    }
    fun prefixArray(n:IntArray): IntArray {
        val prefix = IntArray(n.size)
        prefix[0] = n.first()
        for (i in 1 until n.size) {
            prefix[i] = prefix[i-1] + n[i]
        }
        println(prefix.toTypedArray().contentToString())
        println("Sum: ${prefix.last()}")
        return prefix
    }
    fun subPrefixArraySum(n: IntArray, start:Int, end: Int) {
        val prefix = prefixArray(n)
        if (start > 0) {
            println("Sum: ${prefix[end] - prefix[start-1]}")
             end - (start-1)
        } else {
            println("Sum: ${prefix[end]}")
        }

    }

    fun kadansAlgo(n:IntArray) {
        var currentSum = 0
        var maxSum = Int.MIN_VALUE
        n.forEach {
            currentSum += it
            if (currentSum < 0) currentSum = 0
            maxSum = Math.max(maxSum, currentSum)
        }
        println("$maxSum = $currentSum")
    }
}

fun main() {
    ArraySum().apply {
        //val arr = intArrayOf(2,4,6,8,10)
//        val arr = intArrayOf(-2,-3,4,-1,-2,1,5,-3)
        val arr = intArrayOf(-1,-2,-3,-4,-5,-6,-7)

        //printSubArray(arr)
        //getSubArraySum(arr)
        //getMaxSubArraySum(arr)

        //prefixArray(arr)
        //subPrefixArraySum(arr,0,2)
        kadansAlgo(arr)
    }
}
