//Leetcode Problem: find total no with even no in digits from list

fun main()  {
    val list = arrayOf(10,123,5,87,514,3245,1012)
    var digits = 0
    list.forEach {

        var count = 0
        var  num = it

        while(num != 0) {
            num /= 10
            count++
        }

        if(count % 2 == 0) digits++
    }

    println("List has $digits even numbers in digits")
}
