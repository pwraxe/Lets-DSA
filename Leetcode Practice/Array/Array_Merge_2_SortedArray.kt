
//===========================================================================My Wrong Code 😂 =====================
//Works Correctly on nums1 : [1,2,3,0,0,0], nums2 : [2,5,6]
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        //Base Case
        if(nums1.size == 0) {
           return
       }
        if(m == 1 && n == 0) {
           nums1
           return
       }
        if(m == 0 && n == 1) {
           nums1[0] = nums2[0]
           return
       }
       
        var num1_i = 0
        var num2_i = 0

        while(num1_i < m) {
            if(nums2[num2_i] < nums1[num1_i]) {
                var num1_j = nums1.size - 1
                while(num1_j > num1_i) {
                    nums1[num1_j] = nums1[num1_j-1]
                    num1_j--
                }
                
                nums1[num1_i] = nums2[num2_i]
                num1_i++
                num2_i++
                
            } else num1_i++
        }
        //num1_i++
        while (num2_i < n) {
            num1_i++
            nums1[num1_i] = nums2[num2_i]
            num2_i++
            
        }
    }
}
