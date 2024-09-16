//Time O(n!)
//Space O(n)

class Solution {
    
    int result;
    public int countArrangement(int n) {
          result =0;
       
         boolean[]visited = new boolean[n+1];
        helper( visited, 1,n);
       return result;    
    }
    
    private void helper( boolean[]visited, int index,int n)
    {
        if(index==n+1)
        {result++; return;}
        
        
        for(int i =1;i<=n;i++)
        {
            if(!visited[i] && (index%i==0 || i%index==0))
            {
                visited[i]=true; //action
                helper( visited, index+1,n); //recursion
                visited[i]=false;//backtrack
                
                
            }
           
            
        }
            
        
        
        
        
    }
    
}

