//subset-practice-1.1.kt extends subset-practice-1.kt
//Followup - list should have different length lists,

fun main() {
    val list = mutableListOf<List<String>>()
    getSubSet("AKSHAY", mutableListOf(), list)
    list.sortBy { it.size }
    list.forEach {
        println("${it.size} | ${it.toTypedArray().contentToString()}")
    }
}

fun getSubSet(text: String, subList: MutableList<String>, list: MutableList<List<String>>, index: Int = 0) {
    if(index == text.length) {
        if(list.isNotEmpty()) {
            val hasSameLength = list.any { it.size == subList.size }
            if(!hasSameLength) list.add(subList.toList())
        } else {
            list.add(subList.toList())
        }
        return
    }

    //take item

    subList.add(text[index].toString())
    getSubSet(text, subList, list,index+1)

    //!take item
    subList.removeLast()
    getSubSet(text, subList, list, index+1,)
}



//OUTPUT
0 | []
1 | [A]
2 | [A, K]
3 | [A, K, S]
4 | [A, K, S, H]
5 | [A, K, S, H, A]
6 | [A, K, S, H, A, Y]
