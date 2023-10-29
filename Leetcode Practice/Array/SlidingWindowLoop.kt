fun main() {
    var i = 0
    var j = 3
    val list = intArrayOf(1,2,3,4,5,6,7,8,9)

    while (j <= list.size) {
        val subList = list.toList().subList(i,j)
        println(subList.toTypedArray().contentToString())
        j++
        i++
    }
}

//Output 
[1, 2, 3]
[2, 3, 4]
[3, 4, 5]
[4, 5, 6]
[5, 6, 7]
[6, 7, 8]
[7, 8, 9]
