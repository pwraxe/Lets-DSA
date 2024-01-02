// https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1

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

    val meetings = mutableListOf<Pair<Int,Int>>()
    val meetingIdx = mutableListOf<Int>()
    var prevMeeting = pairs.first()

    meetings.add(prevMeeting)
    meetingIdx.add(1)

    for (index in 1 until pairs.size) {
        val currentMeeting = pairs[index]
        if (currentMeeting.first > prevMeeting.second) {
            meetings.add(currentMeeting)
            meetingIdx.add(index+1)
            prevMeeting = currentMeeting
        }
    }

    println(meetings.toTypedArray().contentToString())   //[(1, 2), (3, 4), (5, 7), (8, 9)]
    println(meetingIdx.toTypedArray().contentToString()) //[1, 2, 4, 5]
    return meetings.size
}
