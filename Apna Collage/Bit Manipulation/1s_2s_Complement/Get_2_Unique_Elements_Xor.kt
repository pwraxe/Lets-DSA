internal object Solution {
     fun twoUniqueOccurring(list:IntArray) {
         var x = list.first()
         for (num in list) {
             x = x xor num
         }
         
         //LSB
         val k = (x and (x-1).inv())
         var res1 = 0
         var res2 = 0
         for (i in list.indices) {
             
             if (k and list[i] > 0) {
                 res1 = res1 xor list[i]
             }
             else {
                 res2 = res2 xor list[i]
             }
         }
         println("$res1, $res2")   //5, 2
     }
}

fun main() {
    println(Solution.twoUniqueOccurring(intArrayOf(3,6,5,6,3,2)))
}
