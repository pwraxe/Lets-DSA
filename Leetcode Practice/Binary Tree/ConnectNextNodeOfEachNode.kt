//Leetcode: Just like Level Order Traversal, Only connect each level node with next to it
class Solution {
    
    private fun doConnect(node: Node?) {
        if(node == null) return
        node?.left?.next = node?.right
        node?.right?.next = node?.next?.left
        //Here you alredy Connected to next at first 
        //thats why we took ref. of next insted of node?.right?.left
        
        doConnect(node?.left)
        doConnect(node?.right)
    }
    
    fun connect(root: Node?): Node? {
        if(root == null) return null
        doConnect(root)
        return root
    }
}
