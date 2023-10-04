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
        list.add(subList.toList())
        return
    }

    //take item
    subList.add(text[index].toString())
    getSubSet(text, subList, list,index+1)

    //!take item
    subList.removeLast()
    getSubSet(text, subList, list, index+1,)
} 
