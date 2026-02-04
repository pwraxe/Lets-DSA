class Solution {
    private fun getInverse(b:Int, mod: Int): Int {
        for (x in 1 ..< mod) {
            if ((b*x) % mod == 1) return x
        }
        return -1
    }
    private fun getModuloMultiplicativeInverse(a:Int,b:Int, mod:Int) {
        //Since we cannot do (a/b) % mod

        //we convert division into multiplication,
        //hence we can do  ((a % mod *  pow(b,-1) % mod))%mod

        val inverse = getInverse(b%mod,mod)
        if (inverse != -1) {
            val moduloMultiplicativeInverse = ((a % mod) * inverse) % mod
            println(moduloMultiplicativeInverse)
        }
        else {
            println("No Modular Inverse Exists for $a, $b")
        }
    }

    fun doThis() {
        getModuloMultiplicativeInverse(50,24,10)    //No Modular Inverse Exists for 50, 24
        getModuloMultiplicativeInverse(852,42,7)    //No Modular Inverse Exists for 852, 42
        getModuloMultiplicativeInverse(10,3,7)      //1
        getModuloMultiplicativeInverse(35,12,13)    //4
    }
}

fun main() {
    Solution().doThis()
}
