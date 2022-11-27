fun main() {
    val list = intArrayOf(5,7,2,1,0,2,3,9,55,7,8,25,10,-10)
    
    println(list.letsSort().contentToString())

    println(list.toMutableList().rawSort())

}

fun <T : Comparable<T>> MutableList<T>.rawSort(): MutableList<T> {
    for (i in 0 until size) {
        for (j in 0 until size-1) {

            //if(this[j] > this[i]) {} --> toSort Ascending Order
            //if(this[j] < this[i]) {} --> toSort Descending Order
          
            if(this[i] > this[j]) {
                var temp = this[j]
                this[j] = this[i]
                this[i] = temp
            }
        }
    }
    return this
}

fun IntArray.letsSort() : IntArray {
    for (i in 0 until this.size) {
        for (j in 0 until this.size-1) {
            //if(this[j] > this[i]) {} --> toSort Ascending Order
            //if(this[j] < this[i]) {} --> toSort Descending Order
          
            if(this[j] > this[i]) {
                val temp = this[i]
                this[i] = this[j]
                this[j] = temp
            }
        }
    }
    return this
}
