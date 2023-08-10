fun main() {
    val list = intArrayOf(1,2,3,4,5,6,7,8,9)
    println(revList(list,0, list.size-1).toTypedArray().contentToString())
}

fun revList(list: IntArray, start:Int, end:Int): IntArray {
  //Base Case  
  if(start > end) return list
  
  //Body
  list[start] = list[end].also { list[end] = list[start]}    
  
  //Tail Recursion
  return revList(list, start+1, end-1)
}
