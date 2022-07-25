------------------------------------------------------
//Recursion
fun main() {
    println("Power : ${calculatePower(2,5)}")
}
private fun calculatePower(num: Int, power: Int) : Int{
    return if(power != 0) num * calculatePower(num,power-1) else 1
}
------------------------------------------------------
fun main() {
    println(sumOfNos(99))
}
private fun sumOfNos(num: Int) : Int{
    var temp = 0
    if(num > 0) {
        temp = num + sumOfNos(num-1)
    } else 1
    return temp
}
------------------------------------------------------
fun main() {
    println(factNo(5))
}

private fun factNo (num: Int) : Int{
    var fact = 1
    if(num >= 1) {
        fact = num * factNo(num-1)
    }
    return fact
}
------------------------------------------------------
