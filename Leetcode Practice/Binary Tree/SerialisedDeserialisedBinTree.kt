/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {

	private val text  = StringBuilder()

	private fun preOrder(node: TreeNode?) {
		if(node == null) {
      text.append(",")
      return 
    }
      text.append("${node?.`val`},")	
      preOrder(node?.left)
      preOrder(node?.right)
    }
    
    fun serialize(root: TreeNode?): String {
		    preOrder(root)
		    return text.toString()
    }

    private fun doDeserialised(list: MutableList<String>): TreeNode? {
        val node = list.removeAt(0)
        if(node == null || node == "") return null
        
        val root = TreeNode(node?.toInt())
        if(list.isNotEmpty()) root?.left = doDeserialised(list)
        if(list.isNotEmpty()) root?.right = doDeserialised(list)
        return root
    }
    
    fun deserialize(data: String): TreeNode? {
        return doDeserialised(data.split(",").toMutableList())
    }
}
