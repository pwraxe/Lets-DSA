/*
* LOGIC Behind LIS
*
*   - When you received IntArray list
*   - Add all elements in HashSet<Int>, hashSet will store unique element
*   - now you have two list same as two string in LCS
*   - Perform same LCS on Array of Int thats it
* */
class LIS {
    private fun lcsMemo(i:Int, j:Int, nums1: IntArray, nums2: HashSet<Int>, dp: Array<IntArray>): Int {
        if (i == nums1.size || j == nums2.size) return 0
        if (dp[i][j] != -1) return dp[i][j]


        if (nums1[i] == nums2.elementAt(j)) {
           dp[i][j] = 1 + lcsMemo(i+1, j+1, nums1, nums2, dp)
        } else {
            dp[i][j] = Math.max(
                lcsMemo(i+1, j, nums1, nums2, dp),
                lcsMemo(i, j+1, nums1, nums2, dp)
            )
        }
        return dp[i][j]
    }
    fun longestIncSubSeqMemo(list: IntArray): Int {

        //HashSet stores unique element also sort them out
        val hashSet = hashSetOf<Int>().also {
            for (item in list) {
                it.add(item)
            }
        }

        val dp = Array(list.size+1) { IntArray(hashSet.size+1) { -1 } }

        val res = lcsMemo(0,0,list,hashSet,dp)
        println("res = $res | ${dp[0][0]}")

        return dp[0][0]
    }


    fun longestIncSubSeqTabu(list: IntArray): Int {
        val hashSet = hashSetOf<Int>().also {set ->
            list.forEach {
                set.add(it)
            }
        }
        val dp = Array(list.size+1) { IntArray(hashSet.size+1) }
        for (i in 1 .. list.size) {
            for (j in 1 .. hashSet.size) {
                if (list[i-1] == hashSet.elementAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
                }
            }
        }


        //This giving you wrong answer| WRONG, Becoz HashSet does not maintain order
        val seq = mutableListOf<Int>()
        var i = list.size
        var j = hashSet.size
        while (i > 0 && j > 0) {
            if (list[i-1] == hashSet.elementAt(j-1)) {
                seq.add(0,list[i-1])
                i--
                j--
            } else {
                if (dp[i-1][j] > dp[i][j-1]) i-- else j--
            }
        }
        println(seq.toTypedArray().contentToString())
        return dp[list.size][hashSet.size]

    }
}
fun main() {
    LIS().apply {
        val list = intArrayOf(8,4,9,7,2,0,5,3,6)
        val list2 = intArrayOf(50,3,10,7,40,80)
        println(longestIncSubSeqMemo(list))
        println(longestIncSubSeqMemo(list2))

        println("---------------------------------")
        println(longestIncSubSeqTabu(list))
        println(longestIncSubSeqTabu(list2))
    }
}

//8, 4, 9, 7, 2, 0, 5, 3, 6  || Original List
//0, 2, 3, 4, 5, 6, 7, 8, 9  || hashSet




res = 3 | 3
3
res = 4 | 4
4
---------------------------------
[0, 3, 6]
3
[50, 3, 7, 40]
4
