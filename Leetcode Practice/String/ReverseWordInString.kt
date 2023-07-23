//Leetcoede:   Reverse Words in a String III
//TC: O(n2) || O(n*n) , used nested loop
//SC: O(n)


//Note: Akshay this is worst code
//This problem can be solved in O(n) TC, try it own again

class Solution {
    fun reverseWords(s: String): String {

        val list = s.split(" ").toMutableList()
        
        for (index in 0 until list.size) {
            val input = StringBuilder(list[index])
            var low = 0
            var high = input.length-1
            while(low < high) {
                input[low] = input[high].also { input[high] = input[low] }
                low++
                high--
            }
            list[index] = input.toString()
        }
        
        var output = ""
        list.forEach {
            if(it != "")output += "$it "
        }
        return output.trim()
    }
}
