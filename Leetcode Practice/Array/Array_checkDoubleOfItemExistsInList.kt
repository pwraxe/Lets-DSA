class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        var list = mutableListOf<Int>()
        for(i in 0 until arr.size) {
            val item = arr[i]
            //double item, check for avaiable || (check for even item && check for half item)
           if(list.contains(item * 2) || (item % 2 == 0 && list.contains(item/2))) {
                return true
            }
           //you can use set insted of list for duplicacy
            list.add(item)
        }
        return false
    }
}
