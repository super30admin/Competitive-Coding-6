// In this solution, we are using backtracking to find all the possible arrangements of number from 1 to n. 
//We use a boolean array to keep track of the numbers that are already used in the current arrangement. We start with first position 
// and try to fill it with all the numbers from 1 to n. If the number is not used and it is divisible by the position or the position is divisible by the number, we mark it as used(true) and move to the next position.
// If we reach the end of the arrangement, we increment the result and return. After exploring all the possibilities for the current position, we mark the number as unused(false) and backtrack to explore other possibilities.
// Time complexity is O(k) where k is the number of valid arrangements and space complexity is O(n) for the visited array.

class Solution {
    private lateinit var visited: BooleanArray
    var result = 0
    fun countArrangement(n: Int): Int {
        visited = BooleanArray(n + 1)
        helper(n, 1)
        return result
    }

    fun helper(n: Int, pivot: Int) {

        //base case
        if(pivot > n) {
            result++
            return
        }
        //logic


        for(i in 1 .. n) {
            if(!visited[i] && (i%pivot == 0 || pivot % i == 0)) {
                visited[i] = true
                helper(n, pivot + 1)
                visited[i] = false
            }
        }

    }
}