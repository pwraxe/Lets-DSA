//Leetcode: 77. Combinations

class Solution {
    
    val combos = mutableListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        if(n == 1) return listOf(listOf(1))
    
        doCombine(1,n, k, mutableListOf<Int>())

        return combos
    }

    private fun doCombine(start: Int, n:Int, k: Int, list: MutableList<Int>) {
        if(list.size == k) {
            combos.add(list.toList())
            return
        }

        (start..n).forEach {
            list.add(it)
            doCombine(it+1, n,k, list)
            list.removeAt(list.size-1)
        }
    }
}
