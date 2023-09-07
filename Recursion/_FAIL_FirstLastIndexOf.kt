class Solution {
    private fun getFirstIndexOf(str: String, index: Int, char: Char): Int {
        if(index == str.length) return -1
        if(str[index] == char) return index
        return getFirstIndexOf(str, index+1, char)
    }

    //FAIL | NOT-WORKING
    private fun getLastIndexOf(str: String, index:Int, char: Char): Int {
        if(index == str.length) return index
        getLastIndexOf(str, index+1, char)
        println("[$index] = ${str[index]}")
        //Note: As Reverse list index getting correctly but failing to track last index
        return if(str[index] == char) index else index
    }

    fun getFirstIndex(str:String, char: Char): Int {
        return getFirstIndexOf(str,0,char)
    }
    fun getLastIndex(str:String, char: Char): Int {
        return getLastIndexOf(str,0,char)
    }
}

fun main() {
    Solution().apply {
        val text = "Parameter"
        println("FirstIndex : ${text.indexOf('e')} == ${getFirstIndex(text,'e')}")
        println("LastIndex : ${text.lastIndexOf('a')} == ${getLastIndex(text,'a')}")
    }
}
