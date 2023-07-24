//Leetcode: Preorder Traversal Iterativly

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        
        //Mistake 1  
        val stack = Stack<TreeNode>()
        
        stack.add(root)
        //Mistake 2
        while(stack.isNotEmpty()) {
            val currentNode = stack.peek()
            stack.pop()
            if(currentNode != null) {
                result.add(currentNode?.`val`)
                stack.add(currentNode?.right)
                stack.add(currentNode?.left)
            }
        }
        return result
    }
}

/**
//Mistake 1: You forgot, stack is for Node not For Int or any value of node, thats why you getting error for adding currentNode?.left and currentNode?.right 
//Mistake 2: you were checked stack!= null, insted of stack.isNotEmpty(), this is why you getting StackEmptyException
**/
