class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.size == 0) return ""
        
        //|f|l|o|w|e|r|
        var prefix = ""
        
        strs[0].forEachIndexed { i, ch -> 
            prefix += ch
            //string - "flower"
            strs.forEachIndexed {j, text ->
                if(!text.startsWith(prefix)) return prefix.substring(0, prefix.length-1)
            }
        }
        return strs[0].toString()
    }
    
}

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
