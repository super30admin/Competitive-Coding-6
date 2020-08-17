//time complexity: O(number of valid permutations) as we stop probing down when at a particular position, the condition for beautiful position fails
//space complexity: O(N) where N is the length of the longest branch of the tree
//executed on leetcode: yes
/**approach: 
1. we use a boolean array to check if we have filled some number at that particular index.
2. to explore different combinations, we use backtracking
**/

class Solution {
    int result;
    boolean[] visited;
    public int countArrangement(int N) {
        visited = new boolean[N+1]; //index starts from zero, so we initialize an array of size one more than N
        helper(N,1); //second parameter is for position
        return result;
    }
    private void helper(int N,int position)
    {
        if(position>N) result++; // we have checked beautiful arrangement condition for all positions, this condition being true means that we have a valid permuatation
        for(int i=1;i<=N;++i)
        {
            if(visited[i]==false && (i%position==0 ||  position%i==0))
            {
                visited[i] = true;
                helper(N,position+1);
                visited[i] = false;
            }
        }
    }
}