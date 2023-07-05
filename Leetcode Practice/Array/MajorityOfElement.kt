//Count How many times perticular no detected, 
//return that no which has count is more than array.size/2 else return -1
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEach {
            var values = hashMap[it] ?: 0
            hashMap[it] = ++values
            if(values > nums.size / 2) return it
        }
        return -1
    }
}
