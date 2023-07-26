//Leetcode: Path Sum (calculate all value of node which sum of targetSum) if it is then true else false

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if(root == null) return false
        if(root?.left == null && root?.right == null) {
            return targetSum - root?.`val` == 0
        }
        return hasPathSum(root?.left, targetSum-root?.`val`) || 
        hasPathSum(root?.right, targetSum-root?.`val`)
    }
}
