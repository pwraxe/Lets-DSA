fun main() {
    showNumInSequence(5)
    println("\n---------------------")
    showNumsInReverse(5)
}

//Head Recursion
//This goes towords base case and then start print it
//1, 2, 3, 4, 5, 
fun showNumInSequence(n: Int) {
    if(n == 0) return
    showNumInSequence(n-1)
    print("$n, ")    
}


//Tail Recusrion
//This prints first then goes to base case
fun showNumsInReverse(n: Int) {
    if(n == 0) return 
    print("$n, ")
    showNumsInReverse(n-1)
}
