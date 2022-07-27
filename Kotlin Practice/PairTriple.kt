
//Pair<T,T>
fun main() {
    val pair = Pair(1,"Google")
    println(pair)               // (1, Google)
    println(pair.toString())    // (1, Google)

    val array = arrayListOf<Pair<Int,String>>()

    repeat(3) {
        array.add(Pair(it*it,"Googler"))
    }

    println(array)              // [(0, Googler), (1, Googler), (4, Googler)]
    println(array.toString())   // [(0, Googler), (1, Googler), (4, Googler)]
}
=============================================================================

//Triple<T,T,T>
fun main() {

    //tripleI = triple of Int
    val tripleI = Triple<Int,Int,Int>(15,20,24)
    println("First : ${tripleI.first}")         // 15
    println("Second : ${tripleI.second}")       // 20
    println("Third : ${tripleI.third}")         // 24

    //tripleT = triple of <T> any type
    val tripleT = Triple(15,"String",3.145)    
    println("First : ${tripleT.first}")         // 15
    println("Second : ${tripleT.second}")       // String
    println("Third : ${tripleT.third}")         // 3.14
}
