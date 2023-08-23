class Solution {
    fun countCharacters(line: String): Int {
        return doCounting(line,0)
    }

    private fun doCounting(line: String, count: Int): Int {
        if(count == line.length) return count
        return doCounting(line, count+1)
    }
}
fun main() {
    Solution().apply {
        val chars = countCharacters("Hello there this is new line for measure words in this line without using size function")
        println(chars)
    }
}

/**
Note: Akshay, Here you supposing to work on recusion only 
as you can know total character size by line.length but 
you focusing on recursion 
**/
