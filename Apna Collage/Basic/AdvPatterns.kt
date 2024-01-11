class Solution {

    fun numberPattern(n:Int) {
        (n downTo 1).forEach {n ->
            (1..n).forEach {
                print("$it ")
            }
            println()
        }
    }

    fun floydsTriangle(rows:Int) {
        var count = 1
        for (row in 1.. rows) {
            for (col in 1 .. row) {
                print("${count++} ")
            }
            println()
        }
    }

    fun zeroOneTriangle(rows: Int) {

        (1..rows).forEach { row ->
            repeat(row) {col ->
                if ((row + col) % 2 == 0) {
                    print("1 ")
                } else {
                    print("0 ")
                }
            }
            println()
        }
    }

    fun butterfly(row:Int, col: Int = row) {
        var star = 1
        var space = (row * 2) - 2
        for (r in 1 .. row) {
            repeat(star) {
                print("* ")
            }
            repeat(space) {
                print("  ")
            }
            repeat(star) {
                print(" *")
            }
            star++
            space -= 2
            println()
        }

        space = 0
        star -= 1
        (star downTo 1).forEach {

            //star
            if(it != row) {
                repeat(it) {
                    print("* ")
                }
            }

            //space
            repeat(space) {
                print("  ")
            }

            //star
            if(it != row) {
                repeat(it) {
                    print(" *")
                }
            }
            space += 2
            if (it != row) println()
        }
    }

    fun solidRhombus(rows: Int) {
        (rows-1 downTo 0).forEach {
            repeat(it) {
                print("  ")
            }
            repeat(rows) {
                print("* ")
            }
            println()
        }
    }

    fun hollowRhombus(rows: Int, col: Int) {
        (0 .. rows).forEach { r ->
            repeat(rows-r) {
                print(" ")
            }
            (0 .. col).forEach { c ->

                if (c == 0 || r == 0 || c == col || r == rows) {
                    print("* ")
                } else print("  ")
            }
            println()
        }
    }

    fun diamondPattern(rows: Int) {
        var star = 1
        (1 .. rows).forEach { r ->
            repeat(rows - r) {
                print("  ")
            }
            repeat(star) {
                print("* ")
            }
            println()
            star += 2
        }

        star -= 2
        var space = 0
        (rows-1 downTo 0).forEach {
            if (it != rows-1) {
                repeat(space) {
                    print("  ")
                }
                repeat(star) {
                    print("* ")
                }
                println()
            }
            star -= 2
            space++
        }
    }
}
fun main() {
    Solution().apply {
        numberPattern(5)
        println("=================")

        floydsTriangle(5)
        println("=================")

        zeroOneTriangle(5)
        println("=================")

        butterfly(5)
        println("=================")

        solidRhombus(5)
        println("=================")

        hollowRhombus(8,5)

        println("=================")
        diamondPattern(5)
    }
}

//-------------------------------------------------------------------------------O/P

1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 
=================
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
=================
0 
1 0 
0 1 0 
1 0 1 0 
0 1 0 1 0 
=================
*                  *
* *              * *
* * *          * * *
* * * *      * * * *
* * * * *  * * * * *
* * * *      * * * *
* * *          * * *
* *              * *
*                  *
=================
        * * * * * 
      * * * * * 
    * * * * * 
  * * * * * 
* * * * * 
=================
        * * * * * * 
       *         * 
      *         * 
     *         * 
    *         * 
   *         * 
  *         * 
 *         * 
* * * * * * 
=================
        * 
      * * * 
    * * * * * 
  * * * * * * * 
* * * * * * * * * 
  * * * * * * * 
    * * * * * 
      * * * 
        * 



