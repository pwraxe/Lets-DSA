/*
* LOGIC
*   - Received single IntArray
*   - save all elements in hashSet to get a unique element
*   - paste hashSet element in new list2 of IntArray and Sort list2
*   - send list1, and list2 for LIS (intuition same as LIS in String)
* */
class LIS {
    private fun lcsMemo(i:Int, j:Int, nums1: IntArray, nums2: IntArray, dp: Array<IntArray>): Int {
        if (i == nums1.size || j == nums2.size) return 0
        if (dp[i][j] != -1) return dp[i][j]


        if (nums1[i] == nums2[j]) {
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

        //HashSet stores unique element
        val hashSet = hashSetOf<Int>().also {
            for (item in list) {
                it.add(item)
            }
        }
        //Store all elements in list2 and Sort
        val list2 = IntArray(hashSet.size)
        for (i in hashSet.indices) {
            list2[i] = hashSet.elementAt(i)
        }
        list2.sort()


        val dp = Array(list.size+1) { IntArray(hashSet.size+1) { -1 } }
        val res = lcsMemo(0,0,list,list2,dp)
        println("res = $res | ${dp[0][0]}")

        return dp[0][0]
    }

    fun longestIncSubSeqTabu(list1: IntArray): Int {

        //Get unique element from list1 by storing in hashSet
        val hashSet = hashSetOf<Int>().also {set ->
            list1.forEach {
                set.add(it)
            }
        }
        //Save all hashSet element in list2 and sort it
        val list2 = IntArray(list1.size)
        for (i in hashSet.indices) {
            list2[i] = hashSet.elementAt(i)
        }
        list2.sort()

        val dp = Array(list1.size+1) { IntArray(list2.size+1) }

        for (i in 1 .. list1.size) {
            for (j in 1 .. list2.size) {
                if (list1[i-1] == list2.elementAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
                }
            }
        }

        val seq = mutableListOf<Int>()
        var i = list1.size
        var j = list2.size
        while (i > 0 && j > 0) {
            if (list1[i-1] == list2.elementAt(j-1)) {
                seq.add(0,list1[i-1])
                i--
                j--
            } else {
                if (dp[i-1][j] > dp[i][j-1]) i-- else j--
            }
        }
        println(seq.toTypedArray().contentToString())
        return dp[list1.size][hashSet.size]
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
[3, 7, 40, 80]
4
