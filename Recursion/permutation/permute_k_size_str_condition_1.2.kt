class Solution {

    private val list = mutableListOf<String>()

    private fun String.isPalindrome(startIndex: Int = 0, endIndex:Int = this.length-1): Boolean {
        if (startIndex > endIndex) return true
        if (this[startIndex] != this[endIndex]) return false
        return this.isPalindrome(startIndex+1, endIndex-1)
    }
    private fun permute(text: String, size: Int, subString: StringBuilder) {
        if (subString.length == size) {
            list.add(subString.toString())
            return
        }

        for (i in 0 until text.length) {
            subString.append(text[i])
            if (subString.toString().isPalindrome()) {
                permute(text, size, subString)
            }
            subString.setLength(subString.length-1)
        }
    }
    fun permuteSubString(text:String) {

        //List: [A, S, P]
        //val expectedStringSize = 1

        //List: [AA, AS, AP, SA, SS, SP, PA, PS, PP]
        //val expectedStringSize = 2

        //List:[AAA, AAS, AAP, ASA, ASS, ASP, APA, APS, APP, SAA, SAS, SAP, SSA, SSS, SSP, SPA, SPS, SPP, PAA, PAS, PAP, PSA, PSS, PSP, PPA, PPS, PPP]
        //val expectedStringSize = 3

        val expectedStringSize = 4
        permute(text,expectedStringSize, StringBuilder())
        println(list.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        permuteSubString("ASP")
    }
}
