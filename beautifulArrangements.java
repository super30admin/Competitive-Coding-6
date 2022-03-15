class Solution {
    
    int noOfBefautifulArrangement = 0;
    
    public int countArrangement(int n) {
        countArrangementHelper(n, new HashSet<>(), 1);
        return noOfBefautifulArrangement;
    }
    
   // [2,1,3] -> 
     
   // O(n!) / number of beautiful arrangements
    
    private void countArrangementHelper(int n, Set<Integer> subset, int start)
    {
        // base case
        if (start > n)
        {
            noOfBefautifulArrangement++;
            return;
        }
        
        // choose i = 
        for (int i=1; i<=n; i++)
        {
            if (!subset.contains(i) && (i%start == 0 || start%i == 0))
            {
                subset.add(i);
                
                System.out.println("subset:"+subset);
                
                countArrangementHelper(n, subset, start+1);
                
                
                subset.remove(i);
                
                System.out.println("backtrack subset:"+subset);
            }
        }
    }    
}
