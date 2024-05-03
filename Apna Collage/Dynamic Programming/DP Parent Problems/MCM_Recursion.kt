/*
LOGIC THEROTICALLY
If you given an array and ask fot MCM
then create list of pairs of (row x col)
and devide pair by brackets
and solved all one by one

arr = [1,2,3,4,5]
A[i] = (r x c)
A = (1 x 2),  B = (2 x 3),  C = (3 x 4), D = (4 x 5)

possible groups are
[(A.B).C].D   --> 38  <--- RESULT
(A.B)(C.D)    --> 81
[A.(B.C)].D   --> 52
A[(B.C).D]    --> 74
A[B.(C.D)]    --> 100


*/
class MatrixChainMultiplication {

    private fun mcm(i:Int, j:Int, list: IntArray) : Int {
        if (i == j) return 0

        var result = Int.MAX_VALUE
        for (k in i..< j) {
            val cost1 = mcm(i, k, list)       //(a x b) ==> (list[i-1] x list[k])
            val cost2 = mcm(k+1, j, list)     //(c x d) ==> (list[k] x list[j])
                                              // list[i-1] to list[j] --> i.e. list[0] to list[size]

            val cost3 = list[i-1] * list[k] * list[j] /* a x (b || c) x d */
            val finalCost = cost1 + cost2 + cost3
            result = Math.min(result, finalCost)
        }
        return result
    }
    fun matrixChainMult(list: IntArray) {
        println(mcm(1,list.size-1, list))
    }
}

fun main() {
    MatrixChainMultiplication().apply {
        matrixChainMult(list = intArrayOf(1,2,3,4,3))
        matrixChainMult(list = intArrayOf(1,2,3,4,5))
    }
}
