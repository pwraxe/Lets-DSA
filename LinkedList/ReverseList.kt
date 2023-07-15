//Leetcode:   Reverse Linked List, (Iterative method)
//TC: O(n), used loop
//SC: O(1)

class Solution {
    
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) return null
   
        var currentNode = head
        var prevNode : ListNode? = null
        
        while(currentNode != null) {
            var nextNode = currentNode?.next
            currentNode?.next = prevNode
            prevNode = currentNode
            currentNode = nextNode
        }
        return prevNode
    }
}

//------------------------------------------------------------------------

