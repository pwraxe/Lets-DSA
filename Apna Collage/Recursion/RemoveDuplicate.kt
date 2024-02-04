class Solution {

    fun removeDuplicate(
        str: String,
        index: Int = 0,
        isSeen: Array<Boolean> = Array(26) { false },
        result: String = ""): String {

        if (index == str.length){
            return result
        }

        val charIndex = str[index] - 'a'
        return if (isSeen[charIndex]) {
            removeDuplicate(str, index+1, isSeen, result)
        } else {
            isSeen[charIndex] = true
            removeDuplicate(str, index+1, isSeen, result + str[index])
        }
    }

}
fun main() {

    Solution().apply {
        val result = removeDuplicate("appnnacollege")
        println(result)
    }
}

//apncoleg
