Time complexity: O(n!)
Space complexity: O(n)

class BeautifulArrangements {
    int result = 0;
    public int countArrangement(int n) {
        HashSet<Integer> unique = new HashSet<Integer>();
        backtrack(n, unique, 1);
        return result;
    }

    private void backtrack(int n, HashSet<Integer> unique, int idx){
        //base
        if(idx > n) result++;

        //logic
        for(int i = 1; i<= n; i++){
            if(!unique.contains(i) && (idx % i == 0 || i % idx == 0)){
                unique.add(i);
                backtrack(n, unique, idx +1);
                unique.remove(i);
            }
        }
    }
}
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
