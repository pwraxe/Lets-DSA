class TrieNode<T>(var dataItem: T? = null, var parentNode: TrieNode<T>? = null) {
    var children : HashMap<T?, TrieNode<T>?> = hashMapOf()
    var isLastCharOfWord : Boolean = false
}

class Trie<T> {
    private var rootNode = TrieNode<T>()
    private val storedList : MutableSet<List<T>> = mutableSetOf()

    fun insertWord(word: List<T>) {
        var currentNode = rootNode
        word.forEach { char ->
            if(currentNode.children[char] == null) {
                currentNode.children[char] = TrieNode(char,currentNode)
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.isLastCharOfWord = true
        storedList.add(word)
    }

    fun removeWord(word: List<T>) {
        var currentNode = rootNode
        word.forEach {
            val child = currentNode.children[it] ?: return
            currentNode = child
        }

        if(!currentNode.isLastCharOfWord) return

        storedList.remove(word)
        currentNode.isLastCharOfWord = false

        var parent = currentNode.parentNode
        while (currentNode.children.isEmpty() && !currentNode.isLastCharOfWord) {
            parent?.children?.remove(currentNode.dataItem)
            currentNode = parent!!
            parent = currentNode.parentNode
        }
    }

    fun getAllWords() = storedList

    fun prefixMatch(prefix:List<T>) : List<List<T>> {
        var currentNode = rootNode
        prefix.forEach {
            val child = currentNode.children[it] ?: return emptyList()
            currentNode = child
        }

        return letsFilterAllPrefixChild(prefix,currentNode)
    }
    private fun letsFilterAllPrefixChild(prefix: List<T>, node: TrieNode<T>?) : List<List<T>> {

        val result = mutableListOf<List<T>>()

        if(node?.isLastCharOfWord == true) result.add(prefix)

        node?.children?.forEach { (key, node) ->
            key?.let {
                result.addAll(letsFilterAllPrefixChild(prefix+it, node))
            }
        }
        return result
    }

}

fun main() {
    Trie<Char>().apply {
        insertWord("APP".toList())
        insertWord("APPLE".toList())
        insertWord("APPLY".toList())
        insertWord("APPLICATION".toList())

        insertWord("DO".toList())
        insertWord("DONT".toList())
        insertWord("DOES".toList())
        insertWord("DONE".toList())

        println("Before removing : ${getAllWords()}")

        removeWord("DO".toList())
        println(prefixMatch("DO".toList()))
        println("After removing :${getAllWords()}")
    }
}
