fun main() {
    val text = "Android Akshay"
    println(revStringWay1(text))
    println(revStringWay2(StringBuilder(text),0,text.length-1))
    println(revStringWay3(text,StringBuilder("")))
}

fun revStringWay3(text: String, rev:StringBuilder): String {
    if(text.isEmpty()) return text
    revStringWay3(text.substring(1),rev)
    return rev.append(text[0]).toString()
}

fun revStringWay2(text: StringBuilder, start: Int, end: Int): String {
    if(start == text.length/2) return text.toString()
    text[start] = text[end].also { text[end] = text[start] }
    return revStringWay2(text,start+1, end-1)
}

fun revStringWay1(text: String): String {
    if(text.isEmpty()) return text
    return revStringWay1(text.substring(1)) + text[0]
}
