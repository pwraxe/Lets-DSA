class Solution {
    
    //TC: O(num)
    fun isPrime1(num: Int): Boolean {
        for(i in 2 ..< num) {
            if(num%i == 0) return false
        }
        return true
    }

    //TC: O(sqrt(num))
    fun isPrime2(num: Int): Boolean {
        for(i in 2 .. Math.sqrt(num*1.0).toInt()) {
            if(num%i == 0) return false
        }
        return true
    }
    
	//Naive Method = TC: O(log(sqrt(n)))
    fun isPrime3(num: Int): Boolean {
        
        if(num == 1) return true
        if(num%2 == 0 && num%3 == 0) return false
        
    	for(i in 5 ..< Math.sqrt(num.toDouble()).toInt() step 6) {
        	if(num % i == 0 || num % (i+1) == 0) return false
    	}
		return true
	}
}

fun main() {
    Solution().apply {
        
        println(isPrime1(7))  //true
        println(isPrime2(13)) //true
        println(isPrime3(29)) //true
    }
}

