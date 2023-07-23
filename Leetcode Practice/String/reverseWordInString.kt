//TC: O(n), n is no of words in string
//SC: O(n), total words + space char
//10min (onIDE)
class Solution {
    fun reverseWords(s: String): String {
        val list = s.split(" ").toMutableList()
        var low = 0
        var high = list.size-1
        while(low < high) {
            list[low] = list[high].also{ list[high] = list[low]}
            low++
            high--
        }
        var output = ""
        list.forEach {
            if(it != "") output += "$it "
        }
        return output.trim()
    }
}
