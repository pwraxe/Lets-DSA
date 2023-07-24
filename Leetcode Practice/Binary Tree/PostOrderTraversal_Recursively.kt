class Solution {
    private val list = mutableListOf<Int>()
    private fun pot(node: TreeNode?) {
        if(node == null) return
        pot(node?.left)
        pot(node?.right)
        list.add(node?.`val`)
    }
    //Recursive
    fun postorderTraversal(root: TreeNode?): List<Int> {
        pot(root)
        return list
    }
}

//Time Took to write: 1min 43sec
