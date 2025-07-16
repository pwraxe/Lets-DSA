class Point(val x: Int, val y: Int)

class Solution  {

    //Get orientation of line (like cross product, is vector w is left side or right side of vector v)
    private fun getOrientation(p: Point, q: Point, r: Point): Int {
        val res = (q.x - p.x) * (r.y - p.y) - (q.y - p.y)*(r.x - p.x)
        return when {
            res == 0 -> 0   // Collinear
            res > 0 -> 1    // Clockwise
            else -> 2       // Counterclockwise
        }
    }

    //check is point is on segment or not
    private fun isOnSegment(p:Point, q: Point, r: Point): Boolean {
        return q.x in Math.min(p.x,r.x) .. Math.max(p.x, p.x) &&
               q.y in Math.min(p.y, r.y) .. Math.max(p.y, r.y)
    }

    //For check intersect, we will need 2 segment (4 points)
    private fun doesLineIntersect(p1: Point, q1: Point, p2: Point, q2:Point): Boolean {
        val o1 = getOrientation(p1,q1,p2)
        val o2 = getOrientation(p1,q1,q2)
        val o3 = getOrientation(p2,q2,p1)
        val o4 = getOrientation(p2,q2,q1)

        if (o1 != o2 && o3 != o4) return true

        if (o1 == 0 && isOnSegment(p1,q1,p2)) return true
        if (o2 == 0 && isOnSegment(p1,q1,p2)) return true
        if (o3 == 0 && isOnSegment(p2,q2,p1)) return true
        if (o4 == 0 && isOnSegment(p2,q2,p1)) return true

        return false
    }

    fun isPointInsidePolygon(points: List<Point>, point: Point): Boolean {
        if (points.size < 3) return false
        val horizontalLine = Point(10000,point.y)
        var current = 0
        var count = 0
        do {
            val next = (current+1) % points.size
            if (doesLineIntersect(points[current], points[next], point, horizontalLine)) {
                if (getOrientation(points[current], point, points[next]) ==  0) {
                    return isOnSegment(points[current], point, points[next])
                }
                count++
            }
            current = next
        }while (current != 0)

        //Odd: point is INSIDE, else OUTSIDE
        return count and 1 == 1
    }
}

fun main() {
    val points = listOf(
        Point(2,4),
        Point(4,5),
        Point(6,3),
        Point(4,1),
        Point(1,3),
        Point(6,5),
        Point(6,1),
        Point(2,6),
        Point(8,4),
        Point(1,1),
    )

    val insidePoint = Point(4,3)
    val outsidePoint = Point(8,2)
    Solution().apply {
        println("isPoint (4,3) inside? : ${isPointInsidePolygon(points,insidePoint)}")
        println("isPoint (8,2) inside? : ${isPointInsidePolygon(points,outsidePoint)}")
    }
}



Output
isPoint (4,3) inside? : true
isPoint (8,2) inside? : false
