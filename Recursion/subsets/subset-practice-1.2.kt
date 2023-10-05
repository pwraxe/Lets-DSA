fun main() {
    val list = mutableListOf<String>()
    getSubList("ASP","",0,list)
    println(list.toTypedArray().contentToString())
}

fun getSubList(text: String, output: String, index :Int, list: MutableList<String>) {
    if(index == text.length) {
        if(output.isNotEmpty()) list.add(output)
        return
    }

    //Take
    getSubList(text, output+text[index], index+1,list)
    
    //Not Take
    getSubList(text, output, index+1,list)
}
