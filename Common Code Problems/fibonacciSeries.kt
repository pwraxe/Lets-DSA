//Problem: Print Fibonnasi Series
fun main() {
    fibonassi(10)
}

fun fibonassi(till: Int) {
    val list = mutableListOf<Int>()
    
    list.add(0) //0
    list.add(1) //1
    
    for(num in 0..till) {
        val next = list[list.size-1] + list[list.size-2]
        list.add(next)
    }
    
    println(list.toTypedArray().contentToString())
}

//================================================================

//Problem: Print Fibonnasi Series using Recursion
fun main() {
    
    repeat(10) {
    	print("${fibonassi(it)}, ")    
    }
}

fun fibonassi(num: Int) : Int {
   	if(num <= 1) return num
    return fibonassi(num-1) + fibonassi(num-2)
}
