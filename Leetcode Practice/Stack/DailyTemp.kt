//Leetcode: 
class Solution {
    
    //BF Method
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }
 
        var next = 0
        
        for(index in 0 until temperatures.size-1) {
            next = index+1
            while(next < temperatures.size) {
                if(temperatures[next] > temperatures[index]) {
                    result[index] = next - index
                    break
                }
                next++
            }
        }
        return result
    }
}
