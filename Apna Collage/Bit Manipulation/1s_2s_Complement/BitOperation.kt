class BitManipulation {
    fun binAnd(a: Int, b: Int): Int = a and b
    fun binOr(a: Int, b:Int): Int = a or b
    fun binXor(a: Int, b: Int): Int = a xor b
    fun bin1sComp(a:Int): Int = a.inv()
    fun binLeftShift(a: Int, shiftBy:Int) = a shl shiftBy
    fun binRightShift(a: Int, shiftBy: Int) = a shr shiftBy
    fun isEven(a: Int): Boolean = (a and 1) == 0
    fun getIthBit(a:Int, index:Int):Int {
        val mask = 1 shl index
        return if(binAnd(a,mask) == 0) 0 else 1
    }
    fun setIthBit(a:Int, index:Int):Int {
        val mask = 1 shl index
        return binOr(a, mask)
    }
    fun clearIthBit(a: Int, index: Int): Int {
        val mask = (1 shl index).inv()
        return binAnd(a,mask)
    }
    fun updateIthBit(a: Int, bitToUpdate: Int, index: Int): Int {
        return if (bitToUpdate == 0) {
            clearIthBit(a, index)
        } else {
            setIthBit(a, index)
        }
    }


    /**
    Way 1: `and` with Hex value 0XFFF0
        val res = num and 0XFFF0

    Way 2: 
    =>    val mask = ( (1 shl n)-1 ).inv()
    =>    val res = num and mask    
    */
    fun clearLastIthBits(a:Int, index:Int): Int {
        val mask = 0.inv() shl index
        return a and mask
    }

    /**
    val mask = { [ ( 1 shl n ) - 1 ] shl n }.inv()
    Here inv => i.e., negation

    val res = num and mask 
    */
    fun clearBitsInRange(a:Int, start: Int, end: Int): Int {
        var num = a
        for (index in start..end) {
            num = clearIthBit(num,index)
        }
        return num
    }
    fun clearBitsInRange2(n:Int, start: Int, end: Int): Int {
        val a = 0.inv() shl end+1
        val b = (1 shl start) - 1
        val mask = a or b
        return n and mask
    }
    fun isPowerOf2(a: Int): Boolean = (a and a-1) == 0
    fun count1s(a: Int): Int {
        var count = 0
        var n = a
        while (n > 0) {
            if (n and 1 != 0) {
                count++
            }
            n = n shr 1
        }
        return count
    }
    fun Int.pow(n: Int): Int {
        var a = this
        var n = n
        var result = 1
        while (n > 0) {
            if (n and 1 != 0) {
                result *= a
            }
            a *= a
            n = n shr 1
        }
        return result
    }
}
fun main() {
    BitManipulation().apply {
        val a = 119
        val b = 136
        println("$a = ${a.toString(2)}  |  $b = ${b.toString(2)}")
        println("Bin and = ${binAnd(a,b)}")
        println("Bin or  = ${binOr(a,b)}")
        println("Bin xor = ${binXor(a,b)}")
        println("Bin 1's = ${bin1sComp(a)}")
        println("Bin <<  = ${binLeftShift(a,3)}")
        println("Bin >>  = ${binRightShift(a,3)}")
        println("isEven  = ${isEven(a)}")
        println("isEven  = ${isEven(b)}")
        println("GetIth  = ${getIthBit(a,6)}")
        println("SetIth  = ${setIthBit(a,3)}")
        println("ClearIth= ${clearIthBit(a,2)}")
        println("UpdateIth = ${updateIthBit(a,1,3)}")
        println("ClearLastI = ${clearLastIthBits(a,3)}")
        println("ClearBitInRange = ${clearBitsInRange(a,1,4)}")
        println("ClearBitInRange2 = ${clearBitsInRange2(a,1,4)}")
        println("isPowerOf2 = ${isPowerOf2(18)}")
        println("Count 1 = ${count1s(a)}")
        println("Count 1 = ${count1s(b)}")
        println("Power   = ${4.pow(5)}")
    }
}




119 = 1110111  |  136 = 10001000
Bin and = 0
Bin or  = 255
Bin xor = 255
Bin 1's = -120
Bin <<  = 952
Bin >>  = 14
isEven  = false
isEven  = true
GetIth  = 1
SetIth  = 127
ClearIth= 115
UpdateIth = 127
ClearLastI = 112
ClearBitInRange = 97
ClearBitInRange2 = 97
isPowerOf2 = false
Count 1 = 6
Count 1 = 2
Power   = 1024
