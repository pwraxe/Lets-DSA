/**
 * Create a Matrix for
 *  - Boolean
 *  - Char
 *  - String
 *  - Int
 *  - Double
 *
 * **/

fun main() {

    /**
     * | false      false       false |
     * | false      false       false |
     * | false      false       false |
     * **/
    val twoDBoolean = Array(3) { BooleanArray(3){ false } }


    /**
     * | #  #   # |
     * | #  #   # |
     * | #  #   # |
     * **/
    val twoDChar = Array(3) { CharArray(3) { '#' } }


    /***
     * | null   null    null |
     * | null   null    null |
     * | null   null    null |
     * */
    val twoDString = Array(3) { Array<String?> (3) { null } }

    /**
     * | 0   0   0 |
     * | 0   0   0 |
     * | 0   0   0 |
     * **/
    val twoDInt = Array(3) {  IntArray(3) { 0 } }


    /**
     * | 0.0   0.0   0.0 |
     * | 0.0   0.0   0.0 |
     * | 0.0   0.0   0.0 |
     * **/
    val twoDDouble= Array(3) { DoubleArray(3) { 0.0 } }
}

