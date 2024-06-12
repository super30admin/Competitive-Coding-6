/*
class Solution:
    def countArrangement(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        
        count = 0
        visited = set()
        
        def helper(N, pos):
            nonlocal count
            
            #base
            if len(visited) == N:
                count += 1
                return
            
            for i in range(N, 0, -1):
                #recurse
                if i not in visited and (i % pos == 0 or pos % i == 0):
                    visited.add(i)
                    helper(N, pos-1)

                    #backtrack
                    visited.remove(i)
        
        helper(n,n)
        return count
*/

// Time Complexity : O(N!) as everytime after adding element to set we have n-1 choices
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I started with for loop which went from N to 1 every time and I added 
// one element and then recursive call

class Solution {
    int count;
    Set<Integer> s;
    public int countArrangement(int N) {
        if (N == 0 || N == 1)
            return N;
        
        count = 0;
        s = new HashSet<>();
        helper(N, N);
        return count;
    }
    private void helper(int N, int pos){
        // base
        if (s.size() == N){
            count ++;
            return;
        }
            
        
        for (int i=N; i>0; i--){
            //recurse
            if (!(s.contains(i)) && (i % pos == 0 || pos % i == 0)){
                s.add(i);
                helper(N, pos-1);
                
                //backtrack
                s.remove(i);
            }
        }
    }
}