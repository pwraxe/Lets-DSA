fun main() {
    val combos = mutableListOf<String>()
    doCombination(StringBuilder("ASP"),0,combos)
    println(combos.toTypedArray().contentToString())
}

fun doCombination(text: StringBuilder, index: Int, output: MutableList<String>) {

    //Base Condition
    if(index == text.length) {
        output.add(text.toString())
        return
    }

    for (indx in index until text.length) {
        //Forward Track
        text[indx] = text[index].also { text[index] = text[indx] }
        //Permutation
        doCombination(text, index+1, output)
        //Back Track
        text[indx] = text[index].also { text[index] = text[indx] }
    }
}
