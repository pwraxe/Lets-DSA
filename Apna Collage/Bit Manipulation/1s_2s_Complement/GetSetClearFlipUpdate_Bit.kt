class Bits {

    //get bit of given index
    fun Int.getBitAt(index: Int): Int {
        val mask = 1 shl index
        return if (this and mask == 0) 0 else 1
    }

    //set 1 to index
    fun Int.setBitAt(index: Int): Int {
        val mask = 1 shl index
        return this or mask
    }

    //set 0 to given index whether is 0 or 1
    fun Int.clearBitAt(index: Int): Int {
        val mask = (1 shl index).inv()
        return this and mask
    }

    //if bit at index is 1 then flip to 0 or vice-versa
    fun Int.flipBit(index: Int):Int {
        val bit = getBitAt(index)
        return if (bit == 0) {
            setBitAt(index)
        } else {
            clearBitAt(index)
        }
    }

    //update given bit at given index
    fun Int.updateBitAt(index: Int,bit:Int):Int {
        return if (bit == 0) {
            clearBitAt(index)
        } else {
            setBitAt(index)
        }
    }

    //update given bit at given index way 2
    fun Int.updateBitAtWay2(index: Int, bit: Int): Int {
        val n = clearBitAt(index)
        val mask = bit shl index
        return n or mask
    }
}

fun main() {
    Bits().apply {
        val num = 119
        println("$num.toBinary() = ${num.toString(2)}")
        for (index in 0 .. 7) {
            println("Get Bit @ index $index = ${num.getBitAt(index)}")
        }
        println("1 ===========================")

        println("Before Set: ${num.toString(2)}")
        println("After Set: ${num.setBitAt(3).toString(2)}")
        println("2 ===========================")

        println("Before Clear 5th index: ${num.toString(2)}")
        println("After  Clear 5th index: ${num.clearBitAt(5).toString(2)}")
        println("3 ===========================")

        println("Before Flipped: ${num.toString(2)}")
        val flipped5 = num.flipBit(5)
        println("After  Flipped: ${flipped5.toString(2)}")

        val rev = flipped5.flipBit(5)
        println("ReverseFlipped: ${rev.toString(2)}")

        println("4 ===========================")

        println("Before Update  index 5: ${num.toString(2)}")
        println("After Update 0 index 5: ${num.updateBitAt(2,0).toString(2)}")
        println("After Update 1 index 5: ${num.updateBitAt(3,1).toString(2)}")

        println("5 ===========================")
        println("Before Update  index 6: ${num.toString(2)}")
        println("After Update 0 index 6: ${num.updateBitAt(6,0).toString(2)}")
        println("After Update 1 index 4: ${num.updateBitAt(4,1).toString(2)}")
    }
}




119.toBinary() = 1110111
Get Bit @ index 0 = 1
Get Bit @ index 1 = 1
Get Bit @ index 2 = 1
Get Bit @ index 3 = 0
Get Bit @ index 4 = 1
Get Bit @ index 5 = 1
Get Bit @ index 6 = 1
Get Bit @ index 7 = 0
1 ===========================
Before Set: 1110111
After Set: 1111111
2 ===========================
Before Clear 5th index: 1110111
After  Clear 5th index: 1010111
3 ===========================
Before Flipped: 1110111
After  Flipped: 1010111
ReverseFlipped: 1110111
4 ===========================
Before Update  index 5: 1110111
After Update 0 index 5: 1110011
After Update 1 index 5: 1111111
5 ===========================
Before Update  index 6: 1110111
After Update 0 index 6: 110111
After Update 1 index 4: 1110111
