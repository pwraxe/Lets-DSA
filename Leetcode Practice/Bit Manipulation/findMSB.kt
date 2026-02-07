fun main() {

    val num = 1258
    println(num.toString(2)) //10011101010
    
    var res = 0
    for (i in 1 .. 31) {
        val mask = (1 shl i)
        if (num and mask > 0) res = mask
    }
    println(res)  //1024
}
