//This Code is called Memorisation
class Solution {
  private val cache = hashMap<Int, Int>()
  fun fibbo(n: Int): Int {
    
    //if We have a result then return result, 
    if(cache.contains(n)) return cache.get(n)

    //Calculate result, 
    val result = if(n < 2) n else fibb(n-1) + fibb(n-2)

    //save to memory/cache
    cache[n] = result

    //retuen it
    return result
  }
}
