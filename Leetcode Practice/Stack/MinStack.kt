class MinStack() {

    private val stack = mutableListOf<Int>()
    
    fun push(`val`: Int) {
        stack.add(`val`)    
    }

    fun pop() {
        stack.removeAt(stack.size-1)
    }

    fun top(): Int = stack.get(stack.size-1)

    fun getMin(): Int = stack.min() ?: 0
}
