fun main() {
    //XOR
    /**
     * x  |  y  |  x xor y
     * 0  |  0  |  0
     * 0  |  1  |  1
     * 1  |  0  |  1
     * 1  |  1  |  0
     * **/

    //Note 1 : XOR-ing Same Value always returns 0
    println("${1 xor 1}")         // 0
    println("${2 xor 2}")         // 0
    println("${3 xor 3}")         // 0
    println("${48 xor 48}")       // 0
    println("${64 xor 64}")       // 0

    //Note 2: XOR-ing with 0 with any No. is always that No.
    println("${1 xor 0}")       // 1
    println("${0 xor 0}")       // 0
    println("${2 xor 0}")       // 2
    println("${13 xor 0}")      // 13

    //Note 3: XOR-ing with No. with itself which is 2^n is Addition of that No.
    println("${32 xor 32}")       // 0
    println("${32 xor 16}")       // 48
    println("${128 xor 32}")      // 160
    println("${512 xor 128}")     // 640

    //Note 4 : XOR-ing with any no with any no
    println("-- ${24 xor 11}")       // 19
    /**
     * 24 xor 11 = 19, How?
     * Explanation :
     * Take Binary of 24 :  0 0 1 1 0 0 0
     * Take Binary of 11 :  0 0 0 1 0 1 1
     *      XOR Them    ----------------------
     *                      0 0 1 0 0 1 1    ==> After Convert to Decimal : 19
     * **/
}
