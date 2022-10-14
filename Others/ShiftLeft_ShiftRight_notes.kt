fun main() {

    //----- shl (shiftLeft)---------

    val size1 = 1 shl 1         //Answer : 2
    /**
     * Explanation :
     * 1 shl 1  --> i.e (1 x 1 times 2's multiplication)
     * 1 x (2) = 2
     * **/


    val size2 = 2 shl 3         //Answer : 16
    /**
     * Explanation :
     * 2 shl 3  --> i.e (2 x 3 times 2's multiplication)
     * 2 x (2 x 2 x 2) = 2 x (8) = 16
     * **/

    val size3 = 3 shl 3         //Answer : 24
    /**
     * Explanation :
     * 3 shl 3 --> i.e. (3 x 3 times 2's multiplication)
     * 3 x (2 x 2 x 2) = 3 x (8) = 24
     * **/
    println("$size1 | $size2 | $size3")

    //************************************************************
    //----- shr (shiftRight)---------

    val size4 = 100 shr 1         //Answer : 50
    /**
     * Explanation :
     * 100 shr 1 --> i.e. (100 / 1 times 2's multiplication)
     * 100 / (2) -> 50
     * **/

    val size5 = 100 shr 2         //Answer : 25
    /**
     * Explanation : 
     * 100 shr 2 --> i.e. (100 / 2 times 2's multiplication) 
     * 100 / (2 x 2) -> 100 / 4 = 25
     * 
     * **/
    
    val size6 = 100 shr 3       //Answer : 12
    /**
     * Explanation : 
     * 100 shr 3 --> i.e. (100 / 3 times 2's multiplication)
     * 100 / (2 x 2 x 2 ) = 100 / 8 = 12
     * **/
    
    val size7 = 100 shr 4       //Answer : 6
    /**
     * Explanation : 
     * 100 shr 4 --> i.e. (100 / 4 times 2's multiplication)
     * 100 / (2 x 2 x 2 x 2) = 100 / 16 = 6
     * **/
    println("$size4 || $size5 || $size6 || $size7")


}
