fun main() {
    val list = mutableListOf<String>()
    doCombinations(StringBuilder("AKSHAY"),0,list)
    println("No. of Combinations : ${list.size}")
    println(list.toTypedArray().contentToString())
}

fun doCombinations(text: StringBuilder, index:Int, ans : MutableList<String>) {

    if(index == text.length) {
        ans.add(text.toString())
        return
    }

    for(i in index until text.length) {
        text[i] = text[index].also { text[index] = text[i] }


        //Applying Condition, Only take that combination, which starts from 'Y'
        // 0th Index character == 'Y'
        if(text[0] == 'Y') {
            doCombinations(text, index+1, ans)
        }
        text[i] = text[index].also { text[index] = text[i] }
    }
}
