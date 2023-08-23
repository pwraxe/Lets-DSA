class Solution {
    fun combinations(text:String): List<List<String>> {
        val list = mutableListOf<List<String>>()
        doCombinations(text, 0, list, mutableListOf())
        return list
    }

    private fun doCombinations(text: String, index:Int, list: MutableList<List<String>>,subList: MutableList<String>) {
        if(index == text.length) {
            if (subList.toList().isNotEmpty()) {
                list.add(subList.toList()) //<---------------------------THIS LINE IS IMP, `toList()`
            }
            return
        }

        //With Element
        subList.add(text[index].toString())
        doCombinations(text, index+1, list, subList)

        //Without Element
        subList.removeLast()
        doCombinations(text, index+1, list, subList)
    }
}

fun main() {
    Solution().apply {
        val list = combinations("ASP")
        println("Combo : ${list.toTypedArray().contentToString()}")
    }
}
