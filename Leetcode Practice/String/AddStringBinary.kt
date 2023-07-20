//Leetcode: Add Binary
//TC: O(n), max length of input string 
//SC: O(n), new String created , (but it can be O(1) as we have single string as output)


class Solution {
    fun addBinary(a: String, b: String): String {
        //var result = StringBuilder()  //Runtime: 220 ms
        var result = StringBuffer()     //Runtime: 190 ms
        var lastIndexOfA = a.length-1
        var lastIndexOfB = b.length-1
        var sum = 0
        var carry = 0
        
        while(lastIndexOfA >= 0 || lastIndexOfB >= 0) {
            sum = carry 
            if(lastIndexOfA >= 0) sum += a[lastIndexOfA] - '0'
            if(lastIndexOfB >= 0) sum += b[lastIndexOfB] - '0'
            result.append("${sum%2}")
            carry = sum / 2 
            lastIndexOfA--
            lastIndexOfB--
        }
        if(carry == 1) result.append("1")
        return result.reverse().toString()
    }
}
