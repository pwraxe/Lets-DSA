class Solution {
    fun countLowerCase(string: String) {
        var count = 0
        string.forEach {
            if (it in 'a'..'z') {
                count++
            }
        }
        println("Total Lower Case in '$string' : $count")
    }
    fun countLowerCaseVowels(string: String) {
        var count = 0
        val vowels = arrayOf('a','e','i','o','u')
        string.forEach {
            if (it in 'a'..'z' && vowels.contains(it)) {
                count++
            }
        }
        println("Total Lowercase Vowels in '$string' : $count")
    }

    fun isAnagram(str1: String, str2: String): Boolean {
        val s1 = str1.toCharArray().sorted()
        val s2 = str2.toCharArray().sorted()
        return s1.joinToString("") == s2.joinToString("")
    }
}

fun main() {
    Solution().apply {
        countLowerCase("Hello There")
        countLowerCaseVowels("Hello There")

        //Q2: false | true
        //Q3: ApnaCoege

        println(isAnagram("flesh","shelf"))
    }
}

Total Lower Case in 'Hello There' : 8
Total Lowercase Vowels in 'Hello There' : 4
true
