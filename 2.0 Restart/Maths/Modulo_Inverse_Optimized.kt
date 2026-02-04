class Solution {

    private fun getPowerByBinaryExponentiation(base:Int,exp:Int, mod:Int):Int {
        if(exp == 0) return 1
        if (exp == 1) return base % mod

        val pow = getPowerByBinaryExponentiation(base,exp/2,mod)

        val multi = ((pow.toLong() * pow.toLong()) % mod).toInt()

        return if (exp % 2 == 0) multi else ((multi.toLong() * base.toLong()) % mod).toInt()
    }
    private fun getModuloMultiplicativeInverse(a:Int,b:Int, mod:Int) {
        //We are using Fermat's little theorem
        //Fermat's says: n^p-1 % p == 1

        //We modify Fermat's
        //(a%mod) * (b^mod-2) % mod
        val res = (a % mod) * getPowerByBinaryExponentiation(b,mod-2,mod) % mod
        println(res)
    }

    fun doThis() {
        getModuloMultiplicativeInverse(50,24,5)      // 0
        getModuloMultiplicativeInverse(852,42,7)     // 0
        getModuloMultiplicativeInverse(10,3,7)       // 1
        getModuloMultiplicativeInverse(35,12,13)     // 4
    }
}
