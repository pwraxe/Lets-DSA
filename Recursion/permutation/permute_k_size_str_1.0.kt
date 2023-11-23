class Solution {

    private val list = mutableListOf<String>()

    private fun getSubString(n:Int, alphabets:CharArray, subString: StringBuilder) {
        if (subString.length == n) {
            list.add(subString.toString())
            return
        }

        for (index in 0 until alphabets.size) {
            if (subString.isEmpty() || alphabets[index] != subString.last()) {
                subString.append(alphabets[index])
                getSubString(n,alphabets, subString)
                subString.setLength(subString.length-1)
            }
        }
    }
    fun getHappyString(n: Int, k: Int): String {
        getSubString(n, charArrayOf('a','b','c'), StringBuilder())
        println(list.toTypedArray().contentToString())
        return if (list.size >= k) list[k-1] else ""
    }
}

fun main() {
    Solution().apply {
        println(getHappyString(3,8))
    }
}

//Output: list = [aba, abc, aca, acb, bab, bac, bca, bcb, cab, cac, cba, cbc]
//bcb
