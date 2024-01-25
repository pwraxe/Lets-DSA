class Solution {
     fun stringCompress(str: String): String {
         val freq = IntArray(26)
         for (i in str.indices) {
             val index = str[i] - 'a'
            freq[index]++
         }
         val compress = StringBuilder()
         for (i in freq.indices) {
             val char = (97 + i).toChar()
             if (freq[i] > 1) {
                 compress.append(char).append(freq[i])
             } else if(freq[i] == 1) {
                 compress.append(char)
             }
         }
         return compress.toString()
     }
}

fun main() {
    Solution().apply {
        println(stringCompress("aaaabbcccdd"))
        println(stringCompress("abcd"))
    }
}


// a4b2c3d2
// abcd
