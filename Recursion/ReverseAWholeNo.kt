fun main() {
  println(doReverse(1234,0))
}

fun doReverse(num:Int, ans:Int):Int {
  if(num == 0) return ans
  return doReverse(num/10, ans*10+num%10)
}

//-------------------------------------------------


fun main() {
    println(revInt(1234,0))
}

fun revInt(x:Int, ans:Int):Int {
    if(x == 0) return ans
    val nextSmall = x/10
    val lastDigit = x % 10
    return revInt(nextSmall, ans*10+lastDigit)
    
}
