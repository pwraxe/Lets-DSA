fun main() {
    val decimal = 1857
    println(toBinary(decimal, StringBuilder()))
    println(toOctal(decimal, StringBuilder()))
    println(toHex(decimal, StringBuilder()))
}

//Note: For  Convert to Binary, We Devide and Mod by 2
fun toBinary(num:Int, binary:StringBuilder): Long{
    if (num == 0) return binary.toString().reversed().toLong()
    return toBinary(num/2,binary.append(num % 2))
}

//Note: For  Convert to Octal, We Devide and Mod by 8
fun toOctal(num:Int, octal:StringBuilder): Int {
    if(num == 0) return octal.toString().reversed().toInt()
    return toOctal(num/8, octal.append(num % 8))
}

//Note: For  Convert to Hexadecimal, We Devide and Mod by 16
fun toHex(num:Int, hex: StringBuilder): Int {
    if(num == 0) return hex.toString().reversed().toInt()
    return toHex(num/16, hex.append(num%16))
}
