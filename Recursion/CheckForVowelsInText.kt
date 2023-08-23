class Solution {

    private val vowels = charArrayOf('a','e','i','o','u')
    fun isTextWithoutVowels(text: String): Boolean {
        return doCheck(text,0)
    }

    private fun doCheck(text: String, index:Int) : Boolean {
        if(index == text.length) return true
        if(text[index] in vowels) return false
        return doCheck(text, index+1)
    }
}


fun main() {
    Solution().apply {
        println(isTextWithoutVowels("Crypto"))
    }
}
