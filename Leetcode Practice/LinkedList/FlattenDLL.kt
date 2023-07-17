//Leetcode : Flatten Doubly Linked List, (In Other Word -> Level OrderTraversal)
//TC: O(n)
//SC: 'O(1)

class Solution {
    fun flatten(root: Node?): Node? {
        
        var current = root
        while(current != null) {
            if(current.child == null) {
                current = current?.next
                continue
            }
            
            var childTail = current?.child
            //Send Child Tail To end of sub list
            while(childTail?.next != null) {
                childTail = childTail?.next
            }
            
            //Link last node of sub list ot next node of current list
            childTail?.next = current?.next
            
            //if we not last node then link last node with next prev
            if(current?.next != null) current?.next?.prev = childTail
            
            //Now, we traverse via child hence link current node with next sub child
            current?.next = current?.child
            
            //Update Child 
            current?.child?.prev = current 
            
            //as we already link, remove linking to avoid loop
            current?.child = null
        }
        return root
    }
}
