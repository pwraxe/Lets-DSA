class VectorOwner<T> {
    private val minCapacity = 8
    var elements : Array<Any?>
    private var size = 0

    constructor() {
        //this.elements = arrayOf() //throws an ArrayIndexOutOfBoundException
        //OR
        this.elements = Array(minCapacity) { null }
    }

    constructor(capacity: Int) {
        elements = if(capacity > 0) {
            Array<Any?>(capacity) { null }
            //OR
            //arrayOfNulls(capacity)
        } else if(capacity == 0) { arrayOf() }
        else throw IllegalArgumentException("Invalid capacity")
    }

    /** FLOW
     * 1. compare total element with size
     * 2. if fill then calculate increment capacity
     * 3. create new array with incremented capacity
     * 4. Copy existing array into new Array
     * 5. assign all list to default array "element"
     * 6. assign new array element to default list and increment size
     * **/
    fun addCustom(item : T?) {
        if(size == elements.size) {

            /**If (Condition) always false here,
             * Ex.
             * size = 12
             * minCapacity/2 = 6/2 = 3
             * if(12 < 3) ... else this will exe.
             * Hence, We don't need of if condition any-more
            **/
            //val incCapacity = if(size < minCapacity/2) minCapacity else size shr 1

            /** So We can directly write as... **/
            val incCapacity = size shr 1

            /** increase size more than half of size (Ex. size is 6 then incCapacity = 9)
            //50% increment in current size if we write 'shr' ***/

            val newArray = arrayOfNulls<Any?>(size + incCapacity) // OR arrayOfNulls<Any?>(size + (size shr 1))
            System.arraycopy(elements,0,newArray,0,size)
            elements = newArray
        }
        elements[size] = item
        size++
    }
    fun addCustom(index: Int, item : T?) {
        if(index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid index $index")
        }
        if(size < elements.size) {
            println("From Elements : ${elements.contentToString()}\n" +
                    "Index : $index\n" +
                    "To Element${elements.contentToString()}\n" +
                    "index+1 : ${index+1}\n [$size - $index] : ${size - index}")

            System.arraycopy(elements,index,elements,index+1,size-index)
            println("\n\n\n")
        } else {

            /**
             * FLOW
             * 1. Create New Array with extra size
             * 2. Copy elements of existing array to new array
             * 3. Copy Self Element in self but shift element to next from given index
             * (i.e. Khud ki size badhao, aur khud ke elements khud me hi copy-paste karo with next index)
             * 4. Assign all elements from 'newArray' to 'elements' array
             * 5. Assing Item to index
             * 6. Inc size
             * */

            val incCapacity = size shr 1
            val newArray = arrayOfNulls<Any?>(size+incCapacity)
            System.arraycopy(elements,0,newArray,0,index)

            println("FROM Elements : ${elements.contentToString()}\n" +
                    "Index : $index\n" +
                    "TO Element${elements.contentToString()}\n" +
                    "index+1 : ${index+1}\n [$size - $index] : ${size - index}")

            System.arraycopy(elements,index,newArray,index+1,size-index)
            elements = newArray
        }
        elements[index] = item
        size += 1
    }

    fun updateElement(index: Int, item: Any) {

        /**
         * We can check via element.size also
         * but we additional get NPE,
         * and we only want to update element, not null
         *
         * **/

        /** If I want to update NOT NULL Values **/
//        if(index >= size) {
//            throw ArrayIndexOutOfBoundsException("Invalid Index : $index")
//        }

        /** If I want to update Null Value **/
        if(index >= elements.size) {
            throw ArrayIndexOutOfBoundsException("Invalid Index : $index")
        }

        /** Following for checking null data, if null throw exception else no **/
//        elements[index] ?: throw NullPointerException("Cannot update null value")
        /** This line, We know that, we have element in variable **/
        elements[index] = item
    }

    fun getElement(index: Int) : Any? {

        /** If we strictly want to get not null value **/
//        if(index >= size) {
//            throw ArrayIndexOutOfBoundsException("Invalid Index")
//        }

        /** If we want to get null value additionaly besides element **/
        if(index >= elements.size) {
            throw ArrayIndexOutOfBoundsException("Invalid Index : $index")
        }
        return elements[index]
    }

    fun removeElement(index: Int) {
        if(index >= size) {
            throw ArrayIndexOutOfBoundsException("Invalid Index : $index")
        }
        elements[index] ?: throw NullPointerException("Cannot remove null value")
        System.arraycopy(elements,index+1,elements,index,size-index-1)
        elements[--size] = null
    }

    fun removeElement(element: Any)  {

        var isElementRemoved = false

        for (index in 0 until size) {
            if(element == elements[index]) {

                /**
                 * At here
                 * 1. We know index
                 * 2. We know element
                 * **/
                System.arraycopy(elements,index+1,elements,index,size - index - 1)
                elements[--size] = null

                isElementRemoved = true
            }
        }
    }


}

fun main() {


    /**
     * Formula of shr (Shift Right)
     * (x/ 2 is n times)  where x is value and n is no.ofBitsToShift
     * (5000/2*2*2*2) => i.e. 5000 shr 4 => 312
    **/


//    val size = 5000
//    val sizeInHalf = size shr 4     // 50
//    val sizeInDouble = size shl 1   // 200
//    println("$sizeInHalf, $sizeInDouble")

    VectorOwner<Any>().apply {

        addCustom(0,10)
        addCustom(1,"AAA")
        addCustom(2,14.5)
        addCustom(3,true)
        addCustom(4,false)
        addCustom(5,"XXX")
        addCustom("DELETE ME")

        println("Before Update : ${this.elements.contentToString()}")
        updateElement(6,1000L)
        removeElement(1)
        removeElement(element = "XXX")
        println("After Update : ${this.elements.contentToString()}")
        println("Element at 7 : ${getElement(7)}")
    }
}
