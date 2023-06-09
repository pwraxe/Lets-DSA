//Program: Multiplication of table
fun main() {
    table(29)
}

fun table(num: Int) {
    
    for(i in 1 .. 10) {
        println("$num x $i = ${num*i}")
    }
}
