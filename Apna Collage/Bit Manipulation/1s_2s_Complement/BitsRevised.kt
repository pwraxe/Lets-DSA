class Solution {
    fun toBinary(n:Int, bin:String): String {
        if (n == 0) return bin
        return toBinary(n/2, "${n%2}"+bin )
    }
    fun toOctal(n: Int, oct:String): String {
        if (n == 0) return oct 
        return toOctal(n/8, "${n%8}"+oct)
    }
    fun toHexaDecimal(n:Int, hex:String):String {
        if (n == 0) return hex 
        val char = if (n%16 in 10 ..15) "${(55 + n%16).toChar()}" else "${n%16}"
        return toHexaDecimal(n/16,char+hex)
    }

    fun anding(a:Int,b:Int) {
        println("anding of $a and $b = ${a and b}")
    }
    fun oring(a: Int,b: Int) {
        println("oring of $a or $b = ${a or b}")
    }
    fun xoring(a:Int, b: Int) {
        println("oring of $a xor b = ${a xor b}")
    }

    fun isEven(n: Int): Boolean {
        return (n and 1) == 0
    }
    fun getIndexBit(n:Int, index:Int): Int {
        val mask = 1 shl index
        return if (n and mask > 0) 1 else 0
    }
    fun setBitAt(num:Int,index: Int) {
        val mask = 1 shl index
        val newNum = num or mask
        println("Num: $newNum | ${toBinary(newNum,"")}")
    }
    fun clearBitAt(num: Int,index:Int) {
        val mask = (1 shl index).inv()
        val newNum = num and mask
        println("Num: $newNum | ${toBinary(newNum,"")}")
    }
    fun updateBitAt(num: Int,index: Int) {
        val mask = 1 shl index
        val newNum = num or mask
        println("Num: $newNum | ${toBinary(num,"")}")
    }
}

fun main() {
    Solution().apply {
        val num = 53
        println("$num Binary --> ${toBinary(num,"")}")
        println("$num Octal  --> ${toOctal(num,"")}")
        println("$num HexaD  --> ${toHexaDecimal(num,"")}")
        anding(5,6)
        oring(5,6)
        xoring(5,6)
        println("is $num Even? = ${isEven(num)}")
        println("Bit of index 1: ${getIndexBit(num,2)}")
        setBitAt(num,3)
        clearBitAt(num,2)
        updateBitAt(num,2)
    }
}


53 Binary --> 110101
53 Octal  --> 65
53 HexaD  --> 35
anding of 5 and 6 = 4
oring of 5 or 6 = 7
oring of 5 xor b = 3
is 53 Even? = false
Bit of index 1: 1
Num: 61 | 111101
Num: 49 | 110001
Num: 53 | 110101
