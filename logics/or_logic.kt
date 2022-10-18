fun main() {
    /**
     * OR Table
     * x | y | x and y
     * 0 | 0 | 0
     * 0 | 1 | 1
     * 1 | 0 | 1
     * 1 | 1 | 1
     * **/

    /**OR-ing From Table**/
    val exp01 = 1 or 1      // 1
    val exp02 = 1 or 0      // 1
    val exp03 = 0 or 1      // 1
    val exp04 = 0 or 0      // 0

    //----------------------------------------------------------------------------

    /**Note 1 : OR-ing of any No. with zero(0) is always that no**/
    val exp11 = 1 or 0      // 1
    val exp12 = 2 or 0      // 2
    val exp13 = 5 or 0      // 5
    val exp14 = 241 or 0    // 241

    //----------------------------------------------------------------------------

    /**Note 2 : OR-ing with any No. with itself is always same no**/
    val exp21 = 0 or 0      // 0
    val exp22 = 1 or 1      // 1
    val exp23 = 2 or 2      // 2
    val exp24 = 5 or 5      // 5
    val exp25 = 87 or 87    // 87
    val exp26 = 64 or 64    // 64


    /**Note 3 : OR-ing with any 2^n with any 2^n is always addition of number**/
    //2^n = 2 pow n (multiplication of 2s with n times)
    //2^4 = 2 pow 4 => 2 x 2 x 2 x 2 => 16

    val exp31 = 2 or 4      // 6
    val exp32 = 1 or 2      // 3
    val exp33 = 16 or 8     // 24
    val exp34 = 128 or 64   // 192
    val exp35 = 128 or 256  // 384
    /**
     * Explanation :
     * Take Binary of 128 =>  0 1 0 0 0 0 0 0 0
     * Take Binary of 256 =>  1 0 0 0 0 0 0 0 0
     *                  --------------------------
     *                        1 1 0 0 0 0 0 0 0    ==> Convert it into decimal ans is : 384
     * **/

    //----------------------------------------------------------------------------
    /**Note 4 : OR-ing of any no with any no **/

    val exp41 = 3 or 1     // 3
    val exp42 = 6 or 4     // 6
    val exp43 = 77 or 30   // 95

    /**
     * 77 and 30 = 95, How?
     * Binary value of 77    ==>  0 1 0 0 1 1 1 1
     * Binary value of 30    ==>  0 0 0 1 1 1 1 0
     * Perform Anding        -----------------------
     *                            0 1 0 1 1 1 1 1 ---> if you convert this binary to decimal , ans is 95
     * **/

    val exp44 = 55 or 88    // 127 //Explanation same as above
    val exp45 = 71 or 11    // 79  //Explanation same as above

}
