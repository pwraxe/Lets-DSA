//Leetcode: 1672. Richest Customer Wealth
//TC: O(nxm) , n = rows, m : colmn
//SC: O(1), no extra space using 

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var sum = 0
        accounts.forEach {
            val total = it.sum()
            if(total > sum) sum = total
        }
        return sum
    }
}

//-----------------------------------------------------------------
//Leetcode: 1672. Richest Customer Wealth
//TC: O(nxm) , n = rows, m : colmn
//SC: O(1), no extra space using 

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.map{ it.sum() }.max() ?: 0
    }
}

//-----------------------------------------------------------------
//Leetcode: 1672. Richest Customer Wealth
//TC: O(nxm) , n = rows, m : colmn
//SC: O(1), no extra space using 

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var sum = 0
        accounts.forEach {
            val total = getSum(it)
            if(total > sum) sum = total
        }
        return sum
    }
    
    fun getSum(list: IntArray) : Int {
        var sum = 0
        list.forEach { 
            sum += it
        }
        return sum
    }
}
