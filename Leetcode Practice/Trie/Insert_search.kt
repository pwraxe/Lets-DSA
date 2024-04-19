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

    fun read(node: TrieNode? = root) {
        node ?: return
        node.childs.forEach {
            print("${it.key}, ")
            read(it.value)
        }
    }
}

fun main() {
    Trie().apply {
        insert("Hello")
        insert("Hipe")
        insert("Work")
        insert("Wonder")
        insert("Working")
        read()
        println()
        println(search("Hipe"))
        println(search("Hell"))
    }
}



W, o, r, k, i, n, g, n, d, e, r, H, e, l, l, o, i, p, e, 
true
false
