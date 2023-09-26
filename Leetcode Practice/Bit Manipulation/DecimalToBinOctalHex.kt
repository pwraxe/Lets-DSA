fun main() {
    val decimal = 1857
    println(toBinary(decimal, StringBuilder()))
    println(toOctal(decimal, StringBuilder()))
    println(toHex(decimal, StringBuilder()))

    //Fraction decimal to binary
    val fraction = 1857.625
    val binaryOfBeforeDecimal = toBinary(fraction.toInt(), StringBuilder())
    val binaryOfAfterDecimal = toFractionBinary(fraction-fraction.toInt(), StringBuilder())
    println("${binaryOfBeforeDecimal}.${binaryOfAfterDecimal}")
}

//Note: For  Convert to Binary, We Devide and Mod by 2
fun toBinary(num:Int, binary:StringBuilder): Long{
    if (num == 0) return binary.toString().reversed().toLong()
    return toBinary(num/2,binary.append(num % 2))
}

//0.625 x 2 = 1.25 with Integer 1
//0.25 x 2 = 0.5 with Integer 0
//0.5 x 2 = 1.0 with Integer 1
//0.0 x 2 = 0.0 with Integer 0
fun toFractionBinary(num: Double, binary: StringBuilder): Long {
    if(num == 0.0) return binary.toString().reversed().toLong()
    val n = num * 2.0
    return toFractionBinary(n-n.toInt(), binary.append(n.toInt()))
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
