
//Leetcode: 412. Fizz Buzz
//TC: O(n), loop used,
//SC: O(1), Limited Size of array created

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val list = Array(n) { "" }  //Bcoz of this SC: ~O(1)
        

        for(index in 0 until n) {
            val nextIndex = index+1 

            list[index] = when {
                nextIndex % 3 == 0 && nextIndex % 5 == 0 -> "FizzBuzz"
                nextIndex % 3 == 0 -> "Fizz"
                nextIndex % 5 == 0 -> "Buzz"
                else -> "${nextIndex}"
            }            
        }
        return list.toList()
    }
}

//--------------------------------------------------------------------------


//Above code becomes SC O(1), as array creating limited size
//and also having minimum comparisions

 
class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for(index in 0 until n) {
            val nextIndex = index+1 

            when {
                nextIndex%3 == 0 && nextIndex%5 == 0 -> list.add("FizzBuzz")
                nextIndex % 3 == 0 -> list.add("Fizz")
                nextIndex % 5 == 0 -> list.add("Buzz")
                else -> list.add("${nextIndex}")
            }            
        }
        return list
    }
}

 
//-------------------------------------------------------------------------------

//Following code has more comparision than above code

//Leetcode: 412. Fizz Buzz
//TC: O(n), loop used,
//SC: O(n), extra space took

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for(index in 0 until n) {
            val nextIndex = index+1 
            if(nextIndex%3 == 0 && nextIndex%5 == 0) list.add("FizzBuzz")
            else if(nextIndex % 3 == 0) list.add("Fizz")
            else if(nextIndex % 5 == 0) list.add("Buzz")
            else list.add("${nextIndex}")
        }
        return list
    }
}



