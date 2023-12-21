class Solution {

    private val list = mutableListOf<String>()
    private fun toSubList(input: String, output:String): List<String> {
        if (input.isEmpty()) {
            list.add(output)
            return list
        }

        toSubList(input.substring(1), output + input.first())
        toSubList(input.substring(1), output)

        return list
    }

    fun getSubSeq(text: String): List<String> {
         return toSubList(text,"")
    }
}

fun main() {
    Solution().apply {
        println(getSubSeq("abc").toTypedArray().contentToString())
    }
}

Note for you Akshay: 
Difference is clear, till now you need (input text, index, stringBuilder, list), 
in this code, just 1 input string, 1 empty stirng,
remove first char until input gets empty, .... simple 
//[abc, ab, ac, a, bc, b, c, ]
