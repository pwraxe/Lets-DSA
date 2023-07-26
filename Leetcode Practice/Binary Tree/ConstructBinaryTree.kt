//Leetcode: Construct Binary Tree given inorder and post order list

class Solution {
    
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        //We always have root at last in post order
        var rootElement = postorder.last()    
        var root = TreeNode(rootElement)
        
        //We have to devide inorder list based on rootIndex in inorder list
        var index = inorder.indexOf(rootElement)
        
        var leftInOrderList = inorder.copyOfRange(0,index)
        var rightInOrderList = inorder.copyOfRange(index+1 , inorder.size)
        var leftPostOrder = postorder.copyOfRange(0 , index)
        var rightPostOrder = postorder.copyOfRange(index , postorder.size-1)
        
        root.left = if(leftInOrderList.isNotEmpty()) buildTree(leftInOrderList, leftPostOrder) else null
        root.right = if(rightInOrderList.isNotEmpty()) buildTree(rightInOrderList, rightPostOrder) else null
        
        return root
    }
}
