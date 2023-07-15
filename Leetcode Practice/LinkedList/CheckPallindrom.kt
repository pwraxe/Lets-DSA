//Leetcode: Check LinkedList has pallindrom or not, 
//TC: O(n)
//SC: O(n)
//Brute force approch (!Recc much)

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var list = mutableListOf<Int>()
        var node = head  
        while(node != null) {
            list.add(node?.`val`)
            node = node?.next
        }
        
        var low = 0
        var high = list.size-1 
        
        while(low < high) {
            if(list[low] == list[high]) {
                low++
                high--
            } else return false
        }
        return true
    }
}
