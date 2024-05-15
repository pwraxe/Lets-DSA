// FAILED CODE
//TEXT JUSTIFICATION

data class Info(
    val words: List<String>,
    val chars: Int,
    val space: Int,
    val currentLength: Int

)
class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val lines = mutableListOf<Info>()

        val currWord = mutableListOf<String>()
        var chars = 0
        var space = 0
        var currentLength = 0

        for (i in words.indices) {

            if (currentLength + words[i].length < maxWidth) {
                currWord.add(words[i])
                chars += words[i].length
                space += 1
                currentLength = chars + space
            }
            else {
                lines.add(Info(currWord.toList(),chars, space, currentLength))
                currWord.clear()

                currWord.add(words[i])

                chars = words[i].length
                space = 1
                currentLength = chars + space
            }
        }
        lines.add(Info(currWord.toList(),chars, space, currentLength))

        val result = mutableListOf<String>()


        //=======> I AM FAILING HERE <===========================================
        for (index in 0 ..< lines.size) {
            val info = lines[index]
            var line = ""
            val totalSpace = maxWidth - info.chars
            val actualSpace = info.words.size-1
            val spaceToAdd = if(actualSpace <= 0) 0 else totalSpace / actualSpace
            var extraSpace = if (actualSpace <= 0) totalSpace else totalSpace % actualSpace
            
            for (i in info.words.indices) {
                line += info.words[i]
                if (i < actualSpace) {
                    repeat(spaceToAdd) {
                        line += " "
                    }
                    if (extraSpace > 0) {
                        line += " "
                        extraSpace--
                    }
                }
            }
             
            result.add(line.padEnd(maxWidth,' '))

        }

        return result
    }
}
