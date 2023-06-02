//Problem: String contains vowels or not
fun main() {
    val text1 = "Hll thr" //false
    val text2 = "Hello there" //true
    println("Check 1 : ${checkForVowels(text1)}")
    println("Check 2 : ${checkForVowels_Optimized(text2)}")
}

//Time Complexity : O(n)
fun checkForVowels(text: String) : Boolean {
    val list = listOf('a','e','i','o','u','A','E','I','O','U')
    text.forEach {
        if(list.contains(it)) return true
    }
    return false
}

//Time Complexity : O(1)
fun checkForVowels_Optimized(text: String) : Boolean {
    return text
        .lowercase()
        .matches(".*[aeiou].*".toRegex())
}
