class Solution {
    private fun removeDuplicate(text: String, output: String): String {
        if (text.isEmpty()) return output

        val ch = text.first()
        return if (ch == 'a') {
            removeDuplicate(text.substring(1), output)
        } else {
            removeDuplicate(text.substring(1), output + ch)
        }
    }
    fun getSubString(text: String): String {
        return removeDuplicate(text,"")
    }
}

fun main() {
    Solution().apply {
        println(getSubString("abbc"))
    }
}
