
fun main() {
    Stack<Int>().apply {

        //Create
        this.push(20)
        this.push(21)

        //Update
        this.set(1,1000)

        //Delete
        pop()

        //Read
        var list = Array<Int?>(this.size){ null }
        for (index in 0 until size) {
            list[index] = get(index)
        }
        println("${list.contentToString()} | ${this.peek()}")
    }
}
