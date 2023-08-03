//Leetcode: 17. Letter Combinations of a Phone Number


//Recursive Way
class Solution {
    private lateinit var strDigits: String
    private var result = mutableListOf<String>()
    private val numToCharMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if(digits.length == 0) return result
        strDigits = digits
        doCombination(0, StringBuilder())
        return result
    }

    private fun doCombination(start: Int, string: StringBuilder) {
        if(start == strDigits.length) {
            result.add(string.toString())
            return
        }

        for(char in numToCharMap[strDigits[start]] ?: "") {
            string.append(char)
            doCombination(start+1, string)
            string.setLength(start)
        }
    }
}


/**
//Iterative Way
class Solution {

    private fun getNumberHashMap() = hashMapOf (
        "2" to listOf("a","b","c"),
        "3" to listOf("d","e","f"),
        "4" to listOf("g","h","i"),
        "5" to listOf("j","k","l"),
        "6" to listOf("m","n","o"),
        "7" to listOf("p","q","r","s"),
        "8" to listOf("t","u","v"),
        "9" to listOf("w","x","y","z")
    )

    fun letterCombinations(digits: String): List<String> {
        if(digits == "") return listOf()
        if(digits.length == 1) return getNumberHashMap()[digits]!!

        var result = mutableListOf<String>()
        val list = mutableListOf<String>()

        digits.forEachIndexed { index, string ->
            list.clear()    
            val charList = getNumberHashMap()[string.toString()] ?: listOf()
            if(result.isEmpty()) 
                list.addAll(charList)
            else {
                for(char in charList) {
                    for(i in result) {
                        list.add("${i}${char}")
                    }
                }
            }
            result = list.toMutableList()
        }
        return result
    }
}
**/
