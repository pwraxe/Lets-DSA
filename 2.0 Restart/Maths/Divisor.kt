class Solution {

    //TC: O(n) || O(num)
    fun divisor1(num: Int) {
        for(i in 1 .. num) {
            if(num%i == 0) print("$i ")
        }
        println()
    }

    //O(sqrt(n))
    fun divisor2(num: Int) {

        for(i in 1 .. Math.sqrt(num * 1.0).toInt()) {
            if(num % i == 0) {
                print("$i ")

                if(i != num/i) {
                    print("${num/i} ")
                }
            }
        }
        println()
    }


    //Why this? --> above code `divisor2()` printing element in no asc order hence
    //O(sqrt(n))
    fun divisor3(num: Int) {

        var i = 1
        while(i <= Math.sqrt(num * 1.0).toInt()) {
            if(num%i == 0) print("$i ")
            i++
        }

        while(i >= 1) {
            if(num%i == 0) print("${num/i} ")
            i--
        }
        println()
    }
}


fun main() {
    Solution().apply {
        val num = 84
        divisor1(num)
        divisor2(num)
        divisor3(num)
    }
}


// 1 2 3 4 6 7 12 14 21 28 42 84 
// 1 84 2 42 3 28 4 21 6 14 7 12 
// 1 2 3 4 6 7 12 14 21 28 42 84 
