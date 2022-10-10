/**
To Extend ArrayList Just for making some modification in add or any function to save data according to our need

**/


import kotlin.random.Random

class MainList : ArrayList<String>() {

    override fun add(element: String): Boolean {
        val max3Chars = when(element.length) {
            1 -> {
                "$element${getSingleChars()}${getSingleChars()}"
            }
            2 -> {
                "$element${getSingleChars()}"
            }
            3 -> element
            else-> { //More than 3 chars
                element.substring(0,3)
            }
        }
        return super.add(max3Chars)
    }

    private fun getSingleChars() : Char {
        return Random.nextInt(97,122).toChar()
    }
    override fun add(index: Int, element: String) {
        super.add(index, element.uppercase())
    }

    override fun addAll(elements: Collection<String>): Boolean {
        return super.addAll(elements.map { it.uppercase() })
    }

    override fun addAll(index: Int, elements: Collection<String>): Boolean {
        return super.addAll(index, elements.map { it.uppercase() })
    }
}

fun main() {
    MainList().apply {
        add("a")
        add("bb")
        add("CcC")
        add("ddDD")
        println(this)
    }
}
