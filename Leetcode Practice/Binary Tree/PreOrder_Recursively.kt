//Leetcode:   Binary Tree Preorder Traversal

class Solution {
    private val result = mutableListOf<Int>()
    private fun pot(node: TreeNode?) {
        if(node == null) return
        //Observed Carefully

        //In Pre-Order
        //1. We added root node first
        result.add(node?.`val`)
        //Then went to left
        pot(node?.left)
        //Then went to right
        pot(node?.right)
    }
    fun preorderTraversal(root: TreeNode?): List<Int> {
        pot(root)
        return result
    }
}


/**
Note: If you observed carefully
1. This is Recursive way to visit all nodes
2. This way, we first added item/ visited root first
then we go left and right

======================================================================
=> Pre-Order Traversal Recursive Example
result.add(node?.`val`)
pot(node?.left)
pot(node?.right)
======================================================================
=> In-Order Traversal Recursive Example
pot(node?.left)
result.add(node?.`val`)
pot(node?.right)
======================================================================
=> Post-Order Traversal Recursive Example
pot(node?.left)
pot(node?.right)
result.add(node?.`val`)

**/
