class Solution {
    //Basic

    fun printReversed(n:Int) {
        if (n == 0) {
            println()
            return
        }
        print("$n ")
        printReversed(n-1)
        print("$n ")
    }
    fun fact(n:Int):Int {
        if (n == 0) return 1
        return n * fact(n-1)
    }
    fun sumOfNumbs(n:Int, sum: Int):Int {
        if (n == 0) return sum
        return sumOfNumbs(n-1, sum+n)
    }
    fun fib(n:Int): Int {
        if (n <= 1) return n
        return fib(n-1) + fib(n-2)
    }
    fun isSorted(numbs:IntArray, index:Int): Boolean {
        if (index == numbs.size) return true
        return numbs[index-1] <= numbs[index] && isSorted(numbs, index+1)
    }
    fun firstOccOfNum(numbs: IntArray,index: Int,num:Int):Int {
        if (numbs.size == index) return -1
        if (numbs[index] == num) return index
        return firstOccOfNum(numbs, index+1, num)
    }
    fun lastOccOfNum(numbs: IntArray, index: Int, num: Int, lastIndex:Int): Int {
        if (index == numbs.size) {
            return lastIndex
        }
        return if (numbs[index] == num) {
            lastOccOfNum(numbs, index+1, num, index)
        } else {
            lastOccOfNum(numbs, index+1, num, lastIndex)
        }
    }
    fun power(x:Int,n:Int): Int {
        if (n == 1) return x
        return x * power(x,n-1)
    }
    fun powerOpt(x:Int,n: Int):Int {
        if (n == 0) return 1
        val pow =  powerOpt(x,n/2)
        var halfPwr = pow * pow
        if (n%2 == 1) {
           halfPwr *= x
        }
        return halfPwr
    }

    //Adv
    fun tilingProblem(n:Int):Int {
        if (n <= 2) return n
        return tilingProblem(n-1) + tilingProblem(n-2)
    }
    fun removeDuplicate(s:String, index:Int, result:String, freq:IntArray): String {
        if (index == s.length) return result
        val i = s[index] - 'a'
        return if (freq[i] == 1) {
            removeDuplicate(s, index+1, result, freq)
        } else {
            freq[i] = 1
            removeDuplicate(s, index+1, result+s[index], freq)
        }
    }
    fun noOfPairs(n:Int): Int {
        if (n <= 2) return n
        return noOfPairs(n-1) + noOfPairs(n-2) * (n-1)
    }
    fun binStringWithConsecutive1s(n: Int,lastBit:Int, result: String) {
        if (n == 0) {
            println(result)
            return
        }

        binStringWithConsecutive1s(n-1,0,result+'0')
        if (lastBit == 0) {
            binStringWithConsecutive1s(n-1,1,result+'1')
        }
    }
}

fun main() {
    Solution().apply {
        printReversed(10)
        println("\nFact of 5: ${fact(5)}")
        println("Sum of 10: ${sumOfNumbs(10,0)}")
        println("Fib of 10: ${fib(10)}")
        val nums = intArrayOf(1,2,3,3,6,6)
        println("is Array Sorted: ${isSorted(nums,1)}")
        println("First Occ of 3 at index ${firstOccOfNum(nums,0,3)}")
        println("Last Occ of 3 at index ${lastOccOfNum(nums,0,3,-1)}")

        println("Power (10^4): ${power(10,4)}")
        println("Power Opt (10^4): ${powerOpt(10,4)}")

        println("=============================================")
        println("tiling: ${tilingProblem(5)}")
        val result = removeDuplicate("appnnacollege",0,"",IntArray(26))
        println("Remove Duplicate: $result")
        println("Pairs: ${noOfPairs(3)}")

        binStringWithConsecutive1s(3,0,"")
    }
}


10 9 8 7 6 5 4 3 2 1 
1 2 3 4 5 6 7 8 9 10 
Fact of 5: 120
Sum of 10: 55
Fib of 10: 55
is Array Sorted: true
First Occ of 3 at index 2
Last Occ of 3 at index 3
Power (10^4): 10000
Power Opt (10^4): 10000
=============================================
tiling: 8
Remove Duplicate: apncoleg
Pairs: 4
000
001
010
100
101
