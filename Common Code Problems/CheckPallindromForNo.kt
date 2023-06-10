//Program: Check No is Pallindrom or not
fun main() {
    
    val input = 1221
	  println(isPallindrom(input))
    
}

fun isPallindrom(input: Int) : Boolean {
    
    var num = input
    var reverse = 0
	
    while(num != 0) {
        var digits = num % 10
		reverse = reverse * 10 + digits
		num /= 10 
    }
    
    return reverse == input
    
}
