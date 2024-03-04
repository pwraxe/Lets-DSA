import java.util.ArrayDeque
import java.util.PriorityQueue

class Assignment {
    fun generateBinNums(num:Int) {
        var n = num
        val queue = ArrayDeque<String>()
        queue.add("1")

        while (n-- > 0) {
            val s1 = queue.poll()
            println(s1)
            queue.offer("${s1}0")
            queue.offer("${s1}1")
        }
    }
    fun minCostToConnectRope(n:Int, len:IntArray): Int {
        val pq = PriorityQueue<Int> {a, b -> a-b }
        repeat(n) {
            pq.offer(len[it])
        }
        //len.forEach { pq.offer(it) }
        var res = 0
        while (pq.size > 1) {
            val first = pq.poll()
            val second = pq.poll()
            res += first + second
            pq.offer(first+second)
        }
        return res
    }
    fun jobSchedule(jobSeq: Array<Triple<Char,Int,Int>>) {
        jobSeq.sortByDescending { it.third }
        var count = 1
        var time = jobSeq.first().second
        var seq = "${jobSeq.first().first},"
        for (i in 1 ..< jobSeq.size) {
            val current = jobSeq[i]
            if (current.second > time) {
                count++
                seq += "${current.first},"
                time = current.second
            }
        }
        seq = seq.removeSuffix(",")
        println("$count = $seq")

    }
    fun reverseFirstKElement(k:Int, queue:ArrayDeque<Int>) {
        val temp = ArrayDeque<Int>()
        repeat(k) {
            temp.offer(queue.poll())
        }
        while (temp.isNotEmpty()) {
            queue.addFirst(temp.removeFirst())
        }

        println(queue.toTypedArray().contentToString())
    }
    fun maxOfSubArray(list:IntArray,k:Int) {
        var index = 0
        while (index < list.lastIndex) {
            if (index+k > list.size) break
            print("${list.copyOfRange(index,index+k).max()} ")
            index++
        }
    }
}

fun main() {
    Assignment().apply {
        generateBinNums(5)
        println(minCostToConnectRope(4, intArrayOf(4,3,2,6)))

        val jobSeq = arrayOf(
            Triple('a',4,20),
            Triple('b',1,10),
            Triple('c',1,40),
            Triple('d',1,30))
        jobSchedule(jobSeq)

        val queue = ArrayDeque<Int>().also {q->
            repeat(10) {
                q.offer((it+1) * 10)
            }
        }
        reverseFirstKElement(5,queue)
        maxOfSubArray(intArrayOf(1,2,3,1,4,5,2,3,6),3)
    }
}


1
10
11
100
101
29
2 = c,a
[50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
3 3 4 5 5 5 6 
