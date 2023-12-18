class Solution {
    private fun removeDuplicate(text: String, output: String): String {
        if (text.isEmpty()) return output

        return if (text.startsWith("box")) {
            removeDuplicate(text.substring(3), output)
        } else {
            removeDuplicate(text.substring(1), output + text.first())
        }
    }
    fun getSubString(text: String): String {
        return removeDuplicate(text,"")
    }
}

fun main() {
    Solution().apply {
        println(getSubString("aboxbcamera"))
    }
}

//Output: abcamera
