// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

fun main() {
    val n = 6
    val start = intArrayOf(1,3,0,5,8,5)
    val end = intArrayOf(2,4,6,7,9,9)
    println(maxMeetings(start, end, n))  //4
}

fun maxMeetings(start: IntArray, end: IntArray, n: Int) : Int {
    val pairs = mutableListOf<Pair<Int,Int>>()
    for (index in 0 until n) {
        pairs.add(Pair(start[index], end[index]))
    }

    var meetings = 1
    var prevMeeting = pairs.first()
    for (index in 1 until pairs.size) {
        val currentMeeting = pairs[index]
        if (currentMeeting.first > prevMeeting.second) {
            meetings++
            prevMeeting = currentMeeting
        }
    }
    return meetings
}
