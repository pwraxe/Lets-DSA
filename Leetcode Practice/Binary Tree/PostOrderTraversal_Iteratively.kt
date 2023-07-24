class Solution {
    //Iterative
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>() 
        
        var currentNode = root
        stack.push(currentNode)
        
        while(stack.isNotEmpty()) {
            currentNode = stack.pop()
            currentNode?.left?.let { stack.push(it) }
            currentNode?.right?.let { stack.push(it) }
            //After poping element check current Node is not null, if it is not null then add to 0th index
            currentNode?.let {
                list.add(0, currentNode.`val`)    
            }
        }
        return list
    }
}
