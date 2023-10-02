fun main() {
    val list = mutableListOf<String>()
    doCombinations(StringBuilder("MTF"),0,list)
    println("No. of Combinations : ${list.size}")
    println(list.toTypedArray().contentToString())
}

fun doCombinations(text: StringBuilder, index:Int, ans : MutableList<String>) {

    if(index == text.length) {
        ans.add(text.toString())
        return
    }

    for(i in index until text.length) {

//        Case 1: Take All Combinations
//        [MTF, MFT, TMF, TFM, FTM, FMT]
//        text[i] = text[index].also { text[index] = text[i] }
//        doCombinations(text, index+1, ans)
//        text[i] = text[index].also { text[index] = text[i] }


//        Case 2: Applying Condition, [0] != 'M'
//        [TMF, TFM, FTM, FMT]
//        text[i] = text[index].also { text[index] = text[i] }
//        if (text[0] != 'M') {
//            doCombinations(text, index+1, ans)
//            text[i] = text[index].also { text[index] = text[i] }
//        }

        //Case 3: Applying Condition, [1] != 'T'
        //[TMF, TFM]
        text[i] = text[index].also { text[index] = text[i] }
        if(text[1] != 'T') {
            doCombinations(text, index+1, ans)
            text[i] = text[index].also { text[index] = text[i] }
        }
    }
}
