/**
1. No of islands
2. Valid Parenthesis
3. PostFix Expression
4. Clone Graph
5. Target Sum
**/

//Time: ~6Min
//1. No of islands
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
//-----------------------------------------------------------------------------------------------
//Time: ~4Min
//2. Valid Parenthesis
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


//-----------------------------------------------------------------------------------------------Recursive
//4. Clone Graph
//Time: ~7Min
class SolutionForCloneGraph {
    private fun doClone(node: Node?, map: HashMap<Node?, Node?>) : Node? {
        
        node ?: return null
        
        map[node]?.let { return it }
        
        val newNode = Node(node?.`val`)
        map[node] = newNode
        
        node?.neighbors.forEach {
            newNode?.neighbors.add(doClone(it,map))
        }
        return newNode
    }

	fun cloneGraph(node: Node?): Node? {
		return doClone(node, hashMapOf<Node?, Node?>())
	}
}
//-----------------------------------------------------------------------------------------------Iterative
//Time: 6mins
//4. Clone Graph
class SolutionForCloneGraph {
	fun cloneGraph(node: Node?): Node? {
		node ?: return null
    
    	val stack = Stack<Node>()
		val map = hashMapOf<Node?,Node?>()

		stack.push(node)
    	val newNode = Node(node?.`val`)
    	map[node] = newNode

    	while(stack.isNotEmpty()) {
			val top = stack.pop()
			for(adj in top.neighbors) {	
				if(map[adj] == null) {
					map[adj] = Node(adj?.`val`!!)
					stack.push(adj)
				}
				map[top]?.neighbors?.add(map[adj])
			}
		}
		return newNode
	}
} 
//-----------------------------------------------------------------------------------------------

//Time: ~4Mins
class SolutionForFindTarget {
	private var targetSum = 0

	private fun findTarget(nums: IntArray, target: Int, index: Int, sum: Int) {
		if(index == nums.size) {
			if(sum == target) return targetSum++
		} eles {
			findTarget(nums, target, index+1, sum+nums[index])
			findTarget(nums, target, index+1, sum-nums[index])
		}
	}
	fun findTargetSumWays(nums: IntArray, target: Int): Int {
		findTarget(nums, target, 0, targetSum)
		return targetSum
	}
}
