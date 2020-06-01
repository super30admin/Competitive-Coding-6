// Time Complexity : O(n!) for n number permutations
// Space Complexity : O(n) for HashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wasnt able to generate the permutations. Didnt thought of hashset to keep track of visited nodes
/* Your code here along with comments explaining your approach: As you explore permutations, maintain a HashSet. This will keep track of the nodes already visited in
finding the permutations, and wont explore the same values again at a particular instance. If the condition fails for any of the number in the temp set
then we can track back and begin exploring a new combination from the start. If the temp set reaches the length of n, we can check if the size == n,
then increment the count by one since they have already reached in that stage after all the elements of the set have passed the conditions.
*/
class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if(N <= 0){ return count;}
        HashSet<Integer> temp = new HashSet<>();                                        // Keep track of visited values
        Backtracking(N, 1, temp);
        return count;
    }
    private void Backtracking(int n, int i, HashSet<Integer> temp){     
        if((temp.size() % i) != 0 && (i % temp.size()) != 0){return;}                               // Violation detected, return no need to explore further
        if(temp.size() == n){                                                           // All the values satisfy in the set, increment the count
            count++;
            return;
        }
        for(int j = 1; j <= n; j++){
            if(!temp.contains(j)){                                                  // if the value is not in the set
            temp.add(j);
            Backtracking(n, j, temp);                                               // Start exploration
            temp.remove(j);                                                         // Explored, remove the value from the set, backtrack
            }
        }
    }
}