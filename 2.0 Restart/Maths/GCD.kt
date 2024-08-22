class Solution {

    //Way-1 = Naive | TC: O(min(a,b))
    fun gcd1(a: Int, b: Int): Int {

        var largest = 1
        for(i in 2 .. Math.min(a,b)) {
            if (a%i == 0 && b%i == 0) {
                largest = i
            }
        }
        return largest
    }

    //Way-2 = Naive | TC: O(min(a,b))
    fun gcd2(a: Int, b: Int): Int {
        var largest = 1
        for(i in Math.min(a,b) downTo 2) {
            if (a%i == 0 && b%i == 0) {
                largest = i
                break
            }
        }
        return largest
    }

    //Way-3 = Euclidean Subtractions | Iterative | TC: O(max(a,b))
    fun gcd3(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (x != y) {
            if (x > y) x -= y else y-= x
        }
        return x
    }

    //Way-4 = Euclidean Subtractions | Recursive | TC: O(max(a,b))
    fun gcd4(a: Int, b: Int): Int {
        if(a == 0) return b
        if (b == 0) return a
        return if (a > b) gcd4(a-b,b) else gcd4(a,b-a)
    }

    //Way-5 = Euclidean | Recursive | TC: O(log(max(a,b)))
    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a%b)
    }
}

fun main() {
    Solution().apply {
        val res = gcd(36,60)
        //println(res)
    }
}
