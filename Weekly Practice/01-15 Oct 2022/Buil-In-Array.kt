//TODO --> 1 : CRUD Operation on Built-In-Array

fun main() {

    arrayListOf<String>().apply {
        //CREATE
        add("Math")
        add("Science")
        add("Physics")
        add(2,"Chemistry")

        //READ ALL
        println(this.toString())

        //Update
        set(0,"Mathematics")
        //READ Single
        println("Read Single : ${get(0)}")

        //DELETE
        remove("Science")
        removeAt(0)
        println(this.toString())
    }

    arrayOfNulls<String>(10).apply {
        //CREATE
        this[0] = "Math"
        this.set(1,"Physics")
        this[5] = "Chem"
        this.set(7,"Biology")

        //READ
        println(this.contentToString())

        //Update
        this[0] = "Mathematics"
        this.set(5,"Chemistry")

        //READ
        println(this.contentToString())

        //Delete
        this[0] = null
        set(5,null)

        //READ
        println(this.contentToString())
    }
    
}
