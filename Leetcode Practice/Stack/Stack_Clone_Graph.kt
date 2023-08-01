/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */
//Recursive Solution: DFS
class Solution {
    
    private fun doClone(node: Node?, map:HashMap<Node?, Node?>) : Node? {
        
        //if node is null return null
        node ?: return null
        
        //if we have value at given node return that node
        map[node]?.let { return it }
        
        //Create new Node
        val newNode = Node(node?.`val`)
        
        //Update map with new node
        map[node] = newNode
        
        //Recursive call for each adjecent node
        node?.neighbors?.forEach {
            newNode.neighbors.add(doClone(it, map))
        }
        
        //return newNode 
        return newNode
    }
    fun cloneGraph(node: Node?): Node? {
        return doClone(node, hashMapOf<Node?, Node?>())
    }
}

/***
//Iterative Solution: Brute Force
class Solution {
    fun cloneGraph(node: Node?): Node? {
        
        node ?: return null
        
        val map = hashMapOf<Node?, Node?>()
        val stack = Stack<Node>()
        
        stack.push(node)
        val newNode = Node(node?.`val`!!)
        map[node] = newNode
        
        while(stack.isNotEmpty()) {
            
            val top = stack.pop()
            
            for(adj in top.neighbors) {
                 
                //if value of original node null then create clone and add to map and stack
                if(map[adj] == null) {
                    map[adj] = Node(adj?.`val`!!)
                    stack.push(adj)
                }
                
                //Connect prev. Node with current Node
                map[top]?.neighbors?.add(map[adj])
            }
        }
        return newNode
    }
}

***/
