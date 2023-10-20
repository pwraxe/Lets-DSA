class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        root ?: return null
        
        when {
            key > root.`val` -> root.right = deleteNode(root.right,key)
            key < root.`val` -> root.left = deleteNode(root.left,key)
            else -> {              
                
                //Delete Node having 1 child
                root.left ?: return root.right
                root.right ?: return root.left
            
                //Delete node having 2 childs
                var mNode = root.right
                while (mNode?.left != null) {
                    mNode = mNode.left
                }
                root.`val` = mNode?.`val` ?: 0
                root.right = deleteNode(root.right,root.`val`)
            }
        }
        return root
    }
}
