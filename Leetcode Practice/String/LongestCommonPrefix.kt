
//--------------------------------From Soluton by own
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        var sub = StringBuilder()
        strs[0].forEachIndexed { index, ch ->
            sub.append(ch)
            if(!strs.all { it.startsWith(sub)}) return sub.substring(0, sub.length-1)
        }
        return strs[0]
    }
}


//------------------------ From Soltion

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        return StringBuilder().apply {
            strs.minBy { 
            it.length 
            }?.forEachIndexed { i, c -> 
                if(strs.all { it[i] == c}) append(c) else return toString()
            }
        }.toString()   
    }
}
