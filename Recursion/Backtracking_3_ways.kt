//Permutation
fun main() {
    val list = mutableListOf<String>()
    permutation(StringBuilder("ASP"),0, list)
    println(list.toTypedArray().contentToString())
}

fun permutation(text: StringBuilder,index:Int,
                list: MutableList<String>) {
    if(index == text.length) {
        list.add(text.toString())
        return
    }

    for (i in index until text.length) {
        text[i] = text[index].also { text[index] = text[i] }

        //OUTPUT : [ASP, APS, SAP, SPA, PSA, PAS]
        permutation(text, index+1, list)

        //OR 
        //OUTPUT : [ASP, APS, SAP, PSA]   
        permutation(text, i+1, list)
        text[i] = text[index].also { text[index] = text[i] }
    }

  //OR ------------------------------------------------------------------
     for (i in text.length-1 downTo 0) {
        text[i] = text[index].also { text[index] = text[i] }
        permutation(text, index+1, list)
        text[i] = text[index].also { text[index] = text[i] }
     }
     
     //if you write this code in main() then output will be
      list.groupBy { it }.forEach {
        println("${it.key} = ${it.value.toTypedArray().contentToString()}")
      }
      //OUTPUT
      // PAS = [PAS, PAS, PAS, PAS]
      // PSA = [PSA, PSA, PSA, PSA]
      // SAP = [SAP, SAP, SAP, SAP, SAP]
      // ASP = [ASP, ASP, ASP, ASP]
      // SPA = [SPA, SPA, SPA, SPA, SPA]
      // APS = [APS, APS, APS, APS, APS]    
}

//=================================================================================================
//TAKE NOT TAKE
//Take not take with loop

fun main() {
    val list = mutableListOf<List<String>>()
    takeNotTakeWithLoop(StringBuilder("ASP"),0, mutableListOf(),list)
    list.forEach {
        println("${it.size} | ${it.toTypedArray().contentToString()}")
    }
}

fun takeNotTakeWithLoop(text: StringBuilder,index:Int,
                subList: MutableList<String>,list: MutableList<List<String>>) {

    if(index == text.length) {
        list.add(subList.toList())
        return
    }

    for (i in index until text.length) {
        subList.add(text[i].toString())
        
        takeNotTakeWithLoop(text, index+1, subList, list)
        //OUTPUT
        // 3 | [A, S, P]
        // 3 | [A, P, P]
        // 3 | [S, S, P]
        // 3 | [S, P, P]
        // 3 | [P, S, P]
        // 3 | [P, P, P]

        //OR
        takeNotTakeWithLoop(text, i+1, subList, list)
        //OUTPUT
        // 3 | [A, S, P]
        // 2 | [A, P]
        // 2 | [S, P]
        // 1 | [P]
        
        subList.removeLast()
    }


    //OR if you change above loop to downTo 0

     for (i in text.length-1 downTo 0) {
        subList.add(text[i].toString())
        
        takeNotTakeWithLoop(text, index+1, subList, list)
        //OUTPUT
        // 3 | [P, P, P]
        // 3 | [P, P, S]
        // 3 | [P, P, A]
        // 3 | [P, S, P]
        // 3 | [P, S, S]
        // 3 | [P, S, A]
        // 3 | [P, A, P]
        // 3 | [P, A, S]
        // 3 | [P, A, A]
        // 3 | [S, P, P]
        // 3 | [S, P, S]
        // 3 | [S, P, A]
        // 3 | [S, S, P]
        // 3 | [S, S, S]
        // 3 | [S, S, A]
        // 3 | [S, A, P]
        // 3 | [S, A, S]
        // 3 | [S, A, A]
        // 3 | [A, P, P]
        // 3 | [A, P, S]
        // 3 | [A, P, A]
        // 3 | [A, S, P]
        // 3 | [A, S, S]
        // 3 | [A, S, A]
        // 3 | [A, A, P]
        // 3 | [A, A, S]
        // 3 | [A, A, A]
        
        subList.removeLast()
    }
}


//=================================================================================================
//TAKE NOT TAKE
//Take not take without loop
fun main() {
    val list = mutableListOf<List<String>>()
    takeNotTakeWithLoop(StringBuilder("ASP"),0, mutableListOf(),list)
    list.forEach {
        println("${it.size} | ${it.toTypedArray().contentToString()}")
    }
}

fun takeNotTakeWithLoop(text: StringBuilder,index:Int,
                subList: MutableList<String>,list: MutableList<List<String>>) {

    if(index == text.length) {
        list.add(subList.toList())
        return
    }

    subList.add(text[index].toString())
    takeNotTakeWithLoop(text, index+1, subList, list)
    subList.removeLast()
    takeNotTakeWithLoop(text, index+1, subList, list)

    //OUTPUT
    // 3 | [A, S, P]
    // 2 | [A, S]
    // 2 | [A, P]
    // 1 | [A]
    // 2 | [S, P]
    // 1 | [S]
    // 1 | [P]
    // 0 | []
}
