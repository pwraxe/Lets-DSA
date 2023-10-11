import java.util.Stack

class Solution {
    private val bracket = charArrayOf('(', ')')

    private fun createParenthesis(n:Int) : String {
        var first = ""
        var second = ""
        for (index in 0 until n) {
            first += bracket[0]
            second += bracket[1]
        }
        return  first+second
    }
    private fun isValidParenthesis(text: StringBuilder): Boolean {

        if(text[0] != bracket[0] && text[text.length-1] != bracket[1]) return false

        val stack = Stack<Char>()
        for (index in 0 until text.length) {
            if(text[index] == '(') {
                stack.add(bracket[1])
            } else {
                if (stack.isEmpty()) return false
                val paran = stack.pop()
                if(text[index] != paran) return false
            }
        }
        return stack.isEmpty()
    }

    private fun doCombinations(text: StringBuilder, index: Int, list: MutableSet<String>) {
        if(index == text.length) {
            if(isValidParenthesis(text)) {
                list.add(text.toString())
            }
            return
        }

        for (i in index until text.length) {
            text[i] = text[index].also { text[index] = text[i] }
            if(isValidParenthesis(text)) {
                doCombinations(text, index+1, list)
            }

            text[i] = text[index].also { text[index] = text[i] }
        }
    }
    fun generateParenthesis(n: Int): List<String> {
        val parenthesis = createParenthesis(n)
        val list = mutableSetOf<String>()
        doCombinations(StringBuilder(parenthesis), 0, list)

        println(list.toTypedArray().contentToString())
        return list.toList()
    }
}

fun main() {
    Solution().apply {
        generateParenthesis(6)
    }
}
