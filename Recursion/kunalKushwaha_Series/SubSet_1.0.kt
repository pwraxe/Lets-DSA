//Akshay you have new learning in this code
//this is off-cource backtracking but usually only 2 calls made in backtracking,
//its not compalsary for two recursive call, calls can be any num of time
//with different purpose, 
//As you can see, 3 different toSubList() recursive calls made, with different purpose

class Solution {

    private val list = mutableListOf<String>()
    private fun toSubList(input: String, output:String): List<String> {
        if (input.isEmpty()) {
            list.add(output)
            return list
        }

        toSubList(input.substring(1), output + input.first())
        toSubList(input.substring(1), output + input.first() + "_" + input.first().toInt())
        toSubList(input.substring(1), output)

        return list
    }

    fun getSubSeq(text: String): List<String> {
         return toSubList(text,"")
    }
}

fun main() {
    Solution().apply {
        println(getSubSeq("abc").toTypedArray().contentToString())
    }
}

//Output: 
[abc, abc_99, ab, ab_98c, ab_98c_99, ab_98, ac, ac_99, a, a_97bc, a_97bc_99, a_97b, a_97b_98c, a_97b_98c_99, a_97b_98, a_97c, a_97c_99, a_97, bc, bc_99, b, b_98c, b_98c_99, b_98, c, c_99, ]

