fun main() {

    //----------------------------------------------------------------------------
    //1. this is immutable in nature
    //2. This is Read only list, add element, remove element, by + or -
    //3. DisAdvantages : For add, Remove each time new list need to create
    val days = listOf("Sun","Mon","Tues")
    println("Days : $days") //[Sun, Mon, Tues]

    // We  have to create new one Immutable list
    val newDays = days + "Wed"
    println("New Days : $newDays") //[Sun, Mon, Tues, Wed]

    //We Have to create new Immutable list
    val resetDays = newDays - "Sun"
    println("reset Days : $resetDays") //[Mon, Tues, Wed]


    //----------------------------------------------------------------------------
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
