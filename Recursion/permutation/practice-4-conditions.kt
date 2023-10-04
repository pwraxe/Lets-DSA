fun main() {
    val list = mutableListOf<String>()
    doCombinations(StringBuilder("Akshay"),0,list)
    println(list.toTypedArray().contentToString())

    val res1 = list.filter { it[5] == 'y' }.toTypedArray().contentToString()
    println("Total Combinations: ${list.size} || $res1")
}

fun doCombinations(text: StringBuilder, index: Int, output: MutableList<String>) : MutableList<String> {
    if(index == text.length) {
        output.add(text.toString())
        return output
    }

    for (i in index until text.length) {
        text[i] = text[index].also { text[index] = text[i] }
//        if(text[0]!='a' && text[0] != 'A') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[1] != 'A') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[2] != 'k') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[3] != 's') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[4] != 'h') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[5] != 'a') {
//            doCombinations(text, index+1, output)
//        }

//        if(text[5] != 'a') {
//            doCombinations(text, index+1, output)
//        }

        if(text[5] != 'y') {
            doCombinations(text, index+1, output)
        }


        text[i] = text[index].also { text[index] = text[i] }
    }
    return output
}
