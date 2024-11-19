
// Time Complexity :O(number of beautiful combinations)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int count=0;
    HashSet<Integer> set;
    public int countArrangement(int n) {
        set= new HashSet<Integer>();
        backtrack(1,n,1); //1,3,1
        return count;
    }
    
    
    public void backtrack(int index, int n, int len){//checking all possible combninations
      //  System.out.println(len);
        if(len>n){
            count++;
            return;
        }
        
        for(int j=1;j<=n;j++){
            if(!set.contains(j) && (index%j==0 || j%index==0)){//1 -> 2//check we are not repeating the same number and it satidifes beautiful arrangement
                set.add(j);//add the same value to hashset so that we don't repeat it.
                backtrack(index+1,n,len+1);//2,3,2
                set.remove(j);
            }
            
        }
        
    }
}