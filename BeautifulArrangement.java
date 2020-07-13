class Solution {
    int count;
    public int countArrangement(int N) {
        backtrack(N,1,new HashSet<Integer>());
        return count;
    }
    
    private void backtrack(int N, int index,HashSet<Integer> set){
        
        //base
       if(index == N+1){
           count++;
           return;
       }
            
            for(int i = 1;i <= N ; i++){
                //action
                if(!set.contains(i) && (i%index == 0 ||index%i ==0)){
                    set.add(i);
                //recurse
                    backtrack(N,index+1, set);
                //backtrack
                        set.remove(i);
                }
            }  
        
    }
}

/*
time complexity :O(k) where k is no of valid permutations 
Space complexity : O(1) hashSet used + recursive stack space +O(n)
*/