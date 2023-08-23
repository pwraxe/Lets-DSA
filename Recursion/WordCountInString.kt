class Solution {
    fun countWord(line: String): Int {
        return doCounting(line.split(" "),0)
    }
    private fun doCounting(word:List<String>, count: Int): Int {
        if(count == word.size) {
            return count
        }
        return doCounting(word, count+1)
    }
}

fun main() {
    Solution().apply {
        println("Total Words : ${countWord("Hello there this is new line for measure words in this line without using size function")}")
    }
}
