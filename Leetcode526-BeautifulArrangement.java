//approach - 2 for loops
//TC: n! - everytime, we'll have n-1, n-2, n-3 . . . and so on permutations to figure out the beautiful arrrangement, but at every level it will decrease like in factorial series.
//sc: recursive stack :O(n!)

class Solution {
    int count;
    Set<Integer> visited;
    public int countArrangement(int n) {
        count =0;
        
        //base case
        if(n <=0) return -1;
        
        visited = new HashSet<>();
        helper(n, 1);
        
        return count;
    }
    
    private void helper(int n, int pos)
    {
        //base case
        // if(visited.size() ==n){
        //     count++;
        //     return;
        // }
        
        if(visited.size() ==n)
        {
            //System.out.println("*************** pos : "+pos+   ",  Set: "+ visited.toString());
            count++; return;
        }
        //logic
        //recurse
        for(int i= 1; i<= n; i++)
        {
           // System.out.println( "pos = "+pos+ " , i = "+i+   " Set: "+visited.toString());
            if(!visited.contains(i))
            {
              if(i%pos == 0 || pos%i == 0)
              {
                visited.add(i);
                //System.out.println("Added ---------> set "+visited.toString());

                helper(n, pos+1);
                  
                //back tracking
                //System.out.println("Remove -- "+i);
                visited.remove(i);
              }
                
            }
           
        }
       
    }
}