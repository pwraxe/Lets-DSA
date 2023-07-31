class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            when (it) {
                '(' -> stack.push(')')
                '[' -> stack.push(']')
                '{' -> stack.push('}')
                else -> {
                    if(stack.isEmpty()) return false
                    if(stack.pop() != it) return false
                }
            }
        }
        return stack.isEmpty()
    }
}
