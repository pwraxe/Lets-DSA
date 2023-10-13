//Leetcode: Replace Word
//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/

//you are failing following test case
//["e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"]
//"ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"

class Solution {
    data class TrieNode(val char: Char? = null, val parentNode: TrieNode? = null) {
        var isWordComplete : Boolean = false
        val children = hashMapOf<Char,TrieNode>()
    }

    private val rootNode = TrieNode()

    private fun insertWord(text: String) {
        var currentNode = rootNode
        text.forEach {
            if(currentNode.children[it] == null) {
                currentNode.children[it] = TrieNode(it, currentNode)
            }
            currentNode = currentNode.children[it]!!
            if(currentNode.isWordComplete) return
        }
        currentNode.isWordComplete = true
    }

    private fun getShortWord(text:String) : String {
        var currentNode = rootNode
        var word = ""
        text.forEach {
            if(currentNode.children[it] == null || currentNode.isWordComplete) return word
            currentNode = currentNode.children[it]!!
            word += it

        }
        return word
    }

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        dictionary.forEach {
            insertWord(it)
        }
        val words = sentence.split(" ")
        words.forEach {
            insertWord(it)
        }

        var line = ""
        words.forEach {
            val word = getShortWord(it)
            println(word)
            line += word
        }
        return line
    }
}

fun main() {
    Solution().apply {
        replaceWords(listOf("catt","cat","bat","rat"),"the cattle was rattled by the battery")
    }
}
