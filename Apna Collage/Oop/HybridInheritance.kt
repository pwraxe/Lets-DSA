open class Animal {
    fun animal() {
        println("Animal Class")
    }
}

open class Fish : Animal() {
    fun fish() {
        println("Fish Class")
    }
}
open class Bird : Animal() {
    fun bird() {
        println("Bird Class")
    }
}
open class Mammal: Animal() {
    fun mammal() {
        println("Mammal Class")
    }
}

class Tuna : Fish() {
    fun tuna() {
        println("Tuna Class")
    }
}
class Shark: Fish() {
    fun shark() {
        println("Shark Class")
    }
}

class Peacock : Bird() {
    fun peacock() {
        println("Peacock Class")
    }
}

class Dog : Mammal() {
    fun dog() {
        println("Dog Class")
    }
}
class Cat: Mammal() {
    fun cat() {
        println("Cat Class")
    }
}
class Human: Mammal() {
    fun human() {
        println("Human Class")
    }
}

fun main() {
    Animal().apply {
        animal()
    }
    println("=================")

    Fish().apply {
        this.animal()
        this.fish()
    }
    println("=================")

    Shark().apply {
        this.shark()
        this.fish()
        this.animal()
    }
    println("=================")

    Tuna().apply {
        this.tuna()
        this.fish()
        this.animal()
    }
    println("=================")

    Bird().apply {
        this.bird()
        this.animal()
    }
    println("=================")

    Peacock().apply {
        this.peacock()
        this.bird()
        this.animal()
    }
    println("=================")

    Mammal().apply {
        this.mammal()
        this.animal()
    }
    println("=================")

    Dog().apply {
        this.dog()
        this.mammal()
        this.animal()
    }
    println("=================")

    Cat().apply {
        this.cat()
        this.mammal()
        this.animal()
    }
    println("=================")

    Human().apply {
        this.human()
        this.mammal()
        this.animal()
    }
}



Animal Class
=================
Animal Class
Fish Class
=================
Shark Class
Fish Class
Animal Class
=================
Tuna Class
Fish Class
Animal Class
=================
Bird Class
Animal Class
=================
Peacock Class
Bird Class
Animal Class
=================
Mammal Class
Animal Class
=================
Dog Class
Mammal Class
Animal Class
=================
Cat Class
Mammal Class
Animal Class
=================
Human Class
Mammal Class
Animal Class
