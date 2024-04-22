// Akshay, Refer only THIS, 
// https://www.youtube.com/watch?v=D7AFvtnDeMU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=32&ab_channel=AdityaVerma

import kotlin.math.max

class MatrixChainMultiplication {

    //When ask for partition
    //When you feel string, input is given and problem can be devided by two part (like D&C Technique)
    //Then think of MCM
    //Step1: Find index of i, j (i might be >= 1 || j might be <= list.size-1)
    //Step2: Find Base Case
    //Step3: Find K Loop
    //Step4: Function of Get Min/Max / Optimal Value
    private fun solve(i:Int,j:Int, list: IntArray): Int {
        //[Variable] = Base Case, this can be change based on input or problem
        if (i >= j) return 0

        //Create loop for dividing to subprob

        var result = 0

        for (k in i ..< j) {
            //first half part
            val first = solve(i, k, list)

            //second half part
            val second = solve(k+1, j, list)

            //val tempResult = first + second * (expression || +1 || based on input expression)
            val tempResult = first + second

            //Get Min/Max / Optimal Value
            result = max(result, tempResult)
        }
        return result
    }
    fun function(list: IntArray): Int {
        //Make sure to Apply Memorization
        return solve(0,list.lastIndex,list)
    }
}
