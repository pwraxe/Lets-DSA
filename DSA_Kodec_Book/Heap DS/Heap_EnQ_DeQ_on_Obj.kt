import kotlinx.coroutines.selects.select

/**
 * Min Priority Queue with Objects
 * List is not sorts, but satisfies Min Heap Condition
 * **/

data class Person(val age: Int, val name: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return age.compareTo(other.age)
    }
}

class MinPriorityQueue<T: Comparable<T>> {

    private val persons = arrayListOf<T>()
    private fun count() = persons.size
    private fun isEmpty() = count() == 0

    private fun getParentIndex(index: Int) = (index - 1) / 2
    private fun getLeftChildIndex (index: Int) = (2 * index) + 1
    private fun getRightChildIndex(index: Int) = (2 * index) + 2


    fun readAll() = persons
    fun enqueue(item: T) {
        persons.add(item)
        if(count() > 1) {
            toUpperForMinHeap(count()-1)
        }
    }

    private fun toUpperForMinHeap(currentIndex: Int) {

        val parentIndex = getParentIndex(currentIndex)

        if(currentIndex > 0 && persons[currentIndex] < persons[parentIndex]) {
            persons[currentIndex] = persons[parentIndex].also { persons[parentIndex] = persons[currentIndex]}
        }

        if(currentIndex != parentIndex) {
            toUpperForMinHeap(parentIndex)
        }
    }

    fun dequeue() : T? {
        if(!isEmpty()) {
            val lastIndex = count() - 1
            persons[0] = persons[lastIndex].also {persons[lastIndex] = persons[0] }
            val item = persons.removeLast()
            if(count() > 1) toLowerForMinHeap(0)
            return item
        }
        return null
    }
    private fun toLowerForMinHeap(index: Int) {
        val leftChildIndex = getLeftChildIndex(index)
        val rightChildIndex = getRightChildIndex(index)
        var currentIndex = index

        if(leftChildIndex < count() && persons[leftChildIndex] < persons[currentIndex]) {
            currentIndex = leftChildIndex
        }

        if(rightChildIndex < count() && persons[rightChildIndex] < persons[currentIndex]) {
            currentIndex = rightChildIndex
        }

        if(index != currentIndex) {
            persons[index] = persons[currentIndex].also { persons[currentIndex] = persons[index] }
            toLowerForMinHeap(currentIndex)
        }
    }
}

fun main() {
    MinPriorityQueue<Person>().apply {
        enqueue(Person(5,"Jony"))
        enqueue(Person(13,"Jony"))
        enqueue(Person(3,"bany"))
        enqueue(Person(24,"nick"))
        enqueue(Person(45,"andrew"))

        dequeue()
        readAll().forEach {
            println("${it.age} --> ${it.name}")
        }
    }
}
