//Sum of 10 nums //ref. from factorial 
fun main() {
    val sum = sumTo(1)
    println("Sum of 10: $sum")
}

//Head Recursion || Bottom-Up Approach
//Going to the End till condition and then execurtes function body
fun sumTo(n: Int) : Int {
    //Base Condition
    if(n == 10) return n
    
    //Funciton call || Head Recusrion
    val res = sum(n+1)
    
    //Function Body
    return n + res
}
