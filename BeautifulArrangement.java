// 526.
// time - O(k) - number of valid permutations - worst case n! if all permutations are valid
//space - O(n) - depth of call stack

class Solution {
    public int countArrangement(int N) {
        List<Set<Integer>> result = new ArrayList<>();
        
        //edge
        if(N <= 0)
        {
            return 0;
        }
        
        Set<Integer> path = new HashSet<>();
        helper(N, path, result);
        return result.size();
    }
    
    private void helper(int N, Set<Integer> path, List<Set<Integer>> result) {
        //base
        if(path.size() == N)
        {
            result.add(new HashSet<>(path));
            return;
        }
        //logic
        for(int i = 1; i <= N; i++)
        {
            if(!path.contains(i)) //to avoid duplicates
            {
                int position = path.size() + 1;
                if(i % position == 0 || position % i == 0)
                {
                    path.add(i); //add current i to path
                    helper(N, path, result); //recurse
                    path.remove(i); //backtrack - set is not indexed - so remove by element
                }
            }
        }
    }
}
