//LeetCode :141. Linked List Cycle
//TC: O(n), going end of list
//SC: O(1), using same memory by updating node value as visited

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        
        var headNode = head
        var visited = 100000 //from based on constrints 10^4 
        
       while(headNode != null && headNode?.`val` != visited) {
            //Update Value as Visited
            headNode?.`val` = visited
            //Goto Next Node
            headNode = headNode?.next
        }
        return headNode?.next != null
    }
}

/**
Note: This Question is only asked Cycler or not, They did not specify value will modify or change or not, 
Hence Simply update node values so that If we got owr updated value it mean break the loop and return yes
**/
