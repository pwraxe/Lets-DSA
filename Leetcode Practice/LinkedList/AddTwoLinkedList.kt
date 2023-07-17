//Leetcode: Add Two List
//TC: O(n), used loop
//SC: O(n), created new list



//Recursive Solution
class Solution {
    
    fun ListNode?.value() = this?.`val` ?: 0
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry : Int = 0): ListNode? {
        if(l1 == null && l2 == null && carry == 0) return null
        val sum = l1.value() + l2.value() + carry
        return ListNode(sum%10).apply { next = addTwoNumbers(l1?.next, l2?.next, sum/10)}
    }
}

//--------------------------------------------------------------------------------------------------------

//Iterative Solution
class Solution {

    var carry = 0
    var ansHead : ListNode? = null
    var ansTail : ListNode? = null

    fun checkForCarry(sum: Int) {
        if(sum > 9) {
            val lastDigit = sum % 10 //0
            addToTail(lastDigit)
            carry = sum / 10         //1
        } else {
            addToTail(sum)
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null && l2 == null) return null
        if(l1 == null) return l2
        if(l2 == null) return l1

        var list1 = l1
        var list2 = l2

        while(list1 != null && list2 != null) {
            val sum = list1.`val` + list2.`val` + carry
            carry = 0
            checkForCarry(sum)
            list1 = list1.next
            list2 = list2.next
        }

        while(list1 != null) {
            val sum = list1.`val` + carry
            carry = 0
            checkForCarry(sum)
            list1 = list1.next
        }
        while(list2 != null) {
            val sum = list2.`val` + carry
            carry = 0
            checkForCarry(sum)
            list2 = list2?.next
        }

        if(carry != 0) addToTail(carry)

        return ansHead
    }


    private fun addToTail(item: Int) {
        val node = ListNode(item)
        if(ansTail == null) {
            ansHead = node
            ansTail = node
        } else {
            ansTail?.next = node
            ansTail = node
        }
    }
}
