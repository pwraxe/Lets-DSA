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

        //OUTPUT : [ASP, APS, SAP, PSA]   
        //permutation(text, i+1, list)
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
