 
class Solution {
    //Iterative Way
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()   
        val stack = Stack<TreeNode>()
        var currentNode = root
        while(currentNode != null || stack.isNotEmpty()) {
            while(currentNode != null) {
                stack.push(currentNode)
                currentNode = currentNode?.left
            }
            currentNode = stack.pop()
            result.add(currentNode.`val`)
            currentNode = currentNode?.right
        }
        return result
    }
}
