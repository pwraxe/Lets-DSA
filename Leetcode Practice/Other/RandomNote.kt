//Leetcode: 383. Ransom Note
//TC: O(n)
//SC: O(1)
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hashMap = hashMapOf<Char, Int>()

        magazine.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }

        ransomNote.forEach {
            val count = hashMap.getOrDefault(it, 0)
            if(count == 0) return false
            hashMap[it] = count-1
        }
        
        return true
    }
}
