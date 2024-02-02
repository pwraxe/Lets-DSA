fun main() {
    //Q1: x or x of any x
    val x = 7
    println(x xor x)

    //Q2. Swap nums without third variable
    var a = 11
    var b = 22
    println("Before Swap: $a | $b")
    a = a xor b
    b = a xor b
    a = a xor b
    println("After Swap : $a | $b")

    //Q3: add 1 to int using BitManip
    val i = 45
    println(-(i.inv()))

    val text = "HELLO THERE"
    text.forEach {
        print((it.code or ' '.code).toChar())
    }
}
