class Solution {

    private val numText = listOf("zero","one", "two","three", "four","five","six","seven","eight","nine")

    fun indexesOfKey(list: List<Int>, index:Int, key: Int) {
        if (index == list.size) {
            println()
            return
        }
        if (list[index] == key) {
            print("$index ")
        }
        indexesOfKey(list, index+1, key)
    }
    
    fun String.toString(result: StringBuilder, index: Int = 0): String {
        if (index == this.length) {
            return result.toString()
        }
        val charIndex = this[index].digitToInt()
        result.append(numText[charIndex]).append(" ")
        return this.toString(result, index+1)
    }
    
    fun String.length(index:Int = 0): Int {
        if (index == this.length) return index
        return this.length(index+1)
    }
    
    fun stringSize(input: String):Int {
        if (input.isEmpty()) {
            return 0
        }
        return stringSize(input.substring(1)) + 1
    }
    
    fun countOfContiguousSubString(input:String,i:Int, j:Int, size: Int): Int {
        if (size == 1) return 1
        if (size <= 0) return 0

        var result = countOfContiguousSubString(input, i+1, j, size-1) +
                countOfContiguousSubString(input, i, j-1, size-1) -
                countOfContiguousSubString(input, i+1, j-1, size-2)

        if (input[i] == input[j]) result++
        return result
    }

    fun contiguousSubString(input: String): List<String> {
        val list = mutableListOf<String>()
        for (i in 0 until input.length) {
            for (j in i .. input.length) {
                val subString = input.substring(i,j)
                if (subString.isNotEmpty() && subString.first() == subString.last()) {
                    list.add(subString)
                }
            }
        }
        return list
    }
    
    fun towerOfHanoi(n:Int, src:Char, aux:  Char, dest: Char) {
        if (n == 1) {
            println("$src -> $dest")
            return
        }
        towerOfHanoi(n-1, src, dest, aux)
        towerOfHanoi(1, src, aux, dest)
        towerOfHanoi(n-1, aux, src, dest)
    }
}


fun main() {
    Solution().apply {
        val list = listOf(3, 2, 4, 5, 6, 2, 7, 2, 2)
        indexesOfKey(list,0,2)
        println("2017".toString(StringBuilder()))
        println("Hello World".length())
        println(stringSize("Hello World"))

        println("===========================================")

        val input = "abcab"
        println("Count: ${contiguousSubString(input).size}")
        println("Count: ${countOfContiguousSubString(input,0, input.lastIndex,input.length)}")
        
        println("===========================================")
        towerOfHanoi(3,'A','B','C')
    }
}



// 1 5 7 8 
// two zero one seven 
// 11
// 11
// ===========================================
// Count: 7
// Count: 7
// ===========================================
// A -> C
// A -> B
// C -> B
// A -> C
// B -> A
// B -> C
// A -> C
