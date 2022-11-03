//TODO --> CRUD Operation on ArrayMap


//Note : Do not consider this, practice again and update new below this code

import java.util.*

class LetsArrayMap<K,V> (minCapacity : Int = 0) {

    private lateinit var hashArray : IntArray       // if -> hashArray.size
    private lateinit var keyValArray : Array<Any?>  // then -> hashArray.size * 2
    private var size : Int = 0

    init {
        initialisation(minCapacity)
    }

    private fun initialisation(cap:Int) {
        if(cap <= 0) {
            hashArray = IntArray(0)       //Init with 0
            keyValArray = arrayOf()
        } else {
            createNewSize(cap)
        }
    }

    private fun createNewSize(cap : Int) {
        hashArray = IntArray(cap)
        keyValArray = arrayOfNulls(cap shl 1)
    }

    fun getValue(key: K) : V?  {
        val index = indexOfKey(key)
        return if(index >= 0) keyValArray[(index shl 1) + 1] as V else null
    }

    fun getSize() : Int = size

    fun putValue(key:K,value : V) {
        val hash : Int
        var index : Int
        if(key == null) {
            hash = 0
            index = indexOfZero()
        } else {
            hash = key.hashCode()
            index = indexOf(key)
        }
        //Update
        if(index >= 0) {
            //K-V already present
            index = (index shl 1) + 1 //index of value
            keyValArray[index] = value
            return //i.e. Do not Execute further
        }
        //if above condition is false, i.e index is less than 0 (or in minus) make it positive value by .inv()
        index = index.inv()
        if(size >= hashArray.size) {
            val newSize = (size shr 1) + size
            val tempHashArray = hashArray
            val tempKeyValArray = keyValArray
            createNewSize(newSize)
            System.arraycopy(tempHashArray,0,hashArray,0,tempHashArray.size)
            System.arraycopy(tempKeyValArray,0,keyValArray,0,tempKeyValArray.size)
        }
        if(index < size) {
            System.arraycopy(hashArray,index,hashArray,index+1,size-index)
            System.arraycopy(keyValArray,index shl 1, keyValArray, (index + 1) shl 1,(size-index) shl 1 )
        }
        hashArray[index] = hash
        keyValArray[index shl 1] = key
        keyValArray[(index shl 1) + 1] = value
        size++
    }

    fun getAllValues() : Array<Any?> {

        val list = arrayOfNulls<Any>(keyValArray.size)
        for (index in keyValArray.indices) {
            if(keyValArray[index] != null) {
                list[index] = keyValArray[index]
            }
        }
        return list

    }

    fun removeValue(key: K) {
        val index = indexOfKey(key)
        if(index > 0) {
            removeAt(index)
        } else println("Cant Removed : $key")
    }

    private fun removeAt(index: Int) {

        if(size <= 1) {
            //empty map
            initialisation(0)
        } else {
            --size
            System.arraycopy(hashArray,index+1,hashArray,index,size-index)
            hashArray[hashArray.size-1] = 0

            System.arraycopy(keyValArray, (index + 1) shl 1,
                keyValArray, (index shl 1),
                (size-index) shl 1)

            keyValArray[index shl 1] = null
            keyValArray[(index shl 1) + 1] = null
        }
    }

    private fun indexOfKey(key: K) : Int {
        return if(key == null) indexOfZero() else indexOf(key)
    }

    private fun indexOf(key: K) : Int {
        val hash = key.hashCode()
        if(size == 0) return 0.inv()        //-1

        val index = Arrays.binarySearch(hashArray,0,size,hash)
        //Key not found, return -ve value
        if(index < 0) return index

        //match given key with array key if match return index
        if(key == keyValArray[index shl 1]) return index

        //Search Matching HashCode in hashArray after index
        var afterIndex = index + 1      //hashArray Index
        while (afterIndex < size && hashArray[afterIndex] == hash) {
            if(key == keyValArray[afterIndex shl 1]) return afterIndex
            afterIndex++
        }

        //Search Matching HashCode in hashArray before index
        var beforeIndex = index-1
        while (beforeIndex >= 0 && hashArray[beforeIndex] == hash) {
            if(key == keyValArray[beforeIndex shl 1]) return beforeIndex
            beforeIndex--
        }
        return afterIndex.inv()
    }

    private fun indexOfZero() : Int {
        if(size == 0) return -1 //i.e 0.inv()

        val index = Arrays.binarySearch(hashArray,0,size,0)
        if(index < 0) return index
        if(keyValArray[index shl 1] == null) return index

        var afterIndex = index+1

        while (afterIndex < size && hashArray[afterIndex] == 0) {
            if(keyValArray[afterIndex shl 1] == null) {
                return afterIndex
            }
            afterIndex++
        }

        var beforeIndex = index - 1
        while (beforeIndex > 0 && hashArray[beforeIndex] == 0) {
            if(keyValArray[beforeIndex shl 1] == null) {
                return beforeIndex
            }
            beforeIndex--
        }
        return afterIndex.inv()
    }
}

fun main() {
    LetsArrayMap<String,String>(6).apply {
        putValue("K111","Akshay111")
        putValue("K222","Akshay222")
        putValue("K333","Akshay333")
        putValue("K444","Akshay444")

        putValue("K222","A2A2A2")

        removeValue("K333")
        
        println("${getSize()} ||| ${getValue("K111")} || ${getAllValues().contentToString()}")
    }
}
//-----------------------------------------------------------------------------------------------------------------------

//Practice Again of above code 
import java.util.*

class LetsArrayMap<K,V> (minCapacity : Int = 0) {

    private lateinit var hashArray : IntArray       // if -> hashArray.size
    private lateinit var keyValArray : Array<Any?>  // then -> hashArray.size * 2
    private var size : Int = 0

    init {
        initialisation(minCapacity)
    }

    private fun initialisation(cap:Int) {
        if(cap <= 0) {
            hashArray = IntArray(0)       //Init with 0
            keyValArray = arrayOf()
        } else {
            hashArray = IntArray(cap)
            keyValArray = arrayOfNulls(cap shl 1)
        }
    }

    fun getValue(key: K) : V?  {
        val index = if(key == null) indexOfNull() else indexOf(key)
        return if(index >= 0) keyValArray[(index shl 1) + 1] as V else null
    }

    fun getSize() : Int = size

    fun putValue(key:K,value : V) {
        val hash : Int
        var hashIndex : Int

        if(key == null) {
            hash = 0
            hashIndex = indexOfNull()
        } else {
            hash = key.hashCode()
            hashIndex = indexOf(key)
        }
        //Update
        if(hashIndex >= 0) {
            //K-V already present
            hashIndex = (hashIndex shl 1) + 1 //index of value
            keyValArray[hashIndex] = value
            return //i.e. Do not Execute further
        }
        //if above condition is false, i.e index is less than 0 (or in minus) make it positive value by .inv()
        hashIndex = hashIndex.inv()
        if(size == hashArray.size) {
            val newSize = (size shr 1) + size
            val tempHashArray = hashArray
            val tempKeyValArray = keyValArray
            initialisation(newSize)
            System.arraycopy(tempHashArray,0,hashArray,0,tempHashArray.size)
            System.arraycopy(tempKeyValArray,0,keyValArray,0,tempKeyValArray.size)
        }
        if(hashIndex < size) {
            System.arraycopy(hashArray,hashIndex,hashArray,hashIndex+1,size-hashIndex)
            System.arraycopy(keyValArray,hashIndex shl 1, keyValArray, (hashIndex + 1) shl 1,(size-hashIndex) shl 1 )
        }
        hashArray[hashIndex] = hash
        keyValArray[hashIndex shl 1] = key
        keyValArray[(hashIndex shl 1) + 1] = value
        size++
    }

    fun getAllValues() : Array<Any?> {

        val list = arrayOfNulls<Any>(keyValArray.size)
        for (index in keyValArray.indices) {
            if(keyValArray[index] != null) {
                list[index] = keyValArray[index]
            }
        }
        return list

    }

    fun removeValue(key: K) {
        val index = if(key == null) indexOfNull() else indexOf(key)
        if(index > 0) {
            removeAt(index)
        } else println("Cant Removed : $key")
    }

    private fun removeAt(index: Int) {

        if(size <= 1) {
            //empty map
            initialisation(0)
        } else {
            --size
            System.arraycopy(hashArray,index+1,hashArray,index,size-index)
            hashArray[hashArray.size-1] = 0

            System.arraycopy(keyValArray, (index + 1) shl 1,
                keyValArray, (index shl 1),
                (size-index) shl 1)

            keyValArray[index shl 1] = null
            keyValArray[(index shl 1) + 1] = null
        }
    }

    private fun indexOf(key: K) : Int {
        val hash = key.hashCode()
        if(size == 0) return 0.inv()        //-1

        val index = Arrays.binarySearch(hashArray,0,size,hash)
        //Key not found, return -ve value
        if(index < 0) return index

        //match given key with array key if match return index
        if(key == keyValArray[index shl 1]) return index

        //Search Matching HashCode in hashArray after index
        var afterIndex = index + 1      //hashArray Index
        while (afterIndex < size && hashArray[afterIndex] == hash) {
            if(key == keyValArray[afterIndex shl 1]) return afterIndex
            afterIndex++
        }

        //Search Matching HashCode in hashArray before index
        var beforeIndex = index-1
        while (beforeIndex >= 0 && hashArray[beforeIndex] == hash) {
            if(key == keyValArray[beforeIndex shl 1]) return beforeIndex
            beforeIndex--
        }
        return afterIndex.inv()
    }

    private fun indexOfNull() : Int {
        if(size == 0) return -1 //i.e 0.inv()

        val index = Arrays.binarySearch(hashArray,0,size,0)
        if(index < 0) return index
        if(keyValArray[index shl 1] == null) return index

        var afterIndex = index+1

        while (afterIndex < size && hashArray[afterIndex] == 0) {
            if(keyValArray[afterIndex shl 1] == null) {
                return afterIndex
            }
            afterIndex++
        }

        var beforeIndex = index - 1
        while (beforeIndex > 0 && hashArray[beforeIndex] == 0) {
            if(keyValArray[beforeIndex shl 1] == null) {
                return beforeIndex
            }
            beforeIndex--
        }
        return afterIndex.inv()
    }
}

fun main() {
    LetsArrayMap<String,String>(4).apply {
        putValue("K111","Akshay111")
        putValue("K222","Akshay222")
        putValue("K333","Akshay333")
        putValue("K444","Akshay444")
        putValue("K555","Akshay555")

        putValue("K222","A2A2A2")

        removeValue("K333")

        println("${getSize()} ||| ${getValue("K111")} || ${getAllValues().contentToString()}")
    }
}



