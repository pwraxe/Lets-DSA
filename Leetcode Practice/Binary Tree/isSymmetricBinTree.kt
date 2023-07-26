//Leetcode: Symmetric Tree

class Solution {    
	private fun isSame(left: TreeNode?, right: TreeNode?) : Boolean {
		if(left == null && right == null) return true
		if(left == null || right == null) return false

    
		val isValSame = left?.`val` == right?.`val`      //Line-1
		val isLeftSame = isSame(left?.left, right?.right) //Line-2
		val isRightSame = isSame(left?.right, right?.left) // Line-3
		return isValSame && isLeftSame && isRightSame  //Line-4
  }
  fun isSymmetric(root: TreeNode?): Boolean {
	    if(root == null) return true
	    return isSame(root, root)
  }
}


/**
Note: Line-1, Line-2, Line-3 is strictly most important, 
Line-1: checks the data in Node
Line-2: check leftOfLeft Node and RightOfRight Node
Line-3: Same as Line-2 with RightNodeofLeft and leftNodeOfRight
Line-4: all Consition should match 
**/
