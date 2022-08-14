fun main() {
    //1. this is immutable in nature
    //2. This is Read only list,
    val days = listOf("Sun","Mon","Tues")
    println("Days : $days") //Days : [Sun, Mon, Tues]


    //1. This is mutable in nature
    //2. We can add remove, Update values in List
    val months = arrayListOf("Jan","Feb","Mar","April")
    println("Run 1 ---> $months") //[Jan, Feb, Mar, April]

    //Add Element in List
    months.add("May")
    println("Run 2 ---> $months") //[Jan, Feb, Mar, April, May]

    //Update Element in List
    months[4] = "MAY"
    println("Run 3 ---> $months") //[Jan, Feb, Mar, April,MAY]

    //1. Remove Element in List
    //2. For Remove values in List should be same as values you updating
    months.remove("MAY")
    println("Run 4 ---> $months") //[Jan, Feb, Mar, April]
}
