class Patterns {

    fun hollowRectanglePattern(n:Int) {
        println("Hollow Rectangle")
        for (i in 0.. n) {
            for (j in 0 .. n) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    print("* ")
                } else {
                    print("  ")
                }
            }
            println()
        }
    }
    fun invertedHalfPyramidPattern(n:Int) {
        print("inverted Half Pyramid")
        repeat(n) {
            repeat(n-it) {
                print("  ")
            }

            repeat(it) {
                print("* ")
            }
            println()
        }
    }
    fun floydTrianglePattern(n: Int) {
        print("Floyd's Triangle")
        var count = 1
        repeat(n) {
            repeat(it) {
                print("$count ")
                count++
            }
            println()
        }
    }
    fun zeroOneTrianglePattern(n:Int) {
        print("zero One Triangle Pattern")
        repeat(n) { i ->
            repeat(i) { j ->
                if ((i+j) % 2 == 1) {
                    print("1 ")
                } else {
                    print("0 ")
                }
            }
            println()
        }
    }
    fun butterflyPattern(n:Int) {
        println("Butterfly Pattern")
        for (i in 0 ..< n/2) {
            val stars = (i+1)
            val space = n - (stars*2)
            repeat(stars){
                print("* ")
            }
            repeat(space) {
                print("  ")
            }
            repeat(stars){
                print(" *")
            }
            println()
        }

        for (i in n/2 downTo 0) {
            val space = n - (i * 2)
            repeat(i) {
                print("* ")
            }
            repeat(space) {
                print("  ")
            }
            repeat(i){
                print(" *")
            }
            println()
        }
    }
    fun solidRhombusPattern(n:Int) {
        println("solid Rhombus Pattern")
        for (i in n downTo 0) {
            repeat(i) {
                print("  ")
            }
            repeat(n) {
                print("* ")
            }
            println()
        }
    }
    fun hollowRhombusPattern(n:Int) {
        println("hollow Rhombus Pattern")
        for (i in 0 .. n) {
            repeat(n - i) {
                print("  ")
            }
            for (j in 0 .. n) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    print("* ")
                } else {
                    print("  ")
                }
            }
            println()
        }
    }
    fun diamondPattern(n: Int) {
        println("Diamond Pattern")
        for (i in 0 .. n) {
            if (i % 2 == 1) {
                repeat(n-i) {
                    print(" ")
                }
                repeat(i) {
                    print("* ")
                }
                println()
            }
        }

        //apply n-1 if you need
        for (i in n downTo 0) {
            if (i%2 == 1) {
                repeat(n-i) {
                    print(" ")
                }
                repeat(i) {
                    print("* ")
                }
                println()
            }
        }
    }
}

fun main() {
    Patterns().apply {
        hollowRectanglePattern(4)
        println("===============================")
        invertedHalfPyramidPattern(5)
        println("===============================")
        floydTrianglePattern(6)
        println("===============================")
        zeroOneTrianglePattern(6)
        println("===============================")
        butterflyPattern(8)
        println("===============================")
        solidRhombusPattern(5)
        println("===============================")
        hollowRhombusPattern(5)
        println("===============================")
        diamondPattern(7)
    }
}



//==============================================================================OUTPUT=================
Hollow Rectangle
* * * * * 
*       * 
*       * 
*       * 
* * * * * 
===============================
inverted Half Pyramid          
        * 
      * * 
    * * * 
  * * * * 
===============================
Floyd's Triangle
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
===============================
zero One Triangle Pattern
1 
0 1 
1 0 1 
0 1 0 1 
1 0 1 0 1 
===============================
Butterfly Pattern
*              *
* *          * *
* * *      * * *
* * * *  * * * *
* * * *  * * * *
* * *      * * *
* *          * *
*              *
                
===============================
solid Rhombus Pattern
          * * * * * 
        * * * * * 
      * * * * * 
    * * * * * 
  * * * * * 
* * * * * 
===============================
hollow Rhombus Pattern
          * * * * * * 
        *         * 
      *         * 
    *         * 
  *         * 
* * * * * * 
===============================
Diamond Pattern
      * 
    * * * 
  * * * * * 
* * * * * * * 
* * * * * * * 
  * * * * * 
    * * * 
      * 
