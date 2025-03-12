// Time Complexity: O(n!)
// Space Complexity: O(n) where n is the number of elements
// Did this code successfully run on Leetcode : Yes

//Approach:
// 1. Backtracking is used to find all the possible permutations of the numbers from 1 to n.
// 2. We will use a visited array to keep track of the numbers that have been visited.
// 3. We will start from the first position and check if the number is not visited and if it satisfies the condition of divisibility by the position or the position is divisible by the number.
// 4. If the condition is satisfied, we will mark the number as visited and move to the next position.
// 5. We will keep on doing this until we reach the end of the array and increment the count.
// 6. We will backtrack and mark the number as not visited and continue with the next number.

class Solution {
    int count = 0;
    public:
        int countArrangement(int n) {
           vector<bool> visited(n + 1);
           backtrack(n, visited, 1);
           return count;
        }
        void backtrack(int n, vector<bool>& visited, int position){
            //base case
            if(position > n){
                count++;
            }
            //logic
            for(int i = 1; i <= n; i++){
                if(visited[i] == false && (position % i == 0 || i % position == 0)){
                    //action
                    visited[i] = true;
                    //recurse
                    backtrack(n, visited, position + 1);
                    //backtrack
                    visited[i] = false;
                }
            }
        }
    };