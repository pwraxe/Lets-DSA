fun main() {
    /**
     * AND Table
     * x | y | x and y
     * 0 | 0 | 0
     * 0 | 1 | 0
     * 1 | 0 | 0
     * 1 | 1 | 1
     *
     * **/

    /**Anding From Table**/
    val exp01 = 1 and 1      // 1
    val exp02 = 1 and 0      // 0
    val exp03 = 0 and 1      // 0
    val exp04 = 0 and 0      // 0

    //----------------------------------------------------------------------------

    /**Note 1 : Anding of any No. with zero(0) is always zero**/
    val exp11 = 1 and 0      // 0
    val exp12 = 2 and 0      // 0
    val exp13 = 5 and 0      // 0
    val exp14 = 241 and 0    // 0

    //----------------------------------------------------------------------------

    /**Note 2 : Anding with any No. with itself is always same no**/
    val exp21 = 0 and 0      // 0
    val exp22 = 1 and 1      // 1
    val exp23 = 2 and 2      // 2
    val exp24 = 5 and 5      // 5
    val exp25 = 87 and 87    // 87
    /**
     * Explanation :
     * Take Binary value of first  87 ==> 1 0 1 0 1 1 1
     * Take Binary value of second 87 ==> 1 0 1 0 1 1 1
     * Perform anding               --------------------------
     *                                    1 0 1 0 1 1 1   ==> Convert this to Decimal ans is : 87
     * **/

    //----------------------------------------------------------------------------

    /**Note 3 : Anding with any 2^n with any 2^n is always 0**/
    //2^n = 2 pow n (multiplication of 2s with n times)
    //2^4 = 2 pow 4 => 2 x 2 x 2 x 2 => 16

    val exp31 = 2 and 4         // 0  whereas (2 = 2 pow 1) and (4 = 2 pow 2)
    val exp32 = 1 and 2         // 0
    val exp33 = 2 and 1         // 0
    val exp34 = 128 and 64      // 0  whereas (128 = 2 pow 7) and (64 = 2 pow 6)
    /** 128 and 64 = 0 How?
     * Take Binary value of 128 => 1 0 0 0 0 0 0 0
     * Take Binary value of 64  => 0 1 0 0 0 0 0 0
     * Perform anding           --------------------
     *                             0 0 0 0 0 0 0 0  --> if Convert this bin to decimal ans is 0
     * */
    val exp35 = 64 and 128  // 0  //Explanation same as above

    //----------------------------------------------------------------------------

    val exp41 = 3 and 1      // 1
    val exp42 = 6 and 4      // 4
    val exp43 = 77 and 30   // 12
    /**
     * 77 and 30 = 12, How?
     * Binary value of 77    ==>  1 0 0 1 1 0 1
     * Binary value of 30    ==>  0 0 1 1 1 1 0
     * Perform Anding        -----------------------
     *                            0 0 0 1 1 0 0   --> if you convert this binary to decimal , ans is 12
     *
     * **/
    val exp44 = 41 and 67   // 1  //Explanation same as above


}
