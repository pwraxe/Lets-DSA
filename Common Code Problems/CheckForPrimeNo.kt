//Problem: Check Given no is Prime no or not
//What is Prime no? --> A no. can devide by either 1 or by itself

fun main() {
    println("isPrime : ${checkForPrimeNo(71)}")
}

fun checkForPrimeNo(num:Int) : Boolean {
    if(num == 0 || num == 1) return false
    if(num == 2) return true
    
    //Step 1: Devide No by half
    //Step 2: take a loop from 2 to num/2
    //Step 3: check num % (number under loop) == 0 
    //if you got any no which fully devids then its not prime and useless to go next so return false
    for(i in 2 .. num/2) {
        if(num % i == 0) return false
    }
    
    return true
}
