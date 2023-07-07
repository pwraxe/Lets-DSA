class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        
        var n = arr.size
        var i = 0

        //Climb Up
        while(i+1 < n && arr[i] < arr[i+1]) i++

        //Check if i at end or start
        if(i == 0 || i==n-1) return false

        //Climb down
        while(i+1 < n && arr[i] > arr[i+1]) i++

        //if i reach last index then return true 
        return i == n-1
    }
}
 
