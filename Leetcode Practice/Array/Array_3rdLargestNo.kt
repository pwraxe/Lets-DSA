//Leetcode: Third Largest No
//TC: O(n), loop used
//SC: O(1), both Queue and Hashset has max 3 elements hence considered as Constant Space Complexity

class Solution {
    fun thirdMax(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        nums.map { set.add(it) }
        
        //Add to PQ
        val queue = PriorityQueue<Int>()
        set.forEach {
            queue.add(it)
            if(queue.size > 3) {
                //Remove
                queue.poll()
            }
        }
        if(queue.size == 2) queue.poll()
        return queue.peek()
    }
}

//----------------------------------------------------------------------------------------------------------------------------

//Leetcode: Third Largest No
//TC: O(n), loop used
//SC: O(1), both Queue and Hashset has max 3 elements hence considered as Constant Space Complexity

class Solution {
    fun thirdMax(nums: IntArray): Int {
        val priority = PriorityQueue<Int>()
        val set = hashSetOf<Int>()

        for(index in 0 until nums.size) {
            if(set.contains(nums[index])) continue

            if(priority.size == 3) {
                if(nums[index] > priority.peek()) {
                    set.remove(priority.poll())
                    priority.add(nums[index])
                    set.add(nums[index])
                }
            } else {
                priority.add(nums[index])
                set.add(nums[index])
            }
        }

        return if(priority.size == 1) priority.peek()
        else if(priority.size == 2) Math.max(priority.poll(), priority.peek())
        else priority.peek()
    }
}
