class MyStack() {

    private val elements = mutableListOf<Int>()
    
    val isEmpty: Boolean
        get() = elements.size == 0
    
    fun push(x: Int) {
        elements.add(0,x)
    }

    fun pop(): Int = if(!isEmpty) elements.removeAt(0) else 0
    fun top(): Int = if(!isEmpty) elements[0] else 0
    fun empty(): Boolean = isEmpty

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
