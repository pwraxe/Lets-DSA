
 
class Solution {    

	private var result: Int = 1

    fun maxDepth(node: TreeNode?, depth: Int) {
        if(node == null) return
        if(node?.left == null && node?.right == null) {
            result = Math.max(result, depth)
        }
        maxDepth(node?.left, depth+1)
        maxDepth(node?.right, depth+1)
    }	

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        maxDepth(root, result)
        return result
    }
}



/***
class Solution {

    private var result : Int = 1

    private fun max_depth(node:TreeNode?, depth: Int) {

        if(node == null) return
        if(node?.left == null && node?.right == null) {
            result = Math.max(result, depth)
        }
        max_depth(node?.left, depth+1)
        max_depth(node?.right, depth+1)
    }

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        max_depth(root,result)
        return result
    }
}
**/
