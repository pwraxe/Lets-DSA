class TrieNode<T>(var dataItem: T? = null, var parentNode : TrieNode<T>? = null) {
    var children : HashMap<T?,TrieNode<T>?> = hashMapOf()
    var isTerminatingNode: Boolean = false
}

//Time Complexity : O(n)
//n : size of word which want to find in tree
class Trie<T> {
    private var rootNode : TrieNode<T>? = TrieNode()

    fun insertWord(word: List<T>) {
        var currentNode = rootNode
        word.forEach { char ->

            //Check (Character) Node Exists or not
            if(currentNode?.children?.get(char) == null) {
                //We can't found given character under node,
                //create one and attach to parent
                currentNode?.children?.set(char,TrieNode(char,currentNode))
            }
            //navigate currentNode to Newly Created or Existing Node
            currentNode = currentNode?.children?.get(char)
        }
        //When All (Characters) Nodes Added, finally mark last Node or Character as Terminating
        //So While Searching you will know, word available or not in trie
        currentNode?.isTerminatingNode = true
    }

    fun contains(word: List<T>) : Boolean {
        var currentNode = rootNode
        word.forEach { char ->
            val child = currentNode?.children?.get(char) ?: return false
            currentNode = child
        }
        return currentNode?.isTerminatingNode!!
    }

    fun remove(word: List<T>) {

        var currentNode = rootNode
        word.forEach {
            val child = currentNode?.children?.get(it) ?: return
            currentNode = child
        }
        if(currentNode?.isTerminatingNode == false) return
        currentNode?.isTerminatingNode = false

        var parent = currentNode?.parentNode
        while (currentNode?.children?.isEmpty() == true
            && !currentNode?.isTerminatingNode!!) {

            parent?.let {
                it.children.remove(currentNode?.dataItem)
                //Update Current Node
                currentNode = it
                //Update Parent Node
                parent = currentNode?.parentNode
            }
        }
    }

    fun prefixMatching(prefix: List<T>) : List<List<T>> {

        var current = rootNode
        prefix.forEach {
            val child = current?.children?.get(it) ?: return emptyList()
            current = child
        }
        return prefixMatchingHelper(prefix,current)
    }

    //Note: The prefix we gave, it returns all childs below the prefix
    private fun prefixMatchingHelper(prefix: List<T>, node: TrieNode<T>?) : List<List<T>> {
        val results = mutableListOf<List<T>>()

        if(node?.isTerminatingNode == true) {
            results.add(prefix)
        }

        node?.children?.forEach { (key, node) ->
            key?.let {
                results.addAll(prefixMatchingHelper( prefix+it,node))
            }
        }
        return results
    }
}

fun main() {
    Trie<Char>().apply {

        insertWord("TIME".toList())
        insertWord("APP".toList())
        insertWord("APPLE".toList())
        insertWord("APPLY".toList())
        insertWord("API".toList())
        insertWord("DO".toList())
        insertWord("DOING".toList())
        insertWord("DONE".toList())

        val toRemove = "DOING".toList()
        println("Before Remove : ${contains(toRemove)}")
        this.remove(toRemove)
        println("After Remove : ${contains(toRemove)}")

        println(this.prefixMatching("AP".toList()).toTypedArray().contentToString())
    }
}
