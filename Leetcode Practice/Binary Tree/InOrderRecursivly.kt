 
class Solution {
  
    //Recursive Way
    val result = mutableListOf<Int>()
    
    private fun iot(node: TreeNode?) {
        if(node == null) return
        
        iot(node?.left)
        result.add(node?.`val`)
        iot(node?.right)
    }
    fun inorderTraversal(root: TreeNode?): List<Int> {
        iot(root)
        return result
    }
}
