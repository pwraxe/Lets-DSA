//Leetcode: Remove Linked List Elements
//TC: O(n)
//SC: O(1)
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        
        if(head == null) return null
        
        var dummyNode = ListNode(0)
        var current = dummyNode
        dummyNode?.next = head
        
        
        //Checks next node value before jump on it
        while(current!= null && current?.next != null) {
            if(current?.next?.`val` == `val`) {
                current?.next = current?.next?.next
            }else {
                current = current?.next
            }
        }
        
        return dummyNode?.next
    }
}


//------------------------------------------------------------
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        
        if(head == null) return null
        var headNode = head
        //Go to End of list
        headNode?.next = removeElements(headNode?.next, `val`)
        
        //return current node or its next if same value
        return if(headNode?.`val` == `val`) headNode?.next else headNode
    }
}
