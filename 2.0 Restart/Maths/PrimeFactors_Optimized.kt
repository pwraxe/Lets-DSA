TC: O(n)
object Solution {
  
  fun primeFactors(n:Int) {
        var num = n
        var i = 2
        while (num > 1) {
            if (num % i == 0) {
                print("$i ")
                num /= i
            }
            else i++
        }
        if (num > 1) {  //Condition 'num > 1' is always false 
            print(num)
        }
        println()
    }
  
}

fun main() {
    Solution.primeFactors(992)
}

// ================================================================================

TC: O(sqrt(n))
object Solution {

    fun primeFactors(n: Int) {
        var num = n

        // handle 2 separately
        while (num % 2 == 0) {
            print("2 ")
            num /= 2
        }

        // handle odd factors only
        var i = 3
        while (i * i <= num) {
            while (num % i == 0) {
                print("$i ")
                num /= i
            }
            i += 2
        }

        // if num is still > 1, it's a prime
        if (num > 1) print(num)
        println()
    }
}

fun main() {
    Solution.primeFactors(992) //2 2 2 2 2 31 
}

// ================================================================================
TC: O(sqrt(n))

fun primeFact(n:Int) {
    var num = n

    while(num % 2 == 0) {
        print("2 ")
        num /= 2
    }
    for (i in 3 .. Math.sqrt(n*1.0).toInt()) {
        while (num % i == 0) {
            print("$i ")
            num /= i
        }
    }
    if (num > 1) print(num)
    println()
}

fun main() {
    Solution.primeFactors(510510) //2 3 5 7 11 13 17 
}
