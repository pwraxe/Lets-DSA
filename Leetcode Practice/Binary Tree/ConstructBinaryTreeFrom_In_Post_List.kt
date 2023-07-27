//Leetcode: Construct Binary Tree given inorder and post order list




//Same as follws: Reapet code or revision
class Solution {    
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        //Find Root Element from postOrder
        val root = postorder.last()

        //Find Index of Root from In-Order
        val rootIndex = inorder.indexOf(root)

        //Create New Node 
        val node = TreeNode(root)

        //Devide list as followes
        //InOrder: LeftInSubList + RightInSubList
        //PostOrder: LeftPostSubList + RightPostSubList

        val leftInSubList = inorder.copyOfRange(0,rootIndex)
        val rightInSubList = inorder.copyOfRange(rootIndex+1, inorder.size)

        val leftPostSubList = postorder.copyOfRange(0, rootIndex)
        val rightPostSubList = postorder.copyOfRange(rootIndex, postorder.size-1)

        node?.left = if(leftInSubList.isNotEmpty()) buildTree(leftInSubList, leftPostSubList) else null
        node?.right = if(rightInSubList.isNotEmpty()) buildTree(rightInSubList, rightPostSubList) else null

        return node
    }
}

//-----------------------------------------------------------------------
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
