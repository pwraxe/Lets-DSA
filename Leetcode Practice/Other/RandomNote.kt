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

//-------------------------------------------------------------------------------------------------------------------------
//TC: O(n), used loop once
//SC: O(n), Why?, I don't know how much length of string I will have as a input in Runtime, and I converted to list, thats why O(1)
//Better to use HashMap, for DC: O(1), 
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magz = magazine.toMutableList()
        val note = ransomNote.toMutableList()

        note.forEach {
            //remove element
            //if true then remve next else return false
            val removed: Boolean = magz.remove(it)
            if(!removed) {
                return false
            }
        }
        return true
    }
}
