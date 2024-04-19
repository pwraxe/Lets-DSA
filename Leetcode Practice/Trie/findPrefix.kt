data class TrieNode(
    val childs: HashMap<Char, TrieNode>,
    var isComplete: Boolean = false,
    var freq: Int = 0
    )
class Trie {

    private val root = TrieNode(hashMapOf())

    fun insert(word: String) {
        var currentParent = root
        word.forEach {
            if (currentParent.childs[it] == null) {
                currentParent.childs[it] = TrieNode(hashMapOf(), freq = 1)
            } else {
                currentParent.childs[it]?.freq = currentParent.childs[it]?.freq?.plus(1)!!
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

    private fun findPrefix(node: TrieNode?, ans: String) {
        node ?: return
        if (node.freq == 1) {
            println(ans)
            return
        }

        node.childs.forEach {
            if (node.childs[it.key] != null) {
                findPrefix(node.childs[it.key],ans+it.key)
            }
        }
    }
    fun findPrefix() {
        findPrefix(root,"")
    }
}

fun main() {
    Trie().apply {
//        val list = listOf("I","like","and","android","mobile","device")
//        list.forEach { insert(it) }
//        val key = "Ilikeandroidmobile"
//        println(wordBreak(key))

        val list = listOf("Word","Wonder","Work","Cake","Cap","Cry","Dry","Dog","Door")
        list.forEach { insert(it) }
        findPrefix()

    }
}

//==================================
Cap
Cak
Cr
Dr
Dog
Doo
Word
Work
Won
