//Time Complexity - O(n!)
//Space Complexity - O(n)

class Solution {
    HashSet<Integer> set;
    int count = 0;
    public int countArrangement(int n) {
      //hashMap
      set = new HashSet<>();
      if(n == 0) return 0;
      helper(n,1);
      return count;
        
    }
  
   private void helper(int n,int pos){
     //base
     if(set.size() == n) {
       count ++;
       return;
     }
     
     //logic
     for(int i = 1; i<= n; i++) {
       if(!set.contains(i)) {
         if(pos %i == 0 || i%pos == 0) { // if condidition satisfy and number is not in the set then add no in the set
           //action
           set.add(i);
           helper(n,pos+1);
           //back track the action
           set.remove(i);
         }
       }
     }
   }
}