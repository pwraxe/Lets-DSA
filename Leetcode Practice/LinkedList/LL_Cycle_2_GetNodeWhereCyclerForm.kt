//LeetCode: LinkedList Cycle || 
//TC: O(n), used while loop twice > O(n) + O(n) = O(2n) = O(n)
//SC: O(1), No Extra space used except, fast and slow pointers which is considered as Constant space
class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if(head == null || head?.next == null) return null
        
        var fast = head
        var slow = head
        
        while(fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if(fast == slow) break
        }
        
        //Reset Fast
        fast = head
        
        while(fast != slow) {
            fast = fast?.next
            slow = slow?.next
        }
        
        return fast
    }
}

//------------------------------------------------------------------------

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if(head == null ||head.next == null) return null
        
        var fastHead = head
        var slowHead = head

        while(fastHead != null && fastHead?.next != null) {
            //Slow Pointer always runs by 1 step
            slowHead = slowHead?.next

            //Fast Pointer always runs by 2 steps
            fastHead = fastHead?.next?.next

            //At Some time/place fast pointer can overtake slow pointer, 
            //and We will get both at same position
            if(fastHead == slowHead) break
        }

        fastHead = head
        while(fastHead != slowHead) {
            fastHead = fastHead?.next
            slowHead = slowHead?.next
        }
        

        //We have node where Fast pointer returning back
        return slowHead

    }
}
