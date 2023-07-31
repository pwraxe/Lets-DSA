//PostFix Expression given, you have to calculate expression
//["2","1","+","3","*"] ⇒ (2+1) * 3 ⇒ 9

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
	    val operators = listOf("+", "-", "*", "/")
	    val stack = Stack<Int>()
	
	    tokens.forEach {
            //Push No to Stack
		    if(it !in operators) stack.push(it.toInt())
            
            //If operator found then pop 2 nums, perform calculation and push to stack
            if(it in operators) {
	            val num1 = stack.pop()
	            val num2 = stack.pop()
	            
                val result = when(it) {
		            "+" -> num2 + num1
		            "-" ->  num2 - num1
		            "*" -> num2 * num1
		            "/" -> num2 / num1
		            else -> 0
                }
                stack.push(result)
            }
        }
        
        //At last we have only 1 element in stack, return it else return 0
        return if(stack.isNotEmpty()) stack.pop() else 0
    }
}


