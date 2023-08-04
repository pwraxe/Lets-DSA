fun main() {
	  headCall(0) 		//9 8 7 6 5 4 3 2 1 0
    println("\n")
    tailCall(10) 		//10 9 8 7 6 5 4 3 2 1
}



//1: HEAD RECURSION
//=====================

//Call Function First then Body
//head = first = function calls at first
//Base Condition --> Function Call --> Function Body
fun headCall(n: Int) {
    //Section 1: Base Condition
    if(n == 10) return
    
    //Section 2: First Function Call
    headCall(n+1)
    
    //Section 3: Body of function
    print("$n ")
}


//2: TAIL RECURSION
//=====================
//Excecute Function Body First, then Call Function
//tail = last = function calls at last
//Base Condition --> Function Body --> Function Call
fun tailCall(n: Int) {
    //Base Confition
    if(n == 0) return
    
    //Function Body
    print("$n ")
    
    //Function Call
    tailCall(n-1)
}
