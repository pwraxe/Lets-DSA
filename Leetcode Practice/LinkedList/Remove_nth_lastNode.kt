//Leetcode :   Remove Nth Node From End of List
//TC: O(n), used loop
//SC: O(1)
//By Two Pointer Concept

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        
        if(head == null || head?.next == null) return null
        
        var fast = head
        var slow = head

      
        /**Strict Note For you Akshay, You need to understand How fast and slow pointer works for initialised them  **/
      
        //Step1: Init or Setup fast pointer, here slow pointer will nth steps behind than fast pointer
        for(index in 1 .. n+1) { //we have to go until null
            //parallely we also have to check whether n == count
            if(fast == null) return head?.next
            fast = fast?.next
        }
        
        println("Fast : ${fast?.`val`}")
        
        //Step2: move slow pointer until get fast as null
        while(fast!=null) {
            fast = fast?.next
            slow = slow?.next 
        }
        
        println("Slow : ${slow?.`val`} || Fast: ${fast?.`val`}")
        //Step3: To Remove Node, update next of slow to its next node
        slow?.next = slow?.next?.next
        
        return head
        
    }
}





//Leetcode :   Remove Nth Node From End of List
//TC: O(n), used loop
//SC: O(1)
//This code can better solved by Two pointer concept

class Solution {
    
    //They say in -> 1Pass
    
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null || head?.next == null) return null  
        
        //Step 1: Count Total Nodes
        var node = head
        var count = 0
        while(node != null) {
            node = node?.next
            count++
        }
        
        //Step 2: Check currentNode == n if it return head
        node = head
        if(count == n) return head?.next
        
        //Step 3: Loop until count-n, removeit
        for(i in 1 until count-n) {
            node = node?.next
        }
        
        node?.next = node?.next?.next
        
        //return toRemove  --> Your Mistake, you are trying to return node which you deleted, 
        //But problem statement wants head node :(
        return head
    }
    
    fun read(head: ListNode?) {
        var node = head
        val list = mutableListOf<Int>()
        while(node != null) {
            list.add(node?.`val`)
            node = node?.next
        }
        
        println("Read : ${list.toTypedArray().contentToString()}")
    }
}
