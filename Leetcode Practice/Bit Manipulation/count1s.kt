//Leetcode : 191. Number of 1 Bits
//TC:  O(n) || O(1) ? ==> O(1)
//O(n) : Using Loop,  AND O(1) : Loop goes finite no
//SC: O(1)



class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var num = n
        var count = 0
        while(num != 0) {
            num = num and (num-1)
            count++
        }
        return count
    }
}

//-----------------------------------------------

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var count = 0
        for(i in 0 until 32) {
            if((1 shl i) and n != 0) {
                count++
            }
        }
        return count
    }
}
//-----------------------------------------------

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        //toBinaryString(n) returns a list, Meance internally memory/extra space is getting created
        //So SC: O(n)
        return Integer.toBinaryString(n).filter { it == '1' }.length
    }
}

 
