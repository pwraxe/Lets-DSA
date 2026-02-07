internal object Solution {
    fun getTotalSetBits(n: Int): Int {
        val counter = IntArray(256)
        for (i in 1 .. 255) {
            counter[i] = counter[i and (i-1)] + 1
        }

        for (i in 1 .. 255) {
            println("$i = ${i.toString(2) } = ${counter[i]}")
        }

        println(counter.toTypedArray().contentToString())
        
        val res = counter[n and 255] +
                counter[(n shr 8) and 255] +
                counter[(n shr 16) and 255] +
                counter[(n shr 24) and 255]
        return res
    }
}

fun main() {
    println(Solution.getTotalSetBits(241))
}
/**

    (n and 255)
    01001010 11100011 00110010 11001010     (n)
    00000000 00000000 00000000 11111111     255
    =========================================
    00000000 00000000 00000000 11001010   =  (202) = counter[202] = 4


    [(n shr 8) and 255]
    00000000 01001010 11100011 00110010     (n shr 8)
    00000000 00000000 00000000 11111111     255
    =========================================
    00000000 00000000 00000000 00110010   = (50) = counter[50] = 3


    [(n shr 16) and 255]
    00000000 00000000 01001010 11100011     (n shr 16)
    00000000 00000000 00000000 11111111     255
  ========================================================
    00000000 00000000 01001010 11100011   =  (227) = counter[227] = 5


     [(n shr 24) and 255]
    00000000 00000000 00000000 01001010     (n shr 24)
    00000000 00000000 00000000 11111111     255
  ========================================
    00000000 00000000 00000000 01001010     = (74)  = counter[74] = 3


    01001010      11100011       00110010      11001010
    counter[74] + counter[227] + counter[50] + counter[202]
             3  +           5  +          5  +           4      = 17

     Total Set bits are: 17
 
     *
 */
