/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        //Lets Find Root Element frm preorder
        
        if(preorder.size == 0) return null
        
        val root = preorder.first()

        //Find out root index from inorder
        val rootIndex = inorder.indexOf(root)

        //Create Node
        val node = TreeNode(root)
      
        /*******NOTE: NOTE: NOTE::: YOu were made mistake by deviding list,***********/
         //Devide Pre-Order List
        val leftPreSubList= preorder.copyOfRange(1, rootIndex+1)
        val rightPreSubList = preorder.copyOfRange(rootIndex+1, preorder.size)
        
        /******************Learn and Study carefully of above division****************/
        
        //Device In-Order List
        val leftInOrderList = inorder.copyOfRange(0, rootIndex)
        val rightInSubList = inorder.copyOfRange(rootIndex+1, inorder.size)

        node?.left = if(leftPreSubList.isNotEmpty()) buildTree(leftPreSubList, leftInOrderList) else null
        node?.right = if(rightPreSubList.isNotEmpty()) buildTree(rightPreSubList, rightInSubList) else null

        return node

    }
}
