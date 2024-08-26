//Get all Prime Nos by Sieve of Eratosthenes
class Solution {

    private fun isPrime(num: Int): Boolean {
        if(num == 1) return false
        if(num == 2 || num == 3) return true
        if(num % 2 == 0 || num % 3 == 0) return false

        for(i in 5 .. Math.sqrt(num * 1.0).toInt()) {
            if(num%i == 0 || num%(i+2) == 0) return false
        }
        return true
    }
    fun soe1(num: Int) {

        for(i in 1 .. num) {
            if(isPrime(i)) print("$i ")
        }
        println()
    }

    //TC: (n.log(log(n)))
    fun soe2(num: Int) {
        val primes = BooleanArray(num+1) { true }

        //j starts from i+i
        for(i in 2 .. Math.sqrt(num * 1.0).toInt()) {
            if(primes[i]) {
                for(j in i+i ..num step i) {
                    primes[j] = false
                }
            }
        }

        for(i in 2 .. num) {
            if(primes[i]) print("$i ")
        }
        println()
    }

    fun soe3(num: Int) {
        val primes = BooleanArray(num+1) { true }
        for (i in 2 .. num) {
            if (primes[i]){
                //print("$i ")

                //j starts from i*i
                for(j in i*i .. num step i) {
                    primes[j] = false
                }
            }
        }

        for(i in 2 .. num) {
            if(primes[i]) print("$i ")
        }
    }
}



fun main() {
    Solution().apply {
        soe1(23)
        soe2(23)
        soe3(23)
    }
}
