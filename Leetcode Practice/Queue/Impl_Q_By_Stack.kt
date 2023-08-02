/**
* Note: Akshay This is not right solution, 
* As you learning so this code is fine but you have to do in O(1) time complexity as followup given
*/
class MyQueue() {

    private val pushStack = Stack<Int>()
    private val popStack = Stack<Int>()
    
    fun push(x: Int) {
        pushStack.push(x)
    }

    fun pop(): Int {
      
        popStack.clear()
        while(pushStack.isNotEmpty()) {
            popStack.push(pushStack.pop())
        }
        val pop = popStack.pop() //if(popStack.isNotEmpty()) popStack.pop() else 0
        
        pushStack.clear()
        while(popStack.isNotEmpty()) {
            pushStack.push(popStack.pop())
        }
        
        println("Pop Element : $pop")
        return pop
    }
    fun peek(): Int {
        popStack.clear()
        while(pushStack.isNotEmpty()) {
            popStack.push(pushStack.pop())
        }
        val peek = popStack.peek()
        
        pushStack.clear()
        while(popStack.isNotEmpty()) {
            pushStack.push(popStack.pop())
        }
        return peek
    }

    fun empty(): Boolean {
        return pushStack.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
