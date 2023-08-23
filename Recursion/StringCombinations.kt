class Solution {

    fun combinations(text:String): List<String> {
        val list = mutableListOf<String>()
        doCombinations(StringBuilder(text), 0, list)
        return list
    }

    private fun doCombinations(text: StringBuilder, index: Int, list: MutableList<String>) {

        if(index == text.length) {
            list.add(text.toString())
            return
        }

        for (i in index ..<text.length) {
            text[i] = text[index].also { text[index] = text[i] }
            doCombinations(text,index+1,list)
            text[i] = text[index].also { text[index] = text[i] }
        }
    }
}

fun main() {
    Solution().apply {
        val list = combinations("ASP")
        println(list.toTypedArray().contentToString())
    }
}

//OUTPUT: [ASP, APS, SAP, SPA, PSA, PAS]
