//Leetcode: Clone Linked List

//TC: O(n), used loop
//SC: O(n), used map
class Solution {
    
    private var head: Node? = null
    private var tail: Node? = null
    
    private fun addLast(item: Int) : Node? {
        val node = Node(item)
        if(tail == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
        return node
    }
    
    fun copyRandomList(node: Node?): Node? {
        
        //Step1: Copy all values and create new list
        //Step2: WHile Performing Step1, add oroginal node to map
        //Step3: iterate thru original to modify new list for random
        
        var map = hashMapOf<Node?, Node?>()
        var root = node
        while(root != null) {
            map[root] = addLast(root?.`val`)
            root = root?.next
        }
        
        root = node
        
        //We have copied node list, but we dont have random in it
        var temp = head
        while(root!=null) {
            temp?.random = map[root?.random]
            temp = temp?.next
            root = root?.next
        }
        
        return head
    }
}
