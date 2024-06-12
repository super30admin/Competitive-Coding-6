// Time Complexity : O(num of valid permutations)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int N) {
        
        if(N==0)
            return 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++)
            list.add(i);
        
        helper(list,0);
        return count;
    }
    
    private void helper (List<Integer> list, int first){
        
        if(first==list.size()){
            if(isValid(list))
                count++;
            return;
        }
        
        for(int i=first;i<list.size();i++){
            Collections.swap(list,i,first);
            if(((first+1)%list.get(first)!=0) && (list.get(first)%(first+1)!=0)){
                Collections.swap(list,i,first);
            }
            else{
            helper(list,first+1);
            Collections.swap(list,i,first);
            }
        }
        
    }
    
    private boolean isValid(List<Integer> list){
        
        //logic
        for(int i=1;i<=list.size();i++)
            if((i%list.get(i-1)!=0) && (list.get(i-1)%i!=0)) return false;
        return true;
    }
}