/*
Problem: https://leetcode.com/problems/beautiful-arrangement/
*/
class Solution {
    int result;
    public int countArrangement(int n) {
        result = 0;
        permutations(n, new ArrayList<>(), new HashSet<>());
        return result;
    }
    
    private void permutations(int n, List<Integer> curPermutation, HashSet<Integer> set) {
        if (curPermutation.size() == n) {
            ++result;
            return;
        }
        
        for (int i = 1; i <= n; ++i) {
            int indexToAdd = curPermutation.size() + 1;
            
            if (set.contains(i)) {
                continue;
            }
            
            if (indexToAdd % i != 0 && i % indexToAdd != 0) {
                continue;
            }
            curPermutation.add(i);
            set.add(i);
            permutations(n, curPermutation, set);
            curPermutation.remove(curPermutation.size() - 1);
            set.remove(i);
        }
    }
}

// Without actually keeping track of the current permutation
class Solution {
    int result;
    public int countArrangement(int n) {
        result = 0;
        boolean visited[] = new boolean[n + 1];
        backtrack(n, 1, visited);
        return result;
    }
    
    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            ++result;
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (pos % i != 0 && i % pos != 0)
                continue;
            if (visited[i])
                continue;
            
            visited[i] = true;
            backtrack(n, pos + 1, visited);
            visited[i] = false;
        }
    }
}