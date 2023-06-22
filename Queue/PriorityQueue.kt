/**
Priority Queue has MIN-HEAP default implementation
Element Sort Accourding to MinHeap
Min Element has highest priority
**/

import java.util.*

data class Person(val index: Int, val weight: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return weight.compareTo(other.weight)
    }
}

fun main() {

    PriorityQueue<Person>().apply {
        add(Person(0,84))
        add(Person(1,48))
        add(Person(2,75))
        add(Person(3,62))
        add( Person(4,51))


        println(this)

        while (this.isNotEmpty()) {
            val vertex = this.poll()
            println("[${vertex.index}] = ${vertex.weight}")
        }
    }
}


/**
[Person(index=1, weight=48), Person(index=4, weight=51), Person(index=2, weight=75), Person(index=0, weight=84), Person(index=3, weight=62)]
[1] = 48
[4] = 51
[3] = 62
[2] = 75
[0] = 84
*/
