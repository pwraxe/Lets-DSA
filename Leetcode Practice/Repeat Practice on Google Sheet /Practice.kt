/**
1. No of islands
2. Valid Parenthesis
3. PostFix Expression
15Mins

4. Clone Graph: 20mins
5. Target Sum: 10mins
**/


//Time: 4mins
//Reverse Polish Notation
class SolutionForPostfixExpression {
    fun evalRPN(tokens: Array<String>): Int {
  
    	val stack = Stack<Int>()
  		val operators = listOf("+", "-","*","/")
    	tokens.forEach {
          
			if(it !in operators) {
            	stack.push(it.toInt())
      		} else {
            	//Got Operator
            	val n1 = stack.pop()
            	val n2 = stack.pop()
          
      	    	val result = when (it) {
      		  		"+" -> n1 + n2
      		  		"-" -> n2 - n1
      		  		"*" -> n1*n2
      		  		"/" -> n2/n1
      		  		else -> 0  
            	}
        		stack.push(result)
    		}
        }
  		return if(stack.isNotEmpty()) stack.pop() else 0
	}
}

//-----------------------------------------------------------------------------------------------

//Time: ~4Min
class SolutionOfValidParanthesis {
    fun isValid(str: String) : Boolean {
        val stack = Stack<Char>()
        str.toCharArray().forEach {
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

//-----------------------------------------------------------------------------------------------

//Time: ~6Min
class SolutionOfNoOfIslands {
	private var noOfIsland = 0
	
    fun numIslands(grid: Array<CharArray>): Int {
		val rowSize = grid.size
		val colSize = grid[0].size
		for(row in 0 until rowSize) {
			for(col in 0 until colSize) {
				if(grid[row][col] == '1') {
					noOfIsland++
					doBFS(row, col, grid)
				}
			}
		}
		return noOfIsland 
	}

	private fun doBFS(row: Int, col: Int, grid: Array<CharArray>) {
		val start = row >= 0 && col >= 0
		val end = row < grid.size && col < grid[0].size
		if(start && end && grid[row][col] == '1') {
			doBFS(row, col-1, grid)
			doBFS(row-1, col, grid)
			doBFS(row, col+1, grid)
			doBFS(row+1, col, grid)
		}
	}
}
