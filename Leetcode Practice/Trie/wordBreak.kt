data class TrieNode(
    val childs: HashMap<Char, TrieNode>,
    var isComplete: Boolean = false
    )
class Trie {

    private val root = TrieNode(hashMapOf())

    fun insert(word: String) {
        var currentParent = root
        word.forEach {
            if (currentParent.childs[it] == null) {
                currentParent.childs[it] = TrieNode(hashMapOf())
            }
            currentParent = currentParent.childs[it]!!
        }
        currentParent.isComplete = true
    }

    fun search(word: String): Boolean {
        var currentParent = root
        word.forEach {
            if (currentParent.childs[it] == null) return false
            currentParent = currentParent.childs[it]!!
        }
        return currentParent.isComplete
    }

    fun wordBreak(key: String): Boolean {
        if (key.isEmpty()) return true

        for (i in 1 .. key.length) {
            if (
                search(key.substring(0,i)) &&
                wordBreak(key.substring(i))
            ) return true
        }
        return false
    }
}

fun main() {
    Trie().apply {
        val list = listOf("I","like","and","android","mobile","device")
        list.forEach { insert(it) }
        val key = "Ilikeandroidmobile"
        println(wordBreak(key)) //true
    }
}
