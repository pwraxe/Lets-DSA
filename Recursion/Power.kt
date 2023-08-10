fun main() {
    println(power(2,3))
}

fun power(num:Int, pow: Int): Int {
  //Base Case
  if(pow == 0) return 1 
  
  //Body * Function call
  return num * power(num, pow-1)
}
