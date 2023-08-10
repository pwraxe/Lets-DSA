fun main() {
    val list = intArrayOf(1,2,3,4,5,6,7,8,9)
    val index = doBinSearch(list, 0, list.size-1, 8)
    println(index)
}

fun doBinSearch(list:IntArray, start: Int, end:Int,target:Int) : Int {
    //Base Case
    if(start > end) return -1

    //Calculate Mid Index
    val mid = (start + end) / 2

    //return index if value found
    if(list[mid] == target) return mid

    //***YOU WERE FORGOT, return statement when if true, thats why always returning last statement of this code i.e. 'return -1'
    //if this condition satisfed then return with recursive call, it will take care your failure at base case if not found
    if(target > list[mid]) return doBinSearch(list, mid+1, end, target)

    //***YOU WERE FORGOT, return statement when if true, thats why always returning last statement of this code i.e. 'return -1'
    //if this condition satisfed then return with recursive call, it will take care your failure at base case if not found
    if(target < list[mid]) return doBinSearch(list, start, mid-1, target)
    
    return -1
}

 
