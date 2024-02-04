class Recursion {
    fun fact(n: Int): Int {
        if (n == 0) return 1
        return n * fact(n-1)
    }
    fun printAsc(n:Int) {
        if (n == 0) return
        printAsc(n-1)
        print("$n ")
    }
    fun printDesc(n: Int) {
        if (n == 0) return
        print("$n ")
        printDesc(n-1)
    }
    fun sumOfNaturalNo(n:Int, sum: Int): Int {
        if (n == 0) return sum
        return sumOfNaturalNo(n-1, sum + n)
    }
    fun nFibb(n: Int): Int {
        if (n <= 1) return n
        return nFibb(n-1) + nFibb(n-2)
    }
    fun isListSorted(list: List<Int>, index: Int = 0): Boolean {
        if (index == list.size-1) return true
        if (list[index] > list[index+1]) return false
        return this.isListSorted(list, index+1)
    }
    fun firstOccurrenceOf(list: List<Int>, num:Int, index: Int = 0): Int {
        if (index == list.size) return -1
        if (list[index] == num) return index
        return firstOccurrenceOf(list,num, index+1)
    }
    fun lastOccurrenceOf(list: List<Int>, n: Int,index: Int = list.size-1):Int {
        if (index == -1) return -1
        if (list[index] == n) return index
        return lastOccurrenceOf(list, n, index-1)
    }

    fun powerOf2(pow: Int): Int {
        if (pow == 0) return 1
        return 2 * powerOf2(pow-1)
    }

    fun power(base: Int, pow: Int): Int {
        if (pow == 0) return 1
        return base * power(base, pow-1)
    }

    fun powerOpt(base:Int, pow: Int): Int {
        if (pow == 0) return 1
        val power = powerOpt(base, pow/2)
        var square = power * power
        if (pow % 2 == 1) {
            square *= base
        }
        return square
    }
}
fun main() {
    Recursion().apply {
        val num = 10
        val list = listOf(1,2,3,4,4,5,6,7,7,8,9)
        println(fact(num))
        printAsc(num)
        println()
        printDesc(num)
        println()
        println("Sum of Top $num: ${sumOfNaturalNo(num,0)}")
        println("$num Fibb: ${nFibb(num)}")
        println("isListSorted: ${isListSorted(list)}")
        println("First Occ of 4: ${firstOccurrenceOf(list,4)}")
        println("Last Occ of 7: ${lastOccurrenceOf(list,7)}")
        println("2 pow 10 : ${powerOf2(10)}")
        println("3 pow 3 : ${power(6,5)}")
        println("6 pow 5 : ${powerOpt(6,5)}")
    }
}


//
3628800
1 2 3 4 5 6 7 8 9 10 
10 9 8 7 6 5 4 3 2 1 
Sum of Top 10: 55
10 Fibb: 55
isListSorted: true
First Occ of 4: 3
Last Occ of 7: 8
2 pow 10 : 1024
3 pow 3 : 7776
6 pow 5 : 7776
